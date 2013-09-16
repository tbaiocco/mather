package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_saidas database table.
 * 
 */
@Entity
@Table(name="tipos_saidas")
@NamedQuery(name="TipoSaida.findAll", query="SELECT t FROM TipoSaida t")
public class TipoSaida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_saida")
	private Long idTipoSaida;

	@Column(name="nm_tipo_saida")
	private String nmTipoSaida;

	public TipoSaida() {
	}

	public Long getIdTipoSaida() {
		return this.idTipoSaida;
	}

	public void setIdTipoSaida(Long idTipoSaida) {
		this.idTipoSaida = idTipoSaida;
	}

	public String getNmTipoSaida() {
		return this.nmTipoSaida;
	}

	public void setNmTipoSaida(String nmTipoSaida) {
		this.nmTipoSaida = nmTipoSaida;
	}

}