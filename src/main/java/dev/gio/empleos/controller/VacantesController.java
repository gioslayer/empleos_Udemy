package dev.gio.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.gio.empleos.model.Vacante;
import dev.gio.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		System.out.println("IdVacante: " + vacante);
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando la vacante con el id: " + idVacante);
		model.addAttribute("idVacante", idVacante);
		return "mensaje";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";
	}
	
	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estatus") String estatus,
			@RequestParam("fecha") String fecha,
			@RequestParam("destacado") int destacado,
			@RequestParam("salario") double salario,
			@RequestParam("detalles") String detalles) {
		System.out.println("Nombre de vacante: " + nombre);
		System.out.println("Descripción: " + descripcion);
		System.out.println("Estatus: " + estatus);
		System.out.println("Fecha de Publicación: " + fecha);
		System.out.println("Destacado: " + destacado);
		System.out.println("Salario Ofrecido: " + salario);
		System.out.println("Detalles: " + detalles);
		return "vacantes/listVacantes";
	}
}
