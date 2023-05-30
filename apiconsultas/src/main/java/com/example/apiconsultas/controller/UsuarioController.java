package com.example.apiconsultas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiconsultas.model.Usuario;
import com.example.apiconsultas.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@PostMapping(path = "/{email}/{senha}")
	public Usuario cadastrarUsuario(@PathVariable String email, @PathVariable String senha) {
		return usuarioService.cadastrarUsuario(email, senha);
	}
	
	@GetMapping(path = "/{email}/{senha}")
	public Usuario obterUsuario(@PathVariable String email, @PathVariable String senha){
		return usuarioService.obterUsuario(email, senha);
	}
}
