package com.project.newspaper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.newspaper.model.Utente;
import com.project.newspaper.service.UtenteService;

@Controller
public class UtenteController {
	private UtenteService utenteService;
	private static Utente utente1 = null;
	
	public static Utente getUtenteLoggato() {
		return utente1;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "utenteService")
	public void setUtenteService(UtenteService utenteService) {
		this.utenteService = utenteService;
	}

	@GetMapping("/")
	public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Benvenuto!");
		mav.addObject("login", new Utente());
		return mav;
	}
	
	@GetMapping("/nuovo_utente")
    public ModelAndView registrazione(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("registrazione");
	    mav.addObject("message", "Benvenuto!");
	    mav.addObject("registrazione", new Utente());
	    return mav;
	  }
    
    @PostMapping("/nuovo_utente")
    public ModelAndView postRegistrazione(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("registrazione") Utente utente) {
    	ModelAndView mav = null;
    	String res = utenteService.add(utente);
    	if(res=="Errore") {
        	mav = new ModelAndView("registrazione");
    	    mav.addObject("message","Username non disponibile");
    	}else{
    		mav=new ModelAndView("index");
    	    mav.addObject("message","Registrato!");
    	}
        return mav;
	  }

	@PostMapping("/")
	public ModelAndView postLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Utente utente) {
		ModelAndView mav = null;
		utente1 = utenteService.validate(utente);
		if (utente1 == null) {
			mav = new ModelAndView("index");
			mav.addObject("message", "Username e/o Passward errati");
			return mav;
		}
		mav = new ModelAndView("redirect:/home", model);
		return mav;
	}

	@GetMapping("/home")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		if(utente1==null) {
    		return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("utente", utente1);
		request.getSession(true).setAttribute("idUtente", utente1.getId_utente());
		return mav;
	}

	@GetMapping("/home/profili/{id}")
	public ModelAndView profilo(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("profilo");
		mav.addObject("utente", utente1);
		return mav;
	}
	
	@GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("logout");
	    utente1=null;
	    System.gc();
	    return mav;
	}

}