package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the secretaria_saude database table.
 * 
 */
@Entity
@Table(name="secretaria_saude")
@NamedQuery(name="SecretariaSaude.findAll", query="SELECT s FROM SecretariaSaude s")
public class SecretariaSaude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECRETARIA_SAUDE_CDSECSAUDE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECRETARIA_SAUDE_CDSECSAUDE_GENERATOR")
	@Column(name="cd_secsaude")
	private Integer cdSecsaude;

	private String bairro;

	private Integer cep;

	private String cidade;

	private Integer cnpj;

	private String complemento;

	private String email;

	private String endereco;

	private String nome;

	private String numero;

	private Integer telefone;

	private String uf;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="secretariaSaude", fetch=FetchType.EAGER)
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to UnidadeSaude
	@OneToMany(mappedBy="secretariaSaude", fetch=FetchType.EAGER)
	private List<UnidadeSaude> unidadeSaudes;

	public SecretariaSaude() {
	}

	public Integer getCdSecsaude() {
		return this.cdSecsaude;
	}

	public void setCdSecsaude(Integer cdSecsaude) {
		this.cdSecsaude = cdSecsaude;
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

	public Integer getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setSecretariaSaude(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setSecretariaSaude(null);

		return funcionario;
	}

	public List<UnidadeSaude> getUnidadeSaudes() {
		return this.unidadeSaudes;
	}

	public void setUnidadeSaudes(List<UnidadeSaude> unidadeSaudes) {
		this.unidadeSaudes = unidadeSaudes;
	}

	public UnidadeSaude addUnidadeSaude(UnidadeSaude unidadeSaude) {
		getUnidadeSaudes().add(unidadeSaude);
		unidadeSaude.setSecretariaSaude(this);

		return unidadeSaude;
	}

	public UnidadeSaude removeUnidadeSaude(UnidadeSaude unidadeSaude) {
		getUnidadeSaudes().remove(unidadeSaude);
		unidadeSaude.setSecretariaSaude(null);

		return unidadeSaude;
	}

}