package dev.gio.empleos.service;

import java.util.List;

import dev.gio.empleos.model.Usuario;

public interface IUsuariosService {

	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario> buscarTodos();
	Usuario buscarPorUsername(String username);
	/**Ejercicio: Implementar método para registrar un nuevo usuario
	 * 1.- Usar la plantilla del archivo formRegistro.html
	 * 2.- El método para mostrar el formulario para registrar y el método para guardar el usuario deberá
	 * 	   estar en el Controlador de HomeController
	 * 3.- Al guardar el usuario se le asignará el perfil USUARIO y la fecha de registro
	 * 	   sera la fecha actual del sistema.*/
}
