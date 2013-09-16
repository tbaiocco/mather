package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the programas database table.
 * 
 */
@Entity
@Table(name="programas")
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_programa")
	private Long idPrograma;

	@Column(name="dm_tipo_programa")
	private String dmTipoPrograma;

	@Column(name="nm_arquivo")
	private String nmArquivo;

	@Column(name="nm_caminho")
	private String nmCaminho;

	@Column(name="nm_programa")
	private String nmPrograma;

	//bi-directional many-to-many association to Menus
	@ManyToMany
	@JoinTable(
		name="programas_menus"
		, joinColumns={
			@JoinColumn(name="id_programa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_menu")
			}
		)
	private List<Menus> menuses;

	public Programa() {
	}

	public Long getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getDmTipoPrograma() {
		return this.dmTipoPrograma;
	}

	public void setDmTipoPrograma(String dmTipoPrograma) {
		this.dmTipoPrograma = dmTipoPrograma;
	}

	public String getNmArquivo() {
		return this.nmArquivo;
	}

	public void setNmArquivo(String nmArquivo) {
		this.nmArquivo = nmArquivo;
	}

	public String getNmCaminho() {
		return this.nmCaminho;
	}

	public void setNmCaminho(String nmCaminho) {
		this.nmCaminho = nmCaminho;
	}

	public String getNmPrograma() {
		return this.nmPrograma;
	}

	public void setNmPrograma(String nmPrograma) {
		this.nmPrograma = nmPrograma;
	}

	public List<Menus> getMenuses() {
		return this.menuses;
	}

	public void setMenuses(List<Menus> menuses) {
		this.menuses = menuses;
	}

}