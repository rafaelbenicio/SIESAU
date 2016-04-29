package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUNCIONARIO_CDFUNC_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUNCIONARIO_CDFUNC_GENERATOR")
	@Column(name="cd_func")
	private Integer cdFunc;

	private Boolean ativo;

	private Integer cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="data_admis")
	private Date dataAdmis;

	private String endereco;

	private String login;

	private String nome;

	private Integer rg;

	private String senha;

	@Column(name="tel_cel")
	private Integer telCel;

	@Column(name="tel_res")
	private Integer telRes;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="fkcd_cargo")
	private Cargo cargo;

	//bi-directional many-to-one association to SecretariaSaude
	@ManyToOne
	@JoinColumn(name="fkcd_secsaude")
	private SecretariaSaude secretariaSaude;

	//bi-directional many-to-one association to TipoFuncionario
	@ManyToOne
	@JoinColumn(name="fkcd_tipofunc")
	private TipoFuncionario tipoFuncionario;

	//bi-directional many-to-many association to UnidadeSaude
	@ManyToMany(mappedBy="funcionarios", fetch=FetchType.EAGER)
	private List<UnidadeSaude> unidadeSaudes;

	public Funcionario() {
	}

	public Integer getCdFunc() {
		return this.cdFunc;
	}

	public void setCdFunc(Integer cdFunc) {
		this.cdFunc = cdFunc;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getCpf() {
		return this.cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Date getDataAdmis() {
		return this.dataAdmis;
	}

	public void setDataAdmis(Date dataAdmis) {
		this.dataAdmis = dataAdmis;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRg() {
		return this.rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTelCel() {
		return this.telCel;
	}

	public void setTelCel(Integer telCel) {
		this.telCel = telCel;
	}

	public Integer getTelRes() {
		return this.telRes;
	}

	public void setTelRes(Integer telRes) {
		this.telRes = telRes;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public SecretariaSaude getSecretariaSaude() {
		return this.secretariaSaude;
	}

	public void setSecretariaSaude(SecretariaSaude secretariaSaude) {
		this.secretariaSaude = secretariaSaude;
	}

	public TipoFuncionario getTipoFuncionario() {
		return this.tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public List<UnidadeSaude> getUnidadeSaudes() {
		return this.unidadeSaudes;
	}

	public void setUnidadeSaudes(List<UnidadeSaude> unidadeSaudes) {
		this.unidadeSaudes = unidadeSaudes;
	}

}