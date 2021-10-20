package dev.gio.empleos.service;

import java.util.List;

import dev.gio.empleos.model.Categoria;

public interface ICategoriasService {
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);
}


/**
 * Ejericio 2
 * 
 * 1.- Crear la clase CategoriasServiceImpl que implemente esta inferfaz
 * 
 * 2.- Inyectar la clase de servicio en CategoriasController
 * 
 * 3.- Complementar los siguientes métodos en CategoriasController
 * 
 * 		mostrarIndex -> Renderizar el listado de Categorias (listCategorias.html)
 * 						Configurar la URL del boton para crear una categoria
 * 
 * 		guardar -> 	Guardar el objeto Categoria a traves de la clase de servicio
 * 					Validar errores de Data Binding y mostrarlos al usuario en caso de haber
 * 					Mostrar al usuario mensaje de confirmación de registro guardado
 * 
 * 4.- Agregar un nuevo menú llamado Categorias y configurar la URL al listado de Categorias
 * 
 */