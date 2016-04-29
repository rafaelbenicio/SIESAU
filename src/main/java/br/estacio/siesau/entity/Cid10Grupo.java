package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cid_10_grupo database table.
 * 
 */
@Entity
@Table(name="cid_10_grupo")
@NamedQuery(name="Cid10Grupo.findAll", query="SELECT c FROM Cid10Grupo c")
public class Cid10Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CID_10_GRUPO_CDCID10GRUPO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CID_10_GRUPO_CDCID10GRUPO_GENERATOR")
	@Column(name="cd_cid_10_grupo")
	private Integer cdCid10Grupo;

	private String catfim;

	private String catinic;

	private String descrabrev;

	private String descricao;

	//bi-directional many-to-one association to Doenca
	@OneToMany(mappedBy="cid10Grupo", fetch=FetchType.EAGER)
	private List<Doenca> doencas;

	public Cid10Grupo() {
	}

	public Integer getCdCid10Grupo() {
		return this.cdCid10Grupo;
	}

	public void setCdCid10Grupo(Integer cdCid10Grupo) {
		this.cdCid10Grupo = cdCid10Grupo;
	}

	public String getCatfim() {
		return this.catfim;
	}

	public void setCatfim(String catfim) {
		this.catfim = catfim;
	}

	public String getCatinic() {
		return this.catinic;
	}

	public void setCatinic(String catinic) {
		this.catinic = catinic;
	}

	public String getDescrabrev() {
		return this.descrabrev;
	}

	public void setDescrabrev(String descrabrev) {
		this.descrabrev = descrabrev;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Doenca> getDoencas() {
		return this.doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}

	public Doenca addDoenca(Doenca doenca) {
		getDoencas().add(doenca);
		doenca.setCid10Grupo(this);

		return doenca;
	}

	public Doenca removeDoenca(Doenca doenca) {
		getDoencas().remove(doenca);
		doenca.setCid10Grupo(null);

		return doenca;
	}

}