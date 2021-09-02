package dev.gio.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.gio.empleos.model.Vacante;

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
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero en Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Asistente de Ventas");
		lista.add("Arquitecto de software");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero en Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(18000.0);
		model.addAttribute(vacante);
		return "detalle";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	/**
	 * Método que regresa una lista de objetos tipo Vacante
	 * @return
	 */
	private List<Vacante> getVacantes(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		
		Vacante vac1 = new Vacante();
		Vacante vac2 = new Vacante();
		Vacante vac3 = new Vacante();
		Vacante vac4 = new Vacante();
		
		try {
			
			vac1.setId(1);
			vac1.setNombre("Ingeniero Civil");
			vac1.setDescripcion("Se solicita un Ing. Civil para el diseño de un puente peatonal.");
			vac1.setFecha(sdf.parse("28-08-2021"));
			vac1.setSalario(35000.0);
			vac1.setDestacado(0);
			vac1.setImagen("w.png");
			
			vac2.setId(2);
			vac2.setNombre("Contador Público");
			vac2.setDescripcion("Estamos en busqueda de un Contador Publico para llevar una nómina de importante empresa de software");
			vac2.setFecha(sdf.parse("22-03-2021"));
			vac2.setSalario(15000.0);
			vac2.setDestacado(1);
			vac2.setImagen("circle.jpg");
			
			vac3.setId(3);
			vac3.setNombre("Ingeniero Eléctrico");
			vac3.setDescripcion("Solicitamos un Ingeniero Eléctrico para el mantenimiento de instalación eléctrica de un edificio de 20 pisos");
			vac3.setFecha(sdf.parse("15-05-2021"));
			vac3.setSalario(23000.0);
			vac3.setDestacado(0);
			vac3.setImagen("global_marketing.png");
			
			vac4.setId(4);
			vac4.setNombre("Ingeniero Químico");
			vac4.setDescripcion("Se solicita un Ingeniero Químico para la fabricación de estupefacientes");
			vac4.setFecha(sdf.parse("17-04-2021"));
			vac4.setSalario(85000.0);
			vac4.setDestacado(1);
			//vac4.setImagen("samsung.jpg");
			
			lista.add(vac1);
			lista.add(vac2);
			lista.add(vac3);
			lista.add(vac4);
			
		} catch(ParseException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return lista;
	}
} 
