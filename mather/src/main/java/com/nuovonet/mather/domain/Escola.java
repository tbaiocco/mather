package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.domain.util.AbstractEntity;
import com.nuovonet.mather.util.Utilitaria;


/**
 * The persistent class for the escolas database table.
 * 
 */
@Entity
@Table(name="escolas")
@NamedQuery(name="Escola.findAll", query="SELECT e FROM Escola e")
public class Escola extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_escola")
	private Long idEscola;

	@Column(name="dm_tipo_escola")
	private String dmTipoEscola;

	@Column(name="nm_contato")
	private String nmContato;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Escola() {
	}

	public Long getIdEscola() {
		return this.idEscola;
	}

	public void setIdEscola(Long idEscola) {
		super.setId(idEscola);
		this.idEscola = idEscola;
	}

	public String getDmTipoEscola() {
		return this.dmTipoEscola;
	}

	public void setDmTipoEscola(String dmTipoEscola) {
		this.dmTipoEscola = dmTipoEscola;
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
        hash += (idEscola != null ? idEscola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escola)) {
            return false;
        }
        Escola other = (Escola) object;
        if ((this.idEscola == null && other.idEscola != null) 
        		|| (this.idEscola != null && !this.idEscola.equals(other.idEscola))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getIdEscola().toString(),"");
    }
}