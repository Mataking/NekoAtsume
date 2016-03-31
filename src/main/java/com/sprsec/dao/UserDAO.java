package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.Chat;
import com.sprsec.model.User;

public interface UserDAO {

    //recupère un utilisateur en fonction de son pseudo
    public User getUser(String login);

    //recupère un utilisateur en fonction de son id
    public User getUserById(int id);

    //methode d'ajout d'un nouvel utilisateur lors de phase d'inscription
    public void add(User user);

    //update un utilisateur si ce dernier décide changer de mot de passe ou d'adresse mail
    public void edit(User user);

    //recupère tous les utilisateurs inscrits
    public List<User> listeUser();

    //permet a l'admin de supprimer un utilisateur
    public void deleteUser(int id);
}
