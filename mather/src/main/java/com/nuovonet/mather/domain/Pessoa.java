package com.nuovonet.mather.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoas database table.
 * 
 */
@Entity
@Table(name="pessoas")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pessoa")
	private Long idPessoa;

	@Column(name="dm_situacao")
	private String dmSituacao;

	private String email;

	@Column(name="nm_bairro")
	private String nmBairro;

	@Column(name="nm_complemento")
	private String nmComplemento;

	@Column(name="nm_endereco")
	private String nmEndereco;

	@Column(name="nm_fantasia")
	private String nmFantasia;

	@Column(name="nm_inscricao_estadual")
	private String nmInscricaoEstadual;

	@Column(name="nm_razao_social")
	private String nmRazaoSocial;

	@Column(name="nm_site")
	private String nmSite;

	@Column(name="nr_cep")
	private String nrCep;

	@Column(name="nr_cnpj_cpf")
	private String nrCnpjCpf;

	@Column(name="nr_endereco")
	private String nrEndereco;

	@Column(name="nr_fax")
	private String nrFax;

	@Column(name="nr_telefone")
	private String nrTelefone;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="pessoa")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to Escola
	@OneToMany(mappedBy="pessoa")
	private List<Escola> escolas;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="pessoa")
	private List<Unidade> unidades;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="pessoa")
	private List<Usuario> usuarios;

	public Pessoa() {
	}

	public Long getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getDmSituacao() {
		return this.dmSituacao;
	}

	public void setDmSituacao(String dmSituacao) {
		this.dmSituacao = dmSituacao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNmBairro() {
		return this.nmBairro;
	}

	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	public String getNmComplemento() {
		return this.nmComplemento;
	}

	public void setNmComplemento(String nmComplemento) {
		this.nmComplemento = nmComplemento;
	}

	public String getNmEndereco() {
		return this.nmEndereco;
	}

	public void setNmEndereco(String nmEndereco) {
		this.nmEndereco = nmEndereco;
	}

	public String getNmFantasia() {
		return this.nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	public String getNmInscricaoEstadual() {
		return this.nmInscricaoEstadual;
	}

	public void setNmInscricaoEstadual(String nmInscricaoEstadual) {
		this.nmInscricaoEstadual = nmInscricaoEstadual;
	}

	public String getNmRazaoSocial() {
		return this.nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}

	public String getNmSite() {
		return this.nmSite;
	}

	public void setNmSite(String nmSite) {
		this.nmSite = nmSite;
	}

	public String getNrCep() {
		return this.nrCep;
	}

	public void setNrCep(String nrCep) {
		this.nrCep = nrCep;
	}

	public String getNrCnpjCpf() {
		return this.nrCnpjCpf;
	}

	public void setNrCnpjCpf(String nrCnpjCpf) {
		this.nrCnpjCpf = nrCnpjCpf;
	}

	public String getNrEndereco() {
		return this.nrEndereco;
	}

	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public String getNrFax() {
		return this.nrFax;
	}

	public void setNrFax(String nrFax) {
		this.nrFax = nrFax;
	}

	public String getNrTelefone() {
		return this.nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setPessoa(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setPessoa(null);

		return empresa;
	}

	public List<Escola> getEscolas() {
		return this.escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public Escola addEscola(Escola escola) {
		getEscolas().add(escola);
		escola.setPessoa(this);

		return escola;
	}

	public Escola removeEscola(Escola escola) {
		getEscolas().remove(escola);
		escola.setPessoa(null);

		return escola;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Unidade> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Unidade addUnidade(Unidade unidade) {
		getUnidades().add(unidade);
		unidade.setPessoa(this);

		return unidade;
	}

	public Unidade removeUnidade(Unidade unidade) {
		getUnidades().remove(unidade);
		unidade.setPessoa(null);

		return unidade;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPessoa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPessoa(null);

		return usuario;
	}

}