package com.billybrian.DesafioCoopersystem.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billybrian.DesafioCoopersystem.entities.Usuario;
import com.billybrian.DesafioCoopersystem.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	
	private final UsuarioRepository repository;
	
	UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/usuarios")
	  List<Usuario> getAll() {
		List<Usuario> ret = new ArrayList<>();
		repository.findAll().forEach(ret::add);
	    return ret;
	}
	
	@PostMapping("/usuarios")
	  Usuario novoUsuario(@RequestBody Usuario novoUsuario) {
	    return repository.save(novoUsuario);
	}
	
	
}
