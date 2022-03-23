package dev.gio.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gio.empleos.model.Categoria;
import dev.gio.empleos.repository.CategoriasRepository;
import dev.gio.empleos.service.ICategoriasService;

@Service
public class CategoriasServiceJpa implements ICategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	@Override
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		return categoriasRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional <Categoria> optional = categoriasRepo.findById(idCategoria);
		return null;
	}

}
