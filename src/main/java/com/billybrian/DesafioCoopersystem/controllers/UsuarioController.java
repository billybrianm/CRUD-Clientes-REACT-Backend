package com.billybrian.DesafioCoopersystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billybrian.DesafioCoopersystem.dto.TokenDTO;
import com.billybrian.DesafioCoopersystem.dto.UsuarioDTO;
import com.billybrian.DesafioCoopersystem.dto.UsuarioLoginDTO;
import com.billybrian.DesafioCoopersystem.entities.Usuario;
import com.billybrian.DesafioCoopersystem.entities.UsuariosTelefones;
import com.billybrian.DesafioCoopersystem.repositories.UsuarioRepository;
import com.billybrian.DesafioCoopersystem.repositories.UsuariosTelefonesRepository;

@RestController
public class UsuarioController {
	
	private final UsuarioRepository repository;
	private final UsuariosTelefonesRepository telRepository;
	
	UsuarioController(UsuarioRepository repository, UsuariosTelefonesRepository telRepository) {
		this.repository = repository;
		this.telRepository = telRepository;
	}
	
	@GetMapping("/usuarios")
	  List<UsuarioDTO> getAll() {
		
		List<UsuarioDTO> dtos = new ArrayList<>();
		
		List<Usuario> usuarios = (List<Usuario>) repository.findAll();
		
		for(Usuario u : usuarios) {
			UsuarioDTO d = new UsuarioDTO(u);
			dtos.add(d);
		}
		
	    return dtos;
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	  UsuarioDTO getUsuario(@PathVariable Long id) {
		
		Optional<Usuario> u = repository.findById(id);
		UsuarioDTO dto = new UsuarioDTO(u.get());
		return dto;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
	  ResponseEntity editUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
				
		Usuario us = repository.save(novoUsuario);
		
		
		return ResponseEntity.ok(us);
	}
	
	@PostMapping("/usuario")
	  Usuario novoUsuario(@RequestBody Usuario novoUsuario) {
		List<UsuariosTelefones> telefones = novoUsuario.getTelefones();
		Usuario usr = repository.save(novoUsuario);
		
		for(UsuariosTelefones tel : telefones) {
			tel.setUsuario(usr);
		}
		
		telRepository.saveAll(telefones);
		
	    return usr;
	}
	
	@PostMapping("/login")
	TokenDTO loginUsuario(@RequestBody UsuarioLoginDTO login) {
		TokenDTO t = new TokenDTO();
		boolean admin = false;
		
		try {
			admin = repository.getAdmin(login.getUsuario(), login.getSenha());
		} catch (Exception e) {
			t.setToken("invalido");
			return t;
		}
		
		
		if(admin)
			t.setToken("admin");
		else
			t.setToken("comum");
		
		return t;
	}
	
	
}
