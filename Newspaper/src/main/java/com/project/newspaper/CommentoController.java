package com.project.newspaper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.newspaper.model.Articolo;
import com.project.newspaper.model.Commento;
import com.project.newspaper.service.ArticoloService;
import com.project.newspaper.service.CommentoService;
import com.project.newspaper.service.UtenteService;

@Controller
public class CommentoController {

	private CommentoService commentoService;
	private ArticoloService articoloService;
	private UtenteService utenteService;

	@Autowired(required = true)
	@Qualifier(value = "utenteService")
	public void setUtenteService(UtenteService utenteService) {
		this.utenteService = utenteService;
	}

	@Autowired(required = true)
	@Qualifier(value = "commentoService")
	public void setCommentoService(CommentoService commentoService) {
		this.commentoService = commentoService;
	}

	@Autowired(required = true)
	@Qualifier(value = "articoloService")
	public void setArticoloService(ArticoloService articoloService) {
		this.articoloService = articoloService;
	}

	// Carica commenti in ordine di ID
	public ModelAndView ricaricaCommenti(Articolo articolo, ModelAndView mav, HttpServletRequest request) {
		List<Commento> aList = new ArrayList<Commento>();
		for (Commento x : articolo.getCommenti())
			aList.add(x);
		aList.sort(new Comparator<Commento>() {
			public int compare(Commento i1, Commento i2) {
				return i2.getId_commento() - i1.getId_commento();
			}
		});
		mav.addObject("commenti", aList);
		mav.addObject("articolo", articolo);
		mav.addObject("giornalista", (int) request.getSession(true).getAttribute("giornalista"));
		mav.addObject("utente", UtenteController.getUtenteLoggato());
		return mav;
	}

	// Disponibili sia per utente che giornalista
	// Ottieni lista dei commenti ad un articolo
	@GetMapping("/home/articoli/{id}/commenti")
	public ModelAndView getCommentiArticolo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id_articolo) {
		ModelAndView mav = new ModelAndView("commenti");
		Articolo articolo = this.articoloService.getOne(id_articolo);
		mav = ricaricaCommenti(articolo, mav, request);
		return mav;
	}

	// Ottieni lista dei commenti di un utente
	@GetMapping("/home/profili/{id}/commenti")
	public ModelAndView profiloCommenti(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("commentiProfilo");
		List<Commento> aList = new ArrayList<Commento>();
		for (Commento x : utenteService.getOne(id).getCommenti())
			aList.add(x);
		aList.sort(new Comparator<Commento>() {
			public int compare(Commento i1, Commento i2) {
				return i2.getId_commento() - i1.getId_commento();
			}
		});
		mav.addObject("commenti", aList);
		mav.addObject("utente", UtenteController.getUtenteLoggato());
		return mav;
	}

	// Aggiungi commenti ad un articolo
	@PostMapping("/home/articoli/{id}/commenti/crea")
	public ModelAndView createCommento(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id_articolo, @ModelAttribute("crea_commento") Commento commento) {
		ModelAndView mav = new ModelAndView("commenti");
		Articolo articolo = (Articolo) request.getSession(true).getAttribute("articolo");
		commento.setArticolo(articolo);
		commento.setAutore(UtenteController.getUtenteLoggato());
		this.commentoService.add(commento);
		articolo = this.articoloService.getOne(id_articolo);
		mav = ricaricaCommenti(articolo, mav, request);

		return mav;
	}

	// Modifica un commento ad un articolo
	@GetMapping("/home/articoli/{id}/commenti/{id2}/modifica")
	public ModelAndView prepareUpdateCommento(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id_articolo, @PathVariable("id2") int id_commento) {
		ModelAndView mav = new ModelAndView("modificaCommento");
		Commento commento = this.commentoService.getOne(id_commento);
		mav.addObject("commento", commento);
		return mav;
	}

	@PostMapping("/home/articoli/{id}/commenti/{id2}/modifica/invio")
	public ModelAndView updateCommento(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id_articolo, @PathVariable("id2") int id_commento,
			@RequestParam("testo") String testo) {
		ModelAndView mav = new ModelAndView("commenti");
		Commento commento = commentoService.getOne(id_commento);
		commento.setTesto(testo);
		this.commentoService.update(commento);
		mav = ricaricaCommenti(articoloService.getOne(id_articolo), mav, request);
		return mav;
	}

	// Cancella un commento da un articolo
	@GetMapping("/home/articoli/{id}/commenti/{id2}/cancella")
	public ModelAndView removeCommento(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id_articolo, @PathVariable("id2") int id_commento) {
		ModelAndView mav = new ModelAndView("commenti");
		this.commentoService.remove(id_commento);
		Articolo articolo = this.articoloService.getOne(id_articolo);
		mav = ricaricaCommenti(articolo, mav, request);
		return mav;
	}

}
