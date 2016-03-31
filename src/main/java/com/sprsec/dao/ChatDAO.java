package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.Chat;

public interface ChatDAO {

    //recupère la liste de tous des chats de la bdd
    List<Chat> listeChat();

    //permet de chercher un chat spécifique dans la barre de recherche du site
    Chat rechercheParNom(String nom);

    //recupère seulement la liste des chats rares
    List<Chat> listeChatRare();

    //recupère seulement la liste des chats communs
    List<Chat> listeChatCommun();
}
