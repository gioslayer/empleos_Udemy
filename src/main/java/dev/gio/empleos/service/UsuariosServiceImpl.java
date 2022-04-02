package dev.gio.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.gio.empleos.model.Perfil;
import dev.gio.empleos.model.Usuario;

@Service
//@Primary
public class UsuariosServiceImpl implements IUsuariosService {

	private List<Usuario> lista = null; 
	private List<Perfil> perfiles = null;
	
	public UsuariosServiceImpl() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Usuario>();
		perfiles = new LinkedList<Perfil>();
		
		Usuario user1 = new Usuario();
		Usuario user2 = new Usuario();
		Usuario user3 = new Usuario();
		
		try {
			
			user1.setId(1);
			user1.setNombre("Giovanni Peña Cedillo");
			user1.setUsername("Megaslayer");
			user1.setEstatus(1);
			user1.setFechaRegistro(sdf.parse("22-03-1991"));
			user1.setEmail("giovanni_slayer@hotmail.com");
			user1.setPassword("12345678");
			user1.setPerfiles(perfiles);
			
			user2.setId(2);
			user2.setNombre("Giovanni Peña Cedillo 2");
			user2.setUsername("Megaslayer2");
			user2.setEstatus(1);
			user2.setFechaRegistro(sdf.parse("15-05-1965"));
			user2.setEmail("giovanni_slayer2@hotmail.com");
			user2.setPassword("12345678222");
			user2.setPerfiles(perfiles);
			
			user3.setId(3);
			user3.setNombre("Giovanni Peña Cedillo 3");
			user3.setUsername("Megaslayer3");
			user3.setEstatus(0);
			user3.setFechaRegistro(sdf.parse("05-06-1989"));
			user3.setEmail("giovanni_slayer3@hotmail.com");
			user3.setPassword("12345678333");
			user3.setPerfiles(perfiles);
			
			lista.add(user1);
			lista.add(user2);
			lista.add(user3);
			
		}catch(ParseException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	@Override
	public void guardar(Usuario usuario) {
		lista.add(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		lista.remove(idUsuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return lista;
	}

}
