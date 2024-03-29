package com.example.apiconsultas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiconsultas.model.Usuario;
import com.example.apiconsultas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	//atualização de usuario
	public Usuario salvarUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
	
	//retorna o usuario no momento do Login - READ
	public Usuario obterUsuario(String email, String senha) {
		Usuario usuarioBuscado = new Usuario(email, senha);
		Usuario usuarioObtido = repository.findByEmail(email);
		
		if(usuarioExiste(usuarioObtido) && usuarioValido(usuarioObtido, usuarioBuscado)){
			return usuarioObtido;
		}
		else {
			return null;
		}
	}

	private boolean usuarioExiste(Usuario usuarioObtido) {
		return usuarioObtido != null;
	}
	
	private boolean usuarioValido(Usuario usuarioObtido, Usuario usuarioBuscado) {
		return 
			usuarioObtido.getEmail().equals(usuarioBuscado.getEmail()) &&
			usuarioObtido.getSenha().equals(usuarioBuscado.getSenha());
	}
	
	
}
