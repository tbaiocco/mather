package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@NamedQuery(name="Menus.findAll", query="SELECT m FROM Menus m")
public class Menus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_menu")
	private Long idMenu;

	@Column(name="id_sistema")
	private Long sistema;

	@Column(name="nm_menu")
	private String nmMenu;

	//bi-directional many-to-many association to Programa
	@ManyToMany(mappedBy="menuses")
	private List<Programa> programas;

	public Menus() {
	}

	public Long getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public Long getSistema() {
		return this.sistema;
	}

	public void setSistema(Long sistema) {
		this.sistema = sistema;
	}

	public String getNmMenu() {
		return this.nmMenu;
	}

	public void setNmMenu(String nmMenu) {
		this.nmMenu = nmMenu;
	}

	public List<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

}