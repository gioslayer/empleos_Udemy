package dev.gio.empleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.gio.empleos.model.Categoria;
import dev.gio.empleos.model.Vacante;
import dev.gio.empleos.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	@Autowired
//	@Qualifier("categoriasServiceJpa")
	private ICategoriasService serviceCategorias;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> listaCategorias = serviceCategorias.buscarTodas();
		model.addAttribute("listaCategorias", listaCategorias);
		return "categorias/listCategorias";
	}
	
	@GetMapping(value="/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria> lista = serviceCategorias.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listCategorias";
	}
	
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	@GetMapping("/create")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	//@RequestMapping(value="/save", method=RequestMethod.POST)
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio el error: "+error.getDefaultMessage());
			}
			return "categorias/listCategorias";
		}
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro guardado");
		System.out.println("Categoria: " + categoria);
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCategoria, Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, Model model, RedirectAttributes attributes) {
		System.out.println("Borrando la categoria con el id: " + idCategoria);
		try{
			serviceCategorias.eliminar(idCategoria);
			attributes.addFlashAttribute("msg", "La categoria fue eliminada");
		}catch(Exception ex){
			attributes.addFlashAttribute("msg", "No es posible eliminar la categoria seleccionada");
		}
		return "redirect:/categorias/index";
	}
}
