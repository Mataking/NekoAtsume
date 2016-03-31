package com.sprsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.model.User;
import com.sprsec.service.UserService;

//Classe de sécurité, l'utilisateur est obligé d'être connecté pour consulter le site web

@Controller
public class SecurityNavigation {

    @Autowired
    UserService userService;

    //Servlet
    //affiche la page de connexion lors de l'arrivé sur le site
    @RequestMapping(value = {"/", "/user-login.html"}, method = RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("login-form");
    }

    //Servlet POST
    //recupère les logs de connexion est vérifie si l'utilisateur 
    //est admin ou simple utilisateur puis retourne le user vers l'acceuil du site
    @RequestMapping(value = {"/user-login"}, method = RequestMethod.POST)
    public String loginOk(@RequestParam("login") String login, ModelMap mod) {
        User existinguser = userService.getUser(login);
        if (login.equals("admin")) {
            System.out.println("je suis l'administrateur");
            mod.addAttribute("adm", true);
        }
        System.out.println("je suis un utilisateur");
        mod.addAttribute("userlog", existinguser.getLogin());
        return "acceuil";
    }

    //Servlet
    //retourne la page de connexion avec une erreur en cas d'erreur de log 
    //ou si l'utilisateur n'est pas enregistré
    @RequestMapping(value = "/error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

}
