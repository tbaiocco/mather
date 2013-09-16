package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the unidades database table.
 * 
 */
@Entity
@Table(name="unidades")
@NamedQuery(name="Unidade.findAll", query="SELECT u FROM Unidade u")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_unidade")
	private Long idUnidade;

	@Column(name="dm_tipo_lotacao")
	private String dmTipoLotacao;

	@Column(name="nr_capacidade")
	private BigDecimal nrCapacidade;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Unidade() {
	}

	public Long getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getDmTipoLotacao() {
		return this.dmTipoLotacao;
	}

	public void setDmTipoLotacao(String dmTipoLotacao) {
		this.dmTipoLotacao = dmTipoLotacao;
	}

	public BigDecimal getNrCapacidade() {
		return this.nrCapacidade;
	}

	public void setNrCapacidade(BigDecimal nrCapacidade) {
		this.nrCapacidade = nrCapacidade;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}