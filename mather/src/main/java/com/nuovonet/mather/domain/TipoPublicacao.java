package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the tipos_publicacoes database table.
 * 
 */
@Entity
@Table(name="tipos_publicacoes")
@NamedQuery(name="TipoPublicacao.findAll", query="SELECT t FROM TipoPublicacao t")
public class TipoPublicacao extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_publicacao")
	private Long idTipoPublicacao;

	@Column(name="dm_numeracao")
	private String dmNumeracao;

	@Column(name="nm_tipo_publicacao")
	private String nmTipoPublicacao;

	//bi-directional many-to-one association to Numeracao
	@ManyToOne
	@JoinColumn(name="id_numeracao")
	private Numeracao numeracoe;

	public TipoPublicacao() {
	}

	public Long getIdTipoPublicacao() {
		return this.idTipoPublicacao;
	}

	public void setIdTipoPublicacao(Long idTipoPublicacao) {
		super.setId(idTipoPublicacao);
		this.idTipoPublicacao = idTipoPublicacao;
	}

	public String getDmNumeracao() {
		return this.dmNumeracao;
	}

	public void setDmNumeracao(String dmNumeracao) {
		this.dmNumeracao = dmNumeracao;
	}

	public String getNmTipoPublicacao() {
		return this.nmTipoPublicacao;
	}

	public void setNmTipoPublicacao(String nmTipoPublicacao) {
		this.nmTipoPublicacao = nmTipoPublicacao;
	}

	public Numeracao getNumeracoe() {
		return this.numeracoe;
	}

	public void setNumeracoe(Numeracao numeracoe) {
		this.numeracoe = numeracoe;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPublicacao != null ? idTipoPublicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPublicacao)) {
            return false;
        }
        TipoPublicacao other = (TipoPublicacao) object;
        if ((this.idTipoPublicacao == null && other.idTipoPublicacao != null) 
        		|| (this.idTipoPublicacao != null && !this.idTipoPublicacao.equals(other.idTipoPublicacao))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmTipoPublicacao(),"");
    }
}