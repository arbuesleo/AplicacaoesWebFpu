package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Cliente;
import com.example.repository.ClienteRepository;

@Controller
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/cliente")
	public String index() {
		return "form";
	}

	@GetMapping("/form")
	public String clienteGet(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "form";
	}

	@PostMapping("/form")
	public String clienteSubmit(@ModelAttribute Cliente cliente, Model model) {
		clienteRepository.save(cliente);
		model.addAttribute("clientes", clienteRepository.findAll());		
		return "list";
	}

}
