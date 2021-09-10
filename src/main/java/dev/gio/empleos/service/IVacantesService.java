package dev.gio.empleos.service;

import java.util.List;

import dev.gio.empleos.model.Vacante;

public interface IVacantesService {

	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
}
