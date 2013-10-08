package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.domain.util.AbstractEntity;
import com.nuovonet.mather.util.Utilitaria;


/**
 * The persistent class for the empresas database table.
 * 
 */
@Entity
@Table(name="empresas")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_empresa")
	private Long idEmpresa;

	@Column(name="dm_tipo_atividade")
	private String dmTipoAtividade;

	@Column(name="nm_contato")
	private String nmContato;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Empresa() {
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		super.setId(idEmpresa);
		this.idEmpresa = idEmpresa;
	}

	public String getDmTipoAtividade() {
		return this.dmTipoAtividade;
	}

	public void setDmTipoAtividade(String dmTipoAtividade) {
		this.dmTipoAtividade = dmTipoAtividade;
	}

	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
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
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getIdEmpresa().toString(),"");
    }
}