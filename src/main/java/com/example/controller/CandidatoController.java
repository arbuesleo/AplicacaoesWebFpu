package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.domain.Candidato;
import com.example.repository.CanditatoRepository;

@Controller
public class CandidatoController {
	@Autowired
	CanditatoRepository candidatoRepo;
	Integer numeroVoto;
	
	@GetMapping("/admin")
	public String candidatoGet(Model model) {	
		model.addAttribute("candidatos",  candidatoRepo.findAll());		
		return "admin";
	}
	
	@GetMapping("/frmAddCandidato")
	public String newCandidato(Model model) {		
		Candidato candidato = new Candidato(0,"", "", 0, "", 0.00f);
		model.addAttribute("candidato", candidato);
		return "addCandidato";
	}
	
	@GetMapping("/frmEditCandidato")
	public String editCandidato(Model model, @RequestParam(value = "id") Integer id) {	
		Candidato c = candidatoRepo.findById(id);
		model.addAttribute("candidato", c);
		if(c != null)
			return "addCandidato";
		return this.candidatoGet(model);	
	}
	
	@PostMapping("/frmSaveCandidato")
	public String candidatoSubmit(@ModelAttribute Candidato candidato, Model model) {
		if (candidato.getId() == 0)
			candidato.setVotos(0.00f);
		else
			candidato.setVotos(candidatoRepo.findById(candidato.getId()).getVotos());
		
		candidatoRepo.save(candidato);
		return this.candidatoGet(model);
	}
	
	@GetMapping("/deleteCandidato")
	public String delteCandidato(Model model, @RequestParam(value = "id") Integer id) {	
		Candidato c = candidatoRepo.findById(id);
		if(c != null)
			candidatoRepo.delete(c);
		return this.candidatoGet(model);	
	}
	
	@GetMapping("/")
	public String votar(Model model) {	
		Candidato c = new Candidato();	
		model.addAttribute("candidato", c);
		return "votar";	
	}
	
	@PostMapping("/confirmVoto")
	public String confirmaVoto(Model model, @ModelAttribute Candidato candidato) {		
		Candidato c = candidatoRepo.findByNumero(candidato.getNumero());
		if (c == null)
			return "error";
		model.addAttribute("candidato", c);
		return "confirmaVoto";	
	}
	
	@GetMapping("/adicionaVoto")
	public String votar(Model model, @RequestParam(value = "id") Integer id) {		
		Candidato c = candidatoRepo.findById(id);
		c.addVoto();
		candidatoRepo.save(c);
		return "success";	
	}
	
	@GetMapping("/resultado")
	public String getResultado(Model model) {		
		model.addAttribute("candidatos", candidatoRepo.findAllByOrderByVotosDesc());
		return "resultado";	
	}
	
}
