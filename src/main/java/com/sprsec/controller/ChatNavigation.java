package com.sprsec.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprsec.model.AjoutAstuce;
import com.sprsec.model.Astuce;
import com.sprsec.model.Chat;
import com.sprsec.model.User;
import com.sprsec.service.AstuceService;
import com.sprsec.service.ChatService;

//classe de navigation a travers les url concernant les chats et la liste des chats

@Controller
public class ChatNavigation {

    @Resource(name = "chatService")
    ChatService chatService;

    @Resource(name = "astuceService")
    AstuceService astuceService;

    //servlet
    //recupère la liste des chats de la bdd quand /chats est tapé dans l'url du navigateur
    @RequestMapping(value = {"/chats"}, method = RequestMethod.GET)
    public String listChat(Model model) {
        List<Chat> chats = chatService.listeChat();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "chats";
    }

    //servlet
    //recupère la liste des chats rare de la bdd quand /rare est tapé dans l'url du navigateur
    @RequestMapping(value = {"/rare"}, method = RequestMethod.GET)
    public String listChatRare(Model model) {
        List<Chat> chats = chatService.listeChatRare();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "chats";
    }

    //servlet
    //recupère la liste des chats normaux/communs de la bdd quand /communs est tapé dans l'url du navigateur
    @RequestMapping(value = {"/communs"}, method = RequestMethod.GET)
    public String listChatCommun(Model model) {
        List<Chat> chats = chatService.listeChatCommun();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "chats";
    }
    //servlet
    //recupère la liste des chats quand on se connecte en admin de la bdd
    @RequestMapping(value = {"/admin-chats"}, method = RequestMethod.GET)
    public String listChatAdm(Model model) {
        List<Chat> chats = chatService.listeChat();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "admin-chats";
    }

    //servlet
    //recupère la liste des astuces des chats de la bdd
    @RequestMapping(value = {"/astuces"}, method = RequestMethod.GET)
    public String listAstuce(Model model) {
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        Astuce astc = new Astuce();
        model.addAttribute("voteplus", astc);
        return "astuce";
    }

    //servlet
    //recupère la liste des astuces en mode de connexion admin des chats de la bdd
    @RequestMapping(value = {"/admin-astuces"}, method = RequestMethod.GET)
    public String listAstuceAdm(Model model) {
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "admin-astuces";
    }

    //servlet POST
    //recupère le chat quand un nom de chat est entré dans la barre de recherche
    @RequestMapping(value = {"/chats"}, method = RequestMethod.POST)
    public String rechercheChat(@RequestParam("searchText") String nom, Model model) {
        System.out.println(nom);
        Chat chats = chatService.rechercherParNom(nom);
        model.addAttribute("listechat", chats);
        model.addAttribute("find", true);
        return "chats";
    }

    //servlet
    //recupère la liste des astuces concernant un chat spécifique
    @RequestMapping(value = {"/astuce-{chatname}"}, method = RequestMethod.GET)
    public String getCatAstuce(@PathVariable("chatname") String chatnom, Model model, Principal principal) {
        System.out.println(chatnom);
        Chat chats = chatService.rechercherParNom(chatnom);
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);

        AjoutAstuce ajoutAstuce = new AjoutAstuce();
        model.addAttribute("ajout", ajoutAstuce);
        List<Astuce> astuce = astuceService.getAstuce(chatnom);
        model.addAttribute("listastuce", astuce);

        Astuce astc = new Astuce();
        model.addAttribute("voteplus", astc);

        return "chats";
    }

    //servlet
    //recupère la liste des astuces des chats de la bdd
    @RequestMapping(value = {"/astuce-{chatname}"}, method = RequestMethod.POST)
    public String saveAstuce(@ModelAttribute("ajout") AjoutAstuce ajout, @PathVariable("chatname") String chatnom,
            ModelMap model) {
        astuceService.addAstuce(ajout);
        Chat chats = chatService.rechercherParNom(chatnom);
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);
        List<Astuce> astuce = astuceService.getAstuce(chatnom);
        model.addAttribute("listastuce", astuce);
        return "chats";
    }

    //servlet POST
    //affiche et ajoute un vote plus lors de l'action "vote plus"
    @RequestMapping(value = {"/voteplus-{idastuce}"}, method = RequestMethod.POST)
    public String votePlus(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addPlus(astc);
        Chat chats = chatService.rechercherParNom(astc.getNomchat());
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);
        List<Astuce> astuce = astuceService.getAstuce(astc.getNomchat());
        model.addAttribute("listastuce", astuce);
        AjoutAstuce ajoutAstuce = new AjoutAstuce();
        model.addAttribute("ajout", ajoutAstuce);
        return "chats";
    }

    @RequestMapping(value = {"/astuceplus-{idastuce}"}, method = RequestMethod.POST)
    public String astucePlus(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addPlus(astc);
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "astuce";
    }
    
    //servlet POST
    //affiche et ajoute un vote moins lors de l'action "vote moins"
    @RequestMapping(value = {"/votemoins-{idastuce}"}, method = RequestMethod.POST)
    public String voteMoins(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addMoins(astc);
        Chat chats = chatService.rechercherParNom(astc.getNomchat());
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);
        List<Astuce> astuce = astuceService.getAstuce(astc.getNomchat());
        model.addAttribute("listastuce", astuce);
        AjoutAstuce ajoutAstuce = new AjoutAstuce();
        model.addAttribute("ajout", ajoutAstuce);
        return "chats";
    }

    @RequestMapping(value = {"/astucemoins-{idastuce}"}, method = RequestMethod.POST)
    public String astuceMoins(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addPlus(astc);
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "astuce";
    }

    /*
		 @RequestMapping("/supprimer-{id}")
	public String removeUser(@PathVariable("id")int id, Model model){
		userService.deleteUser(id);
		List<User>users = userService.listeUser();
		model.addAttribute("listuser", users);
		return "admin-users";
	}
     */
    
    @RequestMapping(value = "/supprimerastuce-{id}")
    public String removeAstuce(@PathVariable("id") int id, Model model) {
        astuceService.deleteAstuce(id);
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "admin-astuces";
    }

}
