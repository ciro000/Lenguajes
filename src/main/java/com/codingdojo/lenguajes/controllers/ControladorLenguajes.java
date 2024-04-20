package com.codingdojo.lenguajes.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.lenguajes.models.Lenguaje;
import com.codingdojo.lenguajes.services.ServicioLenguajes;

import jakarta.validation.Valid;

@Controller
public class ControladorLenguajes {
	
	public ServicioLenguajes servicioLenguajes;
	
	public ControladorLenguajes(ServicioLenguajes servicioLenguajes) {
		this.servicioLenguajes = servicioLenguajes;
	}
	
	@GetMapping("/languages")
	public String index(Model model,
						@ModelAttribute("lenguaje")Lenguaje lenguaje) {
		List<Lenguaje> lenguajes = servicioLenguajes.todosLosLenguajes();
		model.addAttribute("lenguajes", lenguajes);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("lenguaje")Lenguaje lenguaje,
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		else {
			servicioLenguajes.crearLenguaje(lenguaje);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String getLanguage(@PathVariable("id") Long id,
								Model model) {
		Lenguaje lenguaje = servicioLenguajes.encontrarPorId(id);
		model.addAttribute("lenguaje", lenguaje);
		
		return "show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id")Long id,
								Model model) {
		Lenguaje lenguaje = servicioLenguajes.encontrarPorId(id);
		model.addAttribute(lenguaje);
		
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String editLanguage(@Valid @ModelAttribute("lenguaje")Lenguaje lenguaje,
								BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		else {
			servicioLenguajes.editarLenguaje(lenguaje);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		servicioLenguajes.eliminarLenguaje(id);
		return "redirect:/languages";
	}

}
