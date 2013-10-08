package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.domain.util.AbstractEntity;
import com.nuovonet.mather.util.Utilitaria;

import java.util.List;


/**
 * The persistent class for the cidades database table.
 * 
 */
@Entity
@Table(name="cidades")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cidade")
	private Long idCidade;

	@Column(name="cd_cidade")
	private String cdCidade;

	@Column(name="nm_cidade")
	private String nmCidade;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="cidade")
	private List<Pessoa> pessoas;

	public Cidade() {
	}

	public Long getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(Long idCidade) {
		super.setId(idCidade);
		this.idCidade = idCidade;
	}

	public String getCdCidade() {
		return this.cdCidade;
	}

	public void setCdCidade(String cdCidade) {
		this.cdCidade = cdCidade;
	}

	public String getNmCidade() {
		return this.nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setCidade(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setCidade(null);

		return pessoa;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) 
        		|| (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmCidade(),"");
    }
}