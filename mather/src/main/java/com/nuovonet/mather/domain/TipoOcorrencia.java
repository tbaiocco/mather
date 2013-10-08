package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the tipos_ocorrencias database table.
 * 
 */
@Entity
@Table(name="tipos_ocorrencias")
@NamedQuery(name="TipoOcorrencia.findAll", query="SELECT t FROM TipoOcorrencia t")
public class TipoOcorrencia extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_ocorrencia")
	private Long idTipoOcorrencia;

	@Column(name="nm_tipo_ocorrencia")
	private String nmTipoOcorrencia;

	public TipoOcorrencia() {
	}

	public Long getIdTipoOcorrencia() {
		return this.idTipoOcorrencia;
	}

	public void setIdTipoOcorrencia(Long idTipoOcorrencia) {
		super.setId(idTipoOcorrencia);
		this.idTipoOcorrencia = idTipoOcorrencia;
	}

	public String getNmTipoOcorrencia() {
		return this.nmTipoOcorrencia;
	}

	public void setNmTipoOcorrencia(String nmTipoOcorrencia) {
		this.nmTipoOcorrencia = nmTipoOcorrencia;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOcorrencia != null ? idTipoOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOcorrencia)) {
            return false;
        }
        TipoOcorrencia other = (TipoOcorrencia) object;
        if ((this.idTipoOcorrencia == null && other.idTipoOcorrencia != null) 
        		|| (this.idTipoOcorrencia != null && !this.idTipoOcorrencia.equals(other.idTipoOcorrencia))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmTipoOcorrencia(),"");
    }
}