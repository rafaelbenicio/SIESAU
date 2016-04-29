package br.estacio.siesau.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the unidade_saude database table.
 * 
 */
@Entity
@Table(name="unidade_saude")
@NamedQuery(name="UnidadeSaude.findAll", query="SELECT u FROM UnidadeSaude u")
public class UnidadeSaude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDADE_SAUDE_CDUNIDSAUDE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADE_SAUDE_CDUNIDSAUDE_GENERATOR")
	@Column(name="cd_unidsaude")
	private Integer cdUnidsaude;

	private Boolean ativo;

	private String bairro;

	private Integer cep;

	private String cidade;

	private String cnes;

	private Integer cnpj;

	private String complemento;

	private String email;

	private String endereco;

	private String nome;

	private String numero;

	private Integer tel;

	private String uf;

	//bi-directional many-to-many association to PacienteProntuario
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="pac_unidsaude"
		, joinColumns={
			@JoinColumn(name="fkcd_unidsaude")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_paciente", referencedColumnName="cd_paciente"),
			@JoinColumn(name="fkcd_prontuario", referencedColumnName="cd_prontuario")
			}
		)
	private List<PacienteProntuario> pacienteProntuarios;

	//bi-directional many-to-many association to Especialidade
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="unid_espec"
		, joinColumns={
			@JoinColumn(name="fkcd_unidsaude")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_espec")
			}
		)
	private List<Especialidade> especialidades;

	//bi-directional many-to-many association to Funcionario
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="unid_func"
		, joinColumns={
			@JoinColumn(name="fkcd_unidsaude")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_func")
			}
		)
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to SecretariaSaude
	@ManyToOne
	@JoinColumn(name="fkcd_secsaude")
	private SecretariaSaude secretariaSaude;

	public UnidadeSaude() {
	}

	public Integer getCdUnidsaude() {
		return this.cdUnidsaude;
	}

	public void setCdUnidsaude(Integer cdUnidsaude) {
		this.cdUnidsaude = cdUnidsaude;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return this.cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnes() {
		return this.cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public Integer getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<PacienteProntuario> getPacienteProntuarios() {
		return this.pacienteProntuarios;
	}

	public void setPacienteProntuarios(List<PacienteProntuario> pacienteProntuarios) {
		this.pacienteProntuarios = pacienteProntuarios;
	}

	public List<Especialidade> getEspecialidades() {
		return this.especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public SecretariaSaude getSecretariaSaude() {
		return this.secretariaSaude;
	}

	public void setSecretariaSaude(SecretariaSaude secretariaSaude) {
		this.secretariaSaude = secretariaSaude;
	}

}