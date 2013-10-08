package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the tipos_servicos database table.
 * 
 */
@Entity
@Table(name="tipos_servicos")
@NamedQuery(name="TipoServico.findAll", query="SELECT t FROM TipoServico t")
public class TipoServico extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_servico")
	private Long idTipoServico;

	@Column(name="nm_tipo_servico")
	private String nmTipoServico;

	public TipoServico() {
	}

	public Long getIdTipoServico() {
		return this.idTipoServico;
	}

	public void setIdTipoServico(Long idTipoServico) {
		super.setId(idTipoServico);
		this.idTipoServico = idTipoServico;
	}

	public String getNmTipoServico() {
		return this.nmTipoServico;
	}

	public void setNmTipoServico(String nmTipoServico) {
		this.nmTipoServico = nmTipoServico;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServico != null ? idTipoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServico)) {
            return false;
        }
        TipoServico other = (TipoServico) object;
        if ((this.idTipoServico == null && other.idTipoServico != null) 
        		|| (this.idTipoServico != null && !this.idTipoServico.equals(other.idTipoServico))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmTipoServico(),"");
    }
}