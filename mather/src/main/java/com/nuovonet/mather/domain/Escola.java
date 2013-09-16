package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the escolas database table.
 * 
 */
@Entity
@Table(name="escolas")
@NamedQuery(name="Escola.findAll", query="SELECT e FROM Escola e")
public class Escola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_escola")
	private Long idEscola;

	@Column(name="dm_tipo_escola")
	private String dmTipoEscola;

	@Column(name="nm_contato")
	private String nmContato;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Escola() {
	}

	public Long getIdEscola() {
		return this.idEscola;
	}

	public void setIdEscola(Long idEscola) {
		this.idEscola = idEscola;
	}

	public String getDmTipoEscola() {
		return this.dmTipoEscola;
	}

	public void setDmTipoEscola(String dmTipoEscola) {
		this.dmTipoEscola = dmTipoEscola;
	}

	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}