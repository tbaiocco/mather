package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_publicacoes database table.
 * 
 */
@Entity
@Table(name="tipos_publicacoes")
@NamedQuery(name="TipoPublicacao.findAll", query="SELECT t FROM TipoPublicacao t")
public class TipoPublicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_publicacao")
	private Long idTipoPublicacao;

	@Column(name="dm_numeracao")
	private String dmNumeracao;

	@Column(name="nm_tipo_publicacao")
	private String nmTipoPublicacao;

	//bi-directional many-to-one association to Numeracao
	@ManyToOne
	@JoinColumn(name="id_numeracao")
	private Numeracao numeracoe;

	public TipoPublicacao() {
	}

	public Long getIdTipoPublicacao() {
		return this.idTipoPublicacao;
	}

	public void setIdTipoPublicacao(Long idTipoPublicacao) {
		this.idTipoPublicacao = idTipoPublicacao;
	}

	public String getDmNumeracao() {
		return this.dmNumeracao;
	}

	public void setDmNumeracao(String dmNumeracao) {
		this.dmNumeracao = dmNumeracao;
	}

	public String getNmTipoPublicacao() {
		return this.nmTipoPublicacao;
	}

	public void setNmTipoPublicacao(String nmTipoPublicacao) {
		this.nmTipoPublicacao = nmTipoPublicacao;
	}

	public Numeracao getNumeracoe() {
		return this.numeracoe;
	}

	public void setNumeracoe(Numeracao numeracoe) {
		this.numeracoe = numeracoe;
	}

}