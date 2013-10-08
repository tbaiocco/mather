package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;

import java.math.BigDecimal;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the unidades database table.
 * 
 */
@Entity
@Table(name="unidades")
@NamedQuery(name="Unidade.findAll", query="SELECT u FROM Unidade u")
public class Unidade extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_unidade")
	private Long idUnidade;

	@Column(name="dm_tipo_lotacao")
	private String dmTipoLotacao;

	@Column(name="nr_capacidade")
	private BigDecimal nrCapacidade;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Unidade() {
	}

	public Long getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		super.setId(idUnidade);
		this.idUnidade = idUnidade;
	}

	public String getDmTipoLotacao() {
		return this.dmTipoLotacao;
	}

	public void setDmTipoLotacao(String dmTipoLotacao) {
		this.dmTipoLotacao = dmTipoLotacao;
	}

	public BigDecimal getNrCapacidade() {
		return this.nrCapacidade;
	}

	public void setNrCapacidade(BigDecimal nrCapacidade) {
		this.nrCapacidade = nrCapacidade;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidade != null ? idUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.idUnidade == null && other.idUnidade != null) 
        		|| (this.idUnidade != null && !this.idUnidade.equals(other.idUnidade))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getIdUnidade().toString(),"");
    }
}