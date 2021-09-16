package com.billybrian.DesafioCoopersystem.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.billybrian.DesafioCoopersystem.entities.Usuario;
import com.billybrian.DesafioCoopersystem.entities.UsuariosTelefones;
import com.billybrian.DesafioCoopersystem.enums.TiposTelefone;
import com.billybrian.DesafioCoopersystem.repositories.UsuarioRepository;
import com.billybrian.DesafioCoopersystem.repositories.UsuariosTelefonesRepository;

@Component
public class PreencherBanco implements CommandLineRunner {
	
	private final UsuarioRepository repository;
	private final UsuariosTelefonesRepository telRepository;

	@Autowired
	public PreencherBanco(UsuarioRepository repository, UsuariosTelefonesRepository telRepository) {
		this.repository = repository;
		this.telRepository = telRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario = this.repository.save(new Usuario("admin", "123456", "Billy Brian Moraes Filgueira", "02953367144", "73045171", "Sobradinho", "Sobradinho", "Brasília", "DF", "Casa"));
		
		this.telRepository.save(new UsuariosTelefones(usuario, "61982015045", TiposTelefone.CELULAR));
	}

}
