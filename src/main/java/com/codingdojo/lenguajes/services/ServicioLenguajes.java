package com.codingdojo.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lenguajes.models.Lenguaje;
import com.codingdojo.lenguajes.repositories.RepositorioLenguajes;

@Service
public class ServicioLenguajes {
	
	private final RepositorioLenguajes repositorioLenguajes;
	
	public ServicioLenguajes(RepositorioLenguajes repositorioLenguajes){
		this.repositorioLenguajes = repositorioLenguajes;
	}
	
	public List<Lenguaje> todosLosLenguajes(){
		return repositorioLenguajes.findAll();
	}
	
	public Lenguaje crearLenguaje(Lenguaje nuevoLenguaje) {
		return repositorioLenguajes.save(nuevoLenguaje);
	}
	
	public Lenguaje encontrarPorId(Long id) {
		Optional<Lenguaje> optionalLenguaje = repositorioLenguajes.findById(id);
		
		if(optionalLenguaje.isPresent()) {
			return optionalLenguaje.get();
		}
		
		else {
			return null;
		}
	}
	
	public Lenguaje editarLenguaje(Lenguaje lenguaje) {
		Optional<Lenguaje> optionalLenguaje = repositorioLenguajes.findById(lenguaje.getId());
		
		if(optionalLenguaje.isPresent()) {
			Lenguaje l = optionalLenguaje.get();
			l.setName(lenguaje.getName());
			l.setCreator(lenguaje.getCreator());
			l.setCurrentVersion(lenguaje.getCurrentVersion());
			
			return repositorioLenguajes.save(l);
		}
		
		else {
			return null;
		}
		
	}
	
	public void eliminarLenguaje(Long id) {
		Optional<Lenguaje> optionalLenguaje = repositorioLenguajes.findById(id);
		Lenguaje l = optionalLenguaje.get();
		
		repositorioLenguajes.delete(l);
	}

}
