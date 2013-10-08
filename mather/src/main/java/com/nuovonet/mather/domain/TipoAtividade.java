package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the tipos_atividades database table.
 * 
 */
@Entity
@Table(name="tipos_atividades")
@NamedQuery(name="TipoAtividade.findAll", query="SELECT t FROM TipoAtividade t")
public class TipoAtividade extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_atividade")
	private Long idTipoAtividade;

	@Column(name="nm_tipo_atividade")
	private String nmTipoAtividade;

	public TipoAtividade() {
	}

	public Long getIdTipoAtividade() {
		return this.idTipoAtividade;
	}

	public void setIdTipoAtividade(Long idTipoAtividade) {
		super.setId(idTipoAtividade);
		this.idTipoAtividade = idTipoAtividade;
	}

	public String getNmTipoAtividade() {
		return this.nmTipoAtividade;
	}

	public void setNmTipoAtividade(String nmTipoAtividade) {
		this.nmTipoAtividade = nmTipoAtividade;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAtividade != null ? idTipoAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtividade)) {
            return false;
        }
        TipoAtividade other = (TipoAtividade) object;
        if ((this.idTipoAtividade == null && other.idTipoAtividade != null) 
        		|| (this.idTipoAtividade != null && !this.idTipoAtividade.equals(other.idTipoAtividade))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmTipoAtividade(),"");
    }
}