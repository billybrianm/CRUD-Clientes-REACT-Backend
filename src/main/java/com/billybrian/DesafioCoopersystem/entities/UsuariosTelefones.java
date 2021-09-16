package com.billybrian.DesafioCoopersystem.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.billybrian.DesafioCoopersystem.enums.TiposTelefone;

@Entity
public class UsuariosTelefones {
	
	private @Id @GeneratedValue Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	
	private String numero;
	private TiposTelefone tipo;
	
	
	
	public UsuariosTelefones() {}
	
	public UsuariosTelefones (Usuario usuario, String numero, TiposTelefone tipo) {
		this.usuario = usuario;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TiposTelefone getTipo() {
		return tipo;
	}
	public void setTipo(TiposTelefone tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosTelefones other = (UsuariosTelefones) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo != other.tipo)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuariosTelefones [id=" + id +" numero=" + numero + ", tipo=" + tipo + "]";
	}
	
	

	
	

}
