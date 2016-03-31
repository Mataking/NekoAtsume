package com.sprsec.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.model.Chat;
import com.sprsec.model.User;
import com.sprsec.service.UserService;


//classe de navigation au travers des url concernant la navigation global sur le site

@Controller
public class LinkNavigation {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    UserService userService;

    //Servlet
    //Affiche l'accueil du site quand l'url contient /index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        return new ModelAndView("accueil");
    }

    //Servlet
    //Affiche l'accueil du site quand l'url contient /index
    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String ModerationPage(Model model, Principal principal) {
        model.addAttribute("title", "Moderation Page");
        SecurityContext sc = SecurityContextHolder.getContext();
        System.out.println(sc.toString());
        String userName = principal.getName();
        if (userName.equals("admin")) {
            System.out.println("je suis l'administrateur");
            model.addAttribute("adm", true);
        } else {
            System.out.println("je suis un utilisateur");
        }

        model.addAttribute("message", "WELCOME mr " + userName);
        return "accueil";
    }

    //Servlet
    //Affiche l'accueil de navigation pour un utilisateur admin
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView firstAdminPage() {
        return new ModelAndView("admin-first");
    }

    //Servlet
    //Affiche la liste de tous les utilisateur enregistrés sur dans la bdd
    @RequestMapping(value = "/admin-users", method = RequestMethod.GET)
    public String listUser(Model model) {
        List<User> users = userService.listeUser();
        model.addAttribute("listuser", users);
        return "admin-users";
    }

    //Servlet
    //********ADD USER
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {
        userService.addUser(user);

        model.addAttribute("log", true);
        model.addAttribute("userLog1", user.getLogin());
        model.addAttribute("userLog2", user.getPassword());
        return "login-form";
    }
    //*****END ADD USER

    //---------EDIT USER
    @RequestMapping(value = {"/edituser-{login}"}, method = RequestMethod.GET)
    public String getEdit(@PathVariable String login, ModelMap model) {
        logger.debug("Received request to show edit page");

        User user = userService.getUser(login);
        model.addAttribute("user", user);
        model.addAttribute("login", user.getLogin());
        model.addAttribute("edit", true);

        return "edituser";
    }
    
    //Servlet
    //Affiche les information de l'utilisateur 
    //l'utilisateur peut sur cette page modifier son mot de passe
    @RequestMapping(value = {"/edituser-{login}"}, method = RequestMethod.POST)
    public String postEdit(Model model, Principal principal) {
        String userName = principal.getName();
        User exist = userService.getUser(userName);
        userService.updateUser(exist);
        model.addAttribute("log", true);
        model.addAttribute("userLog1", exist.getLogin());
        model.addAttribute("userLog2", exist.getPassword());
        return "login-form";
    }
    //------------END EDIT USER

    /*
	 @RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		this.personService.removePerson(id);
		return "redirect:/persons";
	}
     */
    
    //Servlet
    //permet a l'admin de supprimer/bannir un utilisateur
    @RequestMapping("/supprimer-{id}")
    public String removeUser(@PathVariable("id") int id, Model model) {
        userService.deleteUser(id);
        List<User> users = userService.listeUser();
        model.addAttribute("listuser", users);
        return "admin-users";
    }

}
