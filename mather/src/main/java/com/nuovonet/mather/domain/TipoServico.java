package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_servicos database table.
 * 
 */
@Entity
@Table(name="tipos_servicos")
@NamedQuery(name="TipoServico.findAll", query="SELECT t FROM TipoServico t")
public class TipoServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_servico")
	private Long idTipoServico;

	@Column(name="nm_tipo_servico")
	private String nmTipoServico;

	public TipoServico() {
	}

	public Long getIdTipoServico() {
		return this.idTipoServico;
	}

	public void setIdTipoServico(Long idTipoServico) {
		this.idTipoServico = idTipoServico;
	}

	public String getNmTipoServico() {
		return this.nmTipoServico;
	}

	public void setNmTipoServico(String nmTipoServico) {
		this.nmTipoServico = nmTipoServico;
	}

}