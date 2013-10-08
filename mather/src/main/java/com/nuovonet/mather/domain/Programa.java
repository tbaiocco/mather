package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;

import java.util.List;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the programas database table.
 * 
 */
@Entity
@Table(name="programas")
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa extends AbstractEntity implements Serializable {
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
	private List<Menu> menuses;

	public Programa() {
	}

	public Long getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		super.setId(idPrograma);
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

	public List<Menu> getMenuses() {
		return this.menuses;
	}

	public void setMenuses(List<Menu> menuses) {
		this.menuses = menuses;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrograma != null ? idPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.idPrograma == null && other.idPrograma != null) 
        		|| (this.idPrograma != null && !this.idPrograma.equals(other.idPrograma))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmPrograma(),"");
    }
}