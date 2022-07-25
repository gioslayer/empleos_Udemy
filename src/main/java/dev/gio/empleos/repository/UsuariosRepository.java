package dev.gio.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gio.empleos.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
