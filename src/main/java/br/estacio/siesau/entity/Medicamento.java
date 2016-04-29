package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEDICAMENTO_CDMEDICAM_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICAMENTO_CDMEDICAM_GENERATOR")
	@Column(name="cd_medicam")
	private Integer cdMedicam;

	private Boolean ativo;

	private String concentracao;

	private Boolean controlado;

	private String forma;

	private String ms;

	@Column(name="nome_ref")
	private String nomeRef;

	private String subst;

	//bi-directional many-to-one association to Fabricante
	@ManyToOne
	@JoinColumn(name="fkcd_fabric")
	private Fabricante fabricante;

	//bi-directional many-to-many association to Receita
	@ManyToMany(mappedBy="medicamentos", fetch=FetchType.EAGER)
	private List<Receita> receitas;

	public Medicamento() {
	}

	public Integer getCdMedicam() {
		return this.cdMedicam;
	}

	public void setCdMedicam(Integer cdMedicam) {
		this.cdMedicam = cdMedicam;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getConcentracao() {
		return this.concentracao;
	}

	public void setConcentracao(String concentracao) {
		this.concentracao = concentracao;
	}

	public Boolean getControlado() {
		return this.controlado;
	}

	public void setControlado(Boolean controlado) {
		this.controlado = controlado;
	}

	public String getForma() {
		return this.forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getMs() {
		return this.ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getNomeRef() {
		return this.nomeRef;
	}

	public void setNomeRef(String nomeRef) {
		this.nomeRef = nomeRef;
	}

	public String getSubst() {
		return this.subst;
	}

	public void setSubst(String subst) {
		this.subst = subst;
	}

	public Fabricante getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Receita> getReceitas() {
		return this.receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

}