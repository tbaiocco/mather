package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the log_usuarios database table.
 * 
 */
@Entity
@Table(name="log_usuarios")
@NamedQuery(name="LogUsuario.findAll", query="SELECT l FROM LogUsuario l")
public class LogUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_log_usuario")
	private Long idLogUsuario;

	private String acao;

	@Column(name="data_hora")
	private Timestamp dataHora;

	private String informacao;

	private String recurso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public LogUsuario() {
	}

	public Long getIdLogUsuario() {
		return this.idLogUsuario;
	}

	public void setIdLogUsuario(Long idLogUsuario) {
		this.idLogUsuario = idLogUsuario;
	}

	public String getAcao() {
		return this.acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Timestamp getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public String getInformacao() {
		return this.informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}