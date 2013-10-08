package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;

import java.util.List;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the paises database table.
 * 
 */
@Entity
@Table(name="paises")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pais")
	private Long idPais;

	@Column(name="cd_pais")
	private String cdPais;

	@Column(name="nm_pais")
	private String nmPais;

	//bi-directional many-to-one association to Estado
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pais")
	private List<Estado> estados;

	public Pais() {
	}

	public Long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Long idPais) {
		super.setId(idPais);
		this.idPais = idPais;
	}

	public String getCdPais() {
		return this.cdPais;
	}

	public void setCdPais(String cdPais) {
		this.cdPais = cdPais;
	}

	public String getNmPais() {
		return this.nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado addEstado(Estado estado) {
		getEstados().add(estado);
		estado.setPais(this);

		return estado;
	}

	public Estado removeEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setPais(null);

		return estado;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getCdPais(),"") + " - " + Utilitaria.getValueDef(this.getNmPais(),"");
    }

}