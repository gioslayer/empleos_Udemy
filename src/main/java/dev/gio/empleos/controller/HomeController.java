package dev.gio.empleos.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		model.addAttribute("mensaje", "Bienvenidos a mi Aplicación de Empleos");
		model.addAttribute("fecha", new Date());
		*/
		String nombre = "Programador Full Stack";
		Date fecha = new Date();
		double salario = 18000;
		boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fecha);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
	}
} 
