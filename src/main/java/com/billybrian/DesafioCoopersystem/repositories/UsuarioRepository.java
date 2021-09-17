package com.billybrian.DesafioCoopersystem.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.billybrian.DesafioCoopersystem.dto.TokenDTO;
import com.billybrian.DesafioCoopersystem.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {	
	@Override
    @Query("select distinct usuario from Usuario usuario left join fetch usuario.telefones")
    Iterable<Usuario> findAll();
	
	@Query("select u.isAdmin from Usuario u where u.usuario =:usuario and u.senha =:senha")
	boolean getAdmin(String usuario, String senha);
}
