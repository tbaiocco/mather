package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;

import java.math.BigDecimal;
import java.util.List;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the numeracoes database table.
 * 
 */
@Entity
@Table(name="numeracoes")
@NamedQuery(name="Numeracao.findAll", query="SELECT n FROM Numeracao n")
public class Numeracao extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_numeracao")
	private Long idNumeracao;

	@Column(name="dm_tipo_impressao")
	private String dmTipoImpressao;

	@Column(name="nm_numeracao")
	private String nmNumeracao;

	@Column(name="nm_serie")
	private String nmSerie;

	@Column(name="nr_final")
	private BigDecimal nrFinal;

	@Column(name="nr_inicial")
	private BigDecimal nrInicial;

	@Column(name="nr_proximo")
	private BigDecimal nrProximo;

	//bi-directional many-to-one association to TipoPublicacao
	@OneToMany(mappedBy="numeracoe")
	private List<TipoPublicacao> tiposPublicacoes;

	public Numeracao() {
	}

	public Long getIdNumeracao() {
		return this.idNumeracao;
	}

	public void setIdNumeracao(Long idNumeracao) {
		super.setId(idNumeracao);
		this.idNumeracao = idNumeracao;
	}

	public String getDmTipoImpressao() {
		return this.dmTipoImpressao;
	}

	public void setDmTipoImpressao(String dmTipoImpressao) {
		this.dmTipoImpressao = dmTipoImpressao;
	}

	public String getNmNumeracao() {
		return this.nmNumeracao;
	}

	public void setNmNumeracao(String nmNumeracao) {
		this.nmNumeracao = nmNumeracao;
	}

	public String getNmSerie() {
		return this.nmSerie;
	}

	public void setNmSerie(String nmSerie) {
		this.nmSerie = nmSerie;
	}

	public BigDecimal getNrFinal() {
		return this.nrFinal;
	}

	public void setNrFinal(BigDecimal nrFinal) {
		this.nrFinal = nrFinal;
	}

	public BigDecimal getNrInicial() {
		return this.nrInicial;
	}

	public void setNrInicial(BigDecimal nrInicial) {
		this.nrInicial = nrInicial;
	}

	public BigDecimal getNrProximo() {
		return this.nrProximo;
	}

	public void setNrProximo(BigDecimal nrProximo) {
		this.nrProximo = nrProximo;
	}

	public List<TipoPublicacao> getTiposPublicacoes() {
		return this.tiposPublicacoes;
	}

	public void setTiposPublicacoes(List<TipoPublicacao> tiposPublicacoes) {
		this.tiposPublicacoes = tiposPublicacoes;
	}

	public TipoPublicacao addTiposPublicacoe(TipoPublicacao tiposPublicacoe) {
		getTiposPublicacoes().add(tiposPublicacoe);
		tiposPublicacoe.setNumeracoe(this);

		return tiposPublicacoe;
	}

	public TipoPublicacao removeTiposPublicacoe(TipoPublicacao tiposPublicacoe) {
		getTiposPublicacoes().remove(tiposPublicacoe);
		tiposPublicacoe.setNumeracoe(null);

		return tiposPublicacoe;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumeracao != null ? idNumeracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Numeracao)) {
            return false;
        }
        Numeracao other = (Numeracao) object;
        if ((this.idNumeracao == null && other.idNumeracao != null) 
        		|| (this.idNumeracao != null && !this.idNumeracao.equals(other.idNumeracao))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmNumeracao(),"");
    }
}