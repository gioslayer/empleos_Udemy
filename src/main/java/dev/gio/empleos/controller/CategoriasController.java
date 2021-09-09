package dev.gio.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex() {
		return "categorias/listCategorias";
	}
	
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	@GetMapping("/create")
	public String crear() {
		return "categorias/formCategoria";
	}
	
	//@RequestMapping(value="/save", method=RequestMethod.POST)
	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		System.out.println("Categoria: " + nombre);
		System.out.println("Descripción: " + descripcion);
		return "categorias/listCategorias";
	}
}
