package com.sprsec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.ChatDAO;
import com.sprsec.model.Chat;


@Service("chatService")
@Transactional
public class ChatServiceImpl implements ChatService{
	@Autowired
	private ChatDAO chatDAO;

	public Chat rechercherParNom(String nom) {
		return chatDAO.rechercheParNom(nom);
	}

	public List<Chat> listeChat() {
		return chatDAO.listeChat();
	}

	@Override
	public List<Chat> listeChatRare() {
		return chatDAO.listeChatRare();
	}

	@Override
	public List<Chat> listeChatCommun() {
		return chatDAO.listeChatCommun();
	}
}
