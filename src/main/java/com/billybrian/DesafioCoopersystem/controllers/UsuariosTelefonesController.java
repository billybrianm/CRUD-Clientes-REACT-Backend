package com.billybrian.DesafioCoopersystem.controllers;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billybrian.DesafioCoopersystem.dto.UsuariosTelefonesDTO;
import com.billybrian.DesafioCoopersystem.entities.UsuariosTelefones;
import com.billybrian.DesafioCoopersystem.enums.TiposTelefone;
import com.billybrian.DesafioCoopersystem.repositories.UsuariosTelefonesRepository;

@RestController
public class UsuariosTelefonesController {
	
private final UsuariosTelefonesRepository repository;
	
	UsuariosTelefonesController(UsuariosTelefonesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/telefones")
	  List<UsuariosTelefonesDTO> getAll() {
		List<UsuariosTelefonesDTO> dtos = new ArrayList<>();
		
		List<UsuariosTelefones> usuarios = (List<UsuariosTelefones>) repository.findAll();
		
		for(UsuariosTelefones u : usuarios) {
			UsuariosTelefonesDTO d = new UsuariosTelefonesDTO(u);
			dtos.add(d);
		}
		
	    return dtos;
	}
	
	@GetMapping("/tipos-telefones")
	  List<TiposTelefone> getTiposTelefones() {
		
		List<TiposTelefone> enumValues = new ArrayList<TiposTelefone>(EnumSet.allOf(TiposTelefone.class));
		
	    return enumValues;
	}
}
