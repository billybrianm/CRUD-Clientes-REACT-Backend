package com.billybrian.DesafioCoopersystem.dto;

import com.billybrian.DesafioCoopersystem.entities.UsuariosTelefones;
import com.billybrian.DesafioCoopersystem.enums.TiposTelefone;

public class UsuariosTelefonesDTO {
	private Long id;
	private Long usuario_id;
	private String numero;
	private TiposTelefone tipoTelefone;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TiposTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TiposTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public UsuariosTelefonesDTO(UsuariosTelefones us) {
		this.id = us.getId();
		this.numero = us.getNumero();
		this.usuario_id = us.getUsuario().getId();
		this.tipoTelefone = us.getTipo();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipoTelefone == null) ? 0 : tipoTelefone.hashCode());
		result = prime * result + ((usuario_id == null) ? 0 : usuario_id.hashCode());
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
		UsuariosTelefonesDTO other = (UsuariosTelefonesDTO) obj;
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
		if (tipoTelefone != other.tipoTelefone)
			return false;
		if (usuario_id == null) {
			if (other.usuario_id != null)
				return false;
		} else if (!usuario_id.equals(other.usuario_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UsuariosTelefonesDTO [id=" + id + ", usuario_id=" + usuario_id + ", numero=" + numero
				+ ", tipoTelefone=" + tipoTelefone + "]";
	}
	
	
}
