package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paises database table.
 * 
 */
@Entity
@Table(name="paises")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pais")
	private Long idPais;

	@Column(name="cd_pais")
	private String cdPais;

	@Column(name="nm_pais")
	private String nmPais;

	public Pais() {
		super();
	}

	public Pais(Long idPais, String cdPais, String nmPais) {
		super();
		this.idPais = idPais;
		this.cdPais = cdPais;
		this.nmPais = nmPais;
	}

	public Long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getCdPais() {
		return this.cdPais;
	}

	public void setCdPais(String cdPais) {
		this.cdPais = cdPais;
	}

	public String getNmPais() {
		return this.nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}

}