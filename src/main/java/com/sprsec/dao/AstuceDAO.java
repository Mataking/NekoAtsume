package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.AjoutAstuce;
import com.sprsec.model.Astuce;

public interface AstuceDAO {
    
    //récupérer les astuces de tous les chats
    public List<Astuce> getAllAstuce();

    //récupérer les astuces d'un chats en fonction de son nom
    public List<Astuce> getAstuce(String chatname);

    //ajouter une astuce pour un chat
    public void addAstuce(AjoutAstuce Ajoutastuce);

    public Astuce getAstuceById(int id);

    //ajoute +1 au vote plus de l'astuce
    public void addPlus(Astuce astuce);

    //ajoute +1 au vote moins de l'astuce
    public void addMoins(Astuce astuce);

    //permet a l'admin de supprimer une astuce
    public void deleteAstuce(int id);
}
