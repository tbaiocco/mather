package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.nuovonet.mather.util.Utilitaria;

import java.util.List;
import com.nuovonet.mather.domain.util.AbstractEntity;

/**
 * The persistent class for the perfis database table.
 * 
 */
@Entity
@Table(name="perfis")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_perfil")
	private Long idPerfil;

	@Column(name="nm_perfil")
	private String nmPerfil;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfi")
	private List<Usuario> usuarios;

	//bi-directional many-to-many association to Sistema
	@ManyToMany
	@JoinTable(
		name="perfis_sistemas"
		, joinColumns={
			@JoinColumn(name="id_perfil")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_sistema")
			}
		)
	private List<Sistema> sistemas;

	public Perfil() {
	}

	public Long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		super.setId(idPerfil);
		this.idPerfil = idPerfil;
	}

	public String getNmPerfil() {
		return this.nmPerfil;
	}

	public void setNmPerfil(String nmPerfil) {
		this.nmPerfil = nmPerfil;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfi(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfi(null);

		return usuario;
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
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) 
        		|| (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	return Utilitaria.getValueDef(this.getNmPerfil(),"");
    }
}