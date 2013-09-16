package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_chegadas database table.
 * 
 */
@Entity
@Table(name="tipos_chegadas")
@NamedQuery(name="TipoChegada.findAll", query="SELECT t FROM TipoChegada t")
public class TipoChegada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_chegada")
	private Long idTipoChegada;

	@Column(name="nm_tipo_chegada")
	private String nmTipoChegada;

	public TipoChegada() {
	}

	public Long getIdTipoChegada() {
		return this.idTipoChegada;
	}

	public void setIdTipoChegada(Long idTipoChegada) {
		this.idTipoChegada = idTipoChegada;
	}

	public String getNmTipoChegada() {
		return this.nmTipoChegada;
	}

	public void setNmTipoChegada(String nmTipoChegada) {
		this.nmTipoChegada = nmTipoChegada;
	}

}