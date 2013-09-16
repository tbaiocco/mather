package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_ocorrencias database table.
 * 
 */
@Entity
@Table(name="tipos_ocorrencias")
@NamedQuery(name="TipoOcorrencia.findAll", query="SELECT t FROM TipoOcorrencia t")
public class TipoOcorrencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_ocorrencia")
	private Long idTipoOcorrencia;

	@Column(name="nm_tipo_ocorrencia")
	private String nmTipoOcorrencia;

	public TipoOcorrencia() {
	}

	public Long getIdTipoOcorrencia() {
		return this.idTipoOcorrencia;
	}

	public void setIdTipoOcorrencia(Long idTipoOcorrencia) {
		this.idTipoOcorrencia = idTipoOcorrencia;
	}

	public String getNmTipoOcorrencia() {
		return this.nmTipoOcorrencia;
	}

	public void setNmTipoOcorrencia(String nmTipoOcorrencia) {
		this.nmTipoOcorrencia = nmTipoOcorrencia;
	}

}