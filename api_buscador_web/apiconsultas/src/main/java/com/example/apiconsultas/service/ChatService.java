package com.example.apiconsultas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiconsultas.model.Chat;
import com.example.apiconsultas.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public Chat criarChat(Chat chat) {
		return chatRepository.save(chat);
	}
	
	public void deleteChat(Chat chat) {
		chatRepository.delete(chat);
	}
	
}
