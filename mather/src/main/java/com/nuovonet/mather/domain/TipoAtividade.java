package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_atividades database table.
 * 
 */
@Entity
@Table(name="tipos_atividades")
@NamedQuery(name="TipoAtividade.findAll", query="SELECT t FROM TipoAtividade t")
public class TipoAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_atividade")
	private Long idTipoAtividade;

	@Column(name="nm_tipo_atividade")
	private String nmTipoAtividade;

	public TipoAtividade() {
	}

	public Long getIdTipoAtividade() {
		return this.idTipoAtividade;
	}

	public void setIdTipoAtividade(Long idTipoAtividade) {
		this.idTipoAtividade = idTipoAtividade;
	}

	public String getNmTipoAtividade() {
		return this.nmTipoAtividade;
	}

	public void setNmTipoAtividade(String nmTipoAtividade) {
		this.nmTipoAtividade = nmTipoAtividade;
	}

}