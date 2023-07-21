package com.example.apiconsultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiconsultas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
