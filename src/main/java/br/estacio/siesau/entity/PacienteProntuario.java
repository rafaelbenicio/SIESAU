package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente_prontuario database table.
 * 
 */
@Entity
@Table(name="paciente_prontuario")
@NamedQuery(name="PacienteProntuario.findAll", query="SELECT p FROM PacienteProntuario p")
public class PacienteProntuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PacienteProntuarioPK id;

	private String bairro;

	@Column(name="cartao_sus")
	private Integer cartaoSus;

	private Integer cep;

	private String cidade;

	private String complemento;

	private Integer cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cad")
	private Date dataCad;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fim_tratamento")
	private Date dataFimTratamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio_tratamento")
	private Date dataInicioTratamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Date dataNasc;

	private String email;

	private String endereco;

	@Column(name="est_civil")
	private String estCivil;

	private String etnia;

	private String naturalidade;

	private String nome;

	@Column(name="nome_mae")
	private String nomeMae;

	@Column(name="nome_pai")
	private String nomePai;

	private String numero;

	private String obs;

	private String observacao;

	private String profissao;

	private Integer rg;

	@Column(name="tel_cel")
	private Integer telCel;

	@Column(name="tel_res")
	private Integer telRes;

	private String uf;

	//bi-directional many-to-one association to Exame
	@OneToMany(mappedBy="pacienteProntuario", fetch=FetchType.EAGER)
	private List<Exame> exames;

	//bi-directional many-to-one association to Laudo
	@OneToMany(mappedBy="pacienteProntuario", fetch=FetchType.EAGER)
	private List<Laudo> laudos;

	//bi-directional many-to-many association to UnidadeSaude
	@ManyToMany(mappedBy="pacienteProntuarios", fetch=FetchType.EAGER)
	private List<UnidadeSaude> unidadeSaudes;

	//bi-directional many-to-one association to Receita
	@OneToMany(mappedBy="pacienteProntuario", fetch=FetchType.EAGER)
	private List<Receita> receitas;

	public PacienteProntuario() {
	}

	public PacienteProntuarioPK getId() {
		return this.id;
	}

	public void setId(PacienteProntuarioPK id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCartaoSus() {
		return this.cartaoSus;
	}

	public void setCartaoSus(Integer cartaoSus) {
		this.cartaoSus = cartaoSus;
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

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getCpf() {
		return this.cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Date getDataCad() {
		return this.dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public Date getDataFimTratamento() {
		return this.dataFimTratamento;
	}

	public void setDataFimTratamento(Date dataFimTratamento) {
		this.dataFimTratamento = dataFimTratamento;
	}

	public Date getDataInicioTratamento() {
		return this.dataInicioTratamento;
	}

	public void setDataInicioTratamento(Date dataInicioTratamento) {
		this.dataInicioTratamento = dataInicioTratamento;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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

	public String getEstCivil() {
		return this.estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getNaturalidade() {
		return this.naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Integer getRg() {
		return this.rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
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

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Exame> getExames() {
		return this.exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public Exame addExame(Exame exame) {
		getExames().add(exame);
		exame.setPacienteProntuario(this);

		return exame;
	}

	public Exame removeExame(Exame exame) {
		getExames().remove(exame);
		exame.setPacienteProntuario(null);

		return exame;
	}

	public List<Laudo> getLaudos() {
		return this.laudos;
	}

	public void setLaudos(List<Laudo> laudos) {
		this.laudos = laudos;
	}

	public Laudo addLaudo(Laudo laudo) {
		getLaudos().add(laudo);
		laudo.setPacienteProntuario(this);

		return laudo;
	}

	public Laudo removeLaudo(Laudo laudo) {
		getLaudos().remove(laudo);
		laudo.setPacienteProntuario(null);

		return laudo;
	}

	public List<UnidadeSaude> getUnidadeSaudes() {
		return this.unidadeSaudes;
	}

	public void setUnidadeSaudes(List<UnidadeSaude> unidadeSaudes) {
		this.unidadeSaudes = unidadeSaudes;
	}

	public List<Receita> getReceitas() {
		return this.receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public Receita addReceita(Receita receita) {
		getReceitas().add(receita);
		receita.setPacienteProntuario(this);

		return receita;
	}

	public Receita removeReceita(Receita receita) {
		getReceitas().remove(receita);
		receita.setPacienteProntuario(null);

		return receita;
	}

}