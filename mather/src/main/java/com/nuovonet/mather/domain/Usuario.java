package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;

import java.util.List;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long idUsuario;

	@Column(name="nm_senha")
	private String nmSenha;

	@Column(name="nm_usuario")
	private String nmUsuario;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfi;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to LogUsuario
	@OneToMany(mappedBy="usuario")
	private List<LogUsuario> logUsuarios;

	//bi-directional many-to-many association to Sistema
	@ManyToMany
	@JoinTable(
		name="usuarios_sistemas"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_sistema")
			}
		)
	private List<Sistema> sistemas;

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		super.setId(idUsuario);
		this.idUsuario = idUsuario;
	}

	public String getNmSenha() {
		return this.nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public String getNmUsuario() {
		return this.nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public Perfil getPerfi() {
		return this.perfi;
	}

	public void setPerfi(Perfil perfi) {
		this.perfi = perfi;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<LogUsuario> getLogUsuarios() {
		return this.logUsuarios;
	}

	public void setLogUsuarios(List<LogUsuario> logUsuarios) {
		this.logUsuarios = logUsuarios;
	}

	public LogUsuario addLogUsuario(LogUsuario logUsuario) {
		getLogUsuarios().add(logUsuario);
		logUsuario.setUsuario(this);

		return logUsuario;
	}

	public LogUsuario removeLogUsuario(LogUsuario logUsuario) {
		getLogUsuarios().remove(logUsuario);
		logUsuario.setUsuario(null);

		return logUsuario;
	}

	public List<Sistema> getSistemas() {
		return this.sistemas;
	}

	public void setSistemas(List<Sistema> sistemas) {
		this.sistemas = sistemas;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) 
        		|| (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmUsuario(),"");
    }
}