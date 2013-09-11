package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfis database table.
 * 
 */
@Entity
@Table(name="perfis")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_perfil")
	private Long idPerfil;

	@Column(name="nm_perfil")
	private String nmPerfil;

	public Perfil() {
		super();
	}

	public Perfil(Long idPerfil, String nmPerfil) {
		super();
		this.idPerfil = idPerfil;
		this.nmPerfil = nmPerfil;
	}



	public Long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNmPerfil() {
		return this.nmPerfil;
	}

	public void setNmPerfil(String nmPerfil) {
		this.nmPerfil = nmPerfil;
	}

}