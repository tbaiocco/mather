package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the tipos_saidas database table.
 * 
 */
@Entity
@Table(name="tipos_saidas")
@NamedQuery(name="TipoSaida.findAll", query="SELECT t FROM TipoSaida t")
public class TipoSaida extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_saida")
	private Long idTipoSaida;

	@Column(name="nm_tipo_saida")
	private String nmTipoSaida;

	public TipoSaida() {
	}

	public Long getIdTipoSaida() {
		return this.idTipoSaida;
	}

	public void setIdTipoSaida(Long idTipoSaida) {
		super.setId(idTipoSaida);
		this.idTipoSaida = idTipoSaida;
	}

	public String getNmTipoSaida() {
		return this.nmTipoSaida;
	}

	public void setNmTipoSaida(String nmTipoSaida) {
		this.nmTipoSaida = nmTipoSaida;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSaida != null ? idTipoSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSaida)) {
            return false;
        }
        TipoSaida other = (TipoSaida) object;
        if ((this.idTipoSaida == null && other.idTipoSaida != null) 
        		|| (this.idTipoSaida != null && !this.idTipoSaida.equals(other.idTipoSaida))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmTipoSaida(),"");
    }
}