package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sistemas database table.
 * 
 */
@Entity
@Table(name="sistemas")
@NamedQuery(name="Sistema.findAll", query="SELECT s FROM Sistema s")
public class Sistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_sistema")
	private Long idSistema;

	@Column(name="nm_sistema")
	private String nmSistema;

	//bi-directional many-to-many association to Perfil
	@ManyToMany(mappedBy="sistemas")
	private List<Perfil> perfis;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="sistemas")
	private List<Usuario> usuarios;

	public Sistema() {
	}

	public Long getIdSistema() {
		return this.idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public String getNmSistema() {
		return this.nmSistema;
	}

	public void setNmSistema(String nmSistema) {
		this.nmSistema = nmSistema;
	}

	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}