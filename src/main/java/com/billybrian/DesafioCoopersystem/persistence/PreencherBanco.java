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
		
		// Criação do usuário admin
		Usuario admin = this.repository.save(new Usuario("admin", "123456", "Billy Brian Moraes Filgueira", "02953367144", "73045171", "Quadra 17 Cj A", "Sobradinho", "Brasília", "DF", "Casa", true));
		
		this.telRepository.save(new UsuariosTelefones(admin, "61982015045", TiposTelefone.CELULAR));
		
		// Criação do usuário padrão
		Usuario padrao = this.repository.save(new Usuario("comum", "123456", "José da Silva", "12345678901", "12345123", "SQN 306 Bloco C Apt 201", "Asa norte", "Brasília", "DF", "Apartamento", false));
		
		UsuariosTelefones um = this.telRepository.save(new UsuariosTelefones(padrao, "61900000000", TiposTelefone.CELULAR));
		UsuariosTelefones dois = this.telRepository.save(new UsuariosTelefones(padrao, "61911111111", TiposTelefone.RESIDENCIAL));
		
	}

}
