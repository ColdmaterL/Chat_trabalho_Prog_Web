package com.example.apiconsultas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String senha;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Chat> chats = new ArrayList<>();

	public Usuario(String email, String senha) {
		super();
		this.senha = senha;
		this.email = email;
	}
	
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public void adicionarChat(Chat chat) {
		chats.add(chat);
	}
	
	public void removerChat(Chat chat) {
		chats.remove(chat);
	}
	
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	
	public List<Chat> getChats(){
		return this.chats;
	}
	
}
