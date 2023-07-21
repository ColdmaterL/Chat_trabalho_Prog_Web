package com.example.apiconsultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiconsultas.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{

}
