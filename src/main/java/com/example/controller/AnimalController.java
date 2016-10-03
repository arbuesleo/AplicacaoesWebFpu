package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Animal;
import com.example.repository.AnimalRepository;

@Controller
public class AnimalController {
	@Autowired
	AnimalRepository animalRepo;
	
	
	@GetMapping("/frmAnimal")
	public String animalGet(Model model) {	
		model.addAttribute("animais",  animalRepo.findAll());		
		return "frmAnimal";
	}
	
	@GetMapping("/frmManterAnimal")
	public String newAnimal(Model model) {		
		Animal animal = new Animal(0, "", false, null, "");
		model.addAttribute("animal", animal);
		return "frmManterAnimal";
	}

	
	@PostMapping("/frmManterAnimal")
	public String animalSubmit(@ModelAttribute Animal animal, Model model) {
		animalRepo.save(animal);
		return this.animalGet(model);
	}
	
	@GetMapping("/frmEditarAnimal")
	public String editAnimal(Model model, @RequestParam(value = "id") Integer id) {	
		Animal a = animalRepo.findById(id);
		model.addAttribute("animal", a);
		if(a != null)
			return "frmManterAnimal";
		return this.animalGet(model);
		
	}
	
	@GetMapping("/deleteAnimal")
	public String delteAnimal(Model model, @RequestParam(value = "id") Integer id) {	
		Animal a = animalRepo.findById(id);
		if(a != null)
			animalRepo.delete(a);
		return this.animalGet(model);	
	}
	
	public void teste() {	
		System.out.print("Teste");
	}
}
