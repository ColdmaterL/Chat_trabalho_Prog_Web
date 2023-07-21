package com.example.apiconsultas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiconsultas.model.Usuario;
import com.example.apiconsultas.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired  
	private UsuarioService usuarioService;
	
	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.salvarUsuario(usuario);
	}
	
	@GetMapping(path = "/{email}/{senha}")
	public Usuario obterUsuario(@PathVariable String email, @PathVariable String senha){
		return usuarioService.obterUsuario(email, senha);
	}  
}

  