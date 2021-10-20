package dev.gio.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.gio.empleos.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

	private List<Categoria> lista = null;
	
	public CategoriasServiceImpl() {
		lista = new LinkedList<Categoria>();
		
		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();
		Categoria cat3 = new Categoria();
		Categoria cat4 = new Categoria();
		
		cat1.setId(1);
		cat1.setNombre("Ventas");
		cat1.setDescripcion("Solo ventas");
		
		cat2.setId(2);
		cat2.setNombre("Atención a clientes");
		cat2.setDescripcion("Atención de llamadas a los clientes");
		
		cat3.setId(3);
		cat3.setNombre("Sanidad y Salud");
		cat3.setDescripcion("Referente a cuidados de personas");
		
		cat4.setId(4);
		cat4.setNombre("Turismo y Restauración");
		cat4.setDescripcion("Atención a clientes en busca de destino para hacer turismo");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
	}
	
	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return lista;
		
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		
		for(Categoria c : lista) {
			if(c.getId() == idCategoria) {
				return c;
			}
		}
		return null;
	}
	
}
