package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the tipos_chegadas database table.
 * 
 */
@Entity
@Table(name="tipos_chegadas")
@NamedQuery(name="TipoChegada.findAll", query="SELECT t FROM TipoChegada t")
public class TipoChegada extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_chegada")
	private Long idTipoChegada;

	@Column(name="nm_tipo_chegada")
	private String nmTipoChegada;

	public TipoChegada() {
	}

	public Long getIdTipoChegada() {
		return this.idTipoChegada;
	}

	public void setIdTipoChegada(Long idTipoChegada) {
		super.setId(idTipoChegada);
		this.idTipoChegada = idTipoChegada;
	}

	public String getNmTipoChegada() {
		return this.nmTipoChegada;
	}

	public void setNmTipoChegada(String nmTipoChegada) {
		this.nmTipoChegada = nmTipoChegada;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoChegada != null ? idTipoChegada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoChegada)) {
            return false;
        }
        TipoChegada other = (TipoChegada) object;
        if ((this.idTipoChegada == null && other.idTipoChegada != null) 
        		|| (this.idTipoChegada != null && !this.idTipoChegada.equals(other.idTipoChegada))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmTipoChegada(),"");
    }
}