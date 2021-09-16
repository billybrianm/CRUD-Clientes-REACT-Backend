package com.billybrian.DesafioCoopersystem.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.billybrian.DesafioCoopersystem.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {	
	@Override
    @Query("select distinct usuario from Usuario usuario left join fetch usuario.telefones")
    Iterable<Usuario> findAll();
}
