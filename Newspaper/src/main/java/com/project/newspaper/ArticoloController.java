package com.project.newspaper;

import java.util.List;

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

import com.project.newspaper.model.Articolo;
import com.project.newspaper.model.Utente;
import com.project.newspaper.service.ArticoloService;
import com.project.newspaper.service.UtenteService;

@Controller
public class ArticoloController {
	
	private ArticoloService articoloService;
	private UtenteService utenteService;
	
	@Autowired(required=true)
	@Qualifier(value="articoloService")
	public void setArticoloService(ArticoloService articoloService) {
		this.articoloService = articoloService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="utenteService")
	public void setUtenteService(UtenteService utenteService) {
		this.utenteService = utenteService;
	}
	
	// Disponibili sia per utente che giornalista
	// Ottieni lista degli articoli
	@GetMapping("/home/articoli")
	public ModelAndView getArticoli(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("listaArticoli");
		List<Articolo> lista_articoli = this.articoloService.getAll();
		request.getSession(true).setAttribute("lista_articoli", lista_articoli);
		mav.addObject("lista_articoli", lista_articoli);
		int giornalista = UtenteController.getUtenteLoggato().getGiornalista();
		mav.addObject("giornalista", giornalista);
		return mav;
	}
	
	// Ottieni uno specifico articolo
	@GetMapping("/home/articoli/{id}")
	public ModelAndView getArticolo(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id_articolo) {
		ModelAndView mav = new ModelAndView("articolo");
		Articolo articolo = this.articoloService.getOne(id_articolo);
		request.getSession(true).setAttribute("articolo", articolo);
		mav.addObject("articolo", articolo);
		int giornalista = UtenteController.getUtenteLoggato().getGiornalista();
		mav.addObject("giornalista", giornalista);
		request.getSession(true).setAttribute("giornalista", giornalista);
		return mav;
	}
	
	// Disponibili solo per il giornalista
	// Visualizza gli articoli scritti dal giornalista
	@GetMapping("/home/profili/{id}/articoli")
    public ModelAndView profiloArticoli(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
	    ModelAndView mav = new ModelAndView("articoliProfilo");
	    mav.addObject("articoli", this.utenteService.getOne(id).getArticoli());
	    mav.addObject("utente", UtenteController.getUtenteLoggato().getId_utente());
	    return mav;
	}
	
	// Crea un nuovo articolo
	@GetMapping("/home/articoli/crea")
	public ModelAndView prepareCreateArticolo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("creaArticolo");
		Utente utente = UtenteController.getUtenteLoggato();
		mav.addObject("utente", utente);
		return mav;
	}
	
	@PostMapping("/home/articoli/crea/invio")
	public ModelAndView createArticolo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("crea_articolo") Articolo articolo) {
		ModelAndView mav = new ModelAndView("articolo");
		articolo.setAutore(UtenteController.getUtenteLoggato());
		this.articoloService.add(articolo);
		mav.addObject("articolo", articolo);
		request.getSession(true).setAttribute("articolo", articolo);
		int giornalista = UtenteController.getUtenteLoggato().getGiornalista();
		mav.addObject("giornalista", giornalista);
		request.getSession(true).setAttribute("giornalista", giornalista);
		return mav;
	}
	
	// Modifica un articolo 
	@GetMapping("/home/articoli/{id}/modifica")
	public ModelAndView prepareUpdateArticolo(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id_articolo) {
		ModelAndView mav = new ModelAndView("modificaArticolo");
		Articolo articolo = this.articoloService.getOne(id_articolo);
		mav.addObject("articolo", articolo);
		return mav;
	}
	
	@PostMapping("/home/articoli/{id}/modifica/invio")
	public ModelAndView updateArticolo(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id_articolo, @ModelAttribute("modifica_articolo") Articolo articolo) {
		ModelAndView mav = new ModelAndView("articolo");
		Articolo a = (Articolo)request.getSession(true).getAttribute("articolo");
		articolo.setAutore(	a.getAutore()	);
		articolo.setId_articolo(id_articolo);
		this.articoloService.update(articolo);
		mav.addObject("articolo", articolo);
		return mav;
	}
	
	// Cancella un articolo
	@GetMapping("/home/articoli/{id}/cancella")
	public ModelAndView removeArticolo(ModelMap model, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id_articolo) {
		ModelAndView mav = new ModelAndView("redirect:/home/articoli",model);
		this.articoloService.remove(id_articolo);
		return mav;
	}
	
}
