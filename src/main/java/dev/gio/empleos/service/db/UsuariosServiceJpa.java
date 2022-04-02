package dev.gio.empleos.service.db;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.gio.empleos.model.Perfil;
import dev.gio.empleos.model.Usuario;
import dev.gio.empleos.repository.UsuariosRepository;
import dev.gio.empleos.service.IUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuariosRepo.findAll();
	}

}
