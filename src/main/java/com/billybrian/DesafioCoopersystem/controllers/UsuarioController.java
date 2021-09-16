package com.billybrian.DesafioCoopersystem.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billybrian.DesafioCoopersystem.dto.TokenDTO;
import com.billybrian.DesafioCoopersystem.dto.UsuarioDTO;
import com.billybrian.DesafioCoopersystem.dto.UsuarioLoginDTO;
import com.billybrian.DesafioCoopersystem.entities.Usuario;
import com.billybrian.DesafioCoopersystem.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	
	private final UsuarioRepository repository;
	
	UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
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
	
	@PostMapping("/usuario")
	  Usuario novoUsuario(@RequestBody Usuario novoUsuario) {
	    return repository.save(novoUsuario);
	}
	
	@PostMapping("/login")
	TokenDTO loginUsuario(@RequestBody UsuarioLoginDTO login) {
		
		TokenDTO t = new TokenDTO();
		
		t.setToken("admin");
		return t;
	}
	
	
}
