package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.domain.util.AbstractEntity;
import com.nuovonet.mather.util.Utilitaria;

import java.sql.Timestamp;


/**
 * The persistent class for the log_usuarios database table.
 * 
 */
@Entity
@Table(name="log_usuarios")
@NamedQuery(name="LogUsuario.findAll", query="SELECT l FROM LogUsuario l")
public class LogUsuario extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_log_usuario")
	private Long idLogUsuario;

	private String acao;

	@Column(name="data_hora")
	private Timestamp dataHora;

	private String informacao;

	private String recurso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public LogUsuario() {
	}

	public Long getIdLogUsuario() {
		return this.idLogUsuario;
	}

	public void setIdLogUsuario(Long idLogUsuario) {
		super.setId(idLogUsuario);
		this.idLogUsuario = idLogUsuario;
	}

	public String getAcao() {
		return this.acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Timestamp getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public String getInformacao() {
		return this.informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogUsuario != null ? idLogUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogUsuario)) {
            return false;
        }
        LogUsuario other = (LogUsuario) object;
        if ((this.idLogUsuario == null && other.idLogUsuario != null) 
        		|| (this.idLogUsuario != null && !this.idLogUsuario.equals(other.idLogUsuario))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getIdLogUsuario().toString(),"");
    }
}