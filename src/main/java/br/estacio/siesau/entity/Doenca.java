package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doenca database table.
 * 
 */
@Entity
@NamedQuery(name="Doenca.findAll", query="SELECT d FROM Doenca d")
public class Doenca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOENCA_CDDOENCA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOENCA_CDDOENCA_GENERATOR")
	@Column(name="cd_doenca")
	private Integer cdDoenca;

	private String cid;

	private String nome;

	//bi-directional many-to-one association to Cid10Capitulo
	@ManyToOne
	@JoinColumn(name="fkcd_capitulo")
	private Cid10Capitulo cid10Capitulo;

	//bi-directional many-to-one association to Cid10Categ
	@ManyToOne
	@JoinColumn(name="fkcd_cid_10_categ")
	private Cid10Categ cid10Categ;

	//bi-directional many-to-one association to Cid10Grupo
	@ManyToOne
	@JoinColumn(name="fkcd_cid_10_grupo")
	private Cid10Grupo cid10Grupo;

	//bi-directional many-to-one association to Cid10Subcateg
	@ManyToOne
	@JoinColumn(name="fkcd_subcateg")
	private Cid10Subcateg cid10Subcateg;

	//bi-directional many-to-one association to CidOCateg
	@ManyToOne
	@JoinColumn(name="fkcd_cid_o_categ")
	private CidOCateg cidOCateg;

	//bi-directional many-to-one association to CidOGrupo
	@ManyToOne
	@JoinColumn(name="fkcd_cid_o_grupo")
	private CidOGrupo cidOGrupo;

	public Doenca() {
	}

	public Integer getCdDoenca() {
		return this.cdDoenca;
	}

	public void setCdDoenca(Integer cdDoenca) {
		this.cdDoenca = cdDoenca;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cid10Capitulo getCid10Capitulo() {
		return this.cid10Capitulo;
	}

	public void setCid10Capitulo(Cid10Capitulo cid10Capitulo) {
		this.cid10Capitulo = cid10Capitulo;
	}

	public Cid10Categ getCid10Categ() {
		return this.cid10Categ;
	}

	public void setCid10Categ(Cid10Categ cid10Categ) {
		this.cid10Categ = cid10Categ;
	}

	public Cid10Grupo getCid10Grupo() {
		return this.cid10Grupo;
	}

	public void setCid10Grupo(Cid10Grupo cid10Grupo) {
		this.cid10Grupo = cid10Grupo;
	}

	public Cid10Subcateg getCid10Subcateg() {
		return this.cid10Subcateg;
	}

	public void setCid10Subcateg(Cid10Subcateg cid10Subcateg) {
		this.cid10Subcateg = cid10Subcateg;
	}

	public CidOCateg getCidOCateg() {
		return this.cidOCateg;
	}

	public void setCidOCateg(CidOCateg cidOCateg) {
		this.cidOCateg = cidOCateg;
	}

	public CidOGrupo getCidOGrupo() {
		return this.cidOGrupo;
	}

	public void setCidOGrupo(CidOGrupo cidOGrupo) {
		this.cidOGrupo = cidOGrupo;
	}

}