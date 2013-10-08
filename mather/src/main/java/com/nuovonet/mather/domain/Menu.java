package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.domain.util.AbstractEntity;
import com.nuovonet.mather.util.Utilitaria;

import java.util.List;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@Table(name="menus")
@NamedQuery(name="Menus.findAll", query="SELECT m FROM Menu m")
public class Menu extends AbstractEntity implements Serializable {
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

	public Menu() {
	}

	public Long getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Long idMenu) {
		super.setId(idMenu);
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
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) 
        		|| (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmMenu(),"");
    }
}