package com.billybrian.DesafioCoopersystem.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.billybrian.DesafioCoopersystem.entities.UsuariosTelefones;

public interface UsuariosTelefonesRepository extends CrudRepository<UsuariosTelefones, Long>  {
	@Override
    @Query(value="select * from usuarios_telefones", nativeQuery = true)
    Iterable<UsuariosTelefones> findAll();
}
