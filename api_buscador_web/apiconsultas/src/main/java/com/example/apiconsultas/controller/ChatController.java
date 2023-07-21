package com.example.apiconsultas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiconsultas.model.Chat;
import com.example.apiconsultas.service.ChatService;

@RestController
@RequestMapping(value = "/chat")
@CrossOrigin
public class ChatController{
	
	@Autowired 
	private ChatService chatService;
	
	@PostMapping
	public Chat criarChat(@RequestBody Chat chat) {
		return chatService.criarChat(chat); 
	}
	
	@DeleteMapping
	public void removerChat(@RequestBody Chat chat) {
		chatService.deleteChat(chat);
	}
	
}
