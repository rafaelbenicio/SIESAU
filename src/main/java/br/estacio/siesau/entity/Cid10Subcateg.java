package br.estacio.siesau.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the cid_10_subcateg database table.
 * 
 */
@Entity
@Table(name="cid_10_subcateg")
@NamedQuery(name="Cid10Subcateg.findAll", query="SELECT c FROM Cid10Subcateg c")
public class Cid10Subcateg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CID_10_SUBCATEG_CDSUBCATEG_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CID_10_SUBCATEG_CDSUBCATEG_GENERATOR")
	@Column(name="cd_subcateg")
	private Integer cdSubcateg;

	private String causaobito;

	private String classif;

	private String descrabrev;

	private String descricao;

	private String excluido;

	private String refer;

	private String restrsexo;

	private String subcat;

	//bi-directional many-to-one association to Doenca
	@OneToMany(mappedBy="cid10Subcateg", fetch=FetchType.EAGER)
	private List<Doenca> doencas;

	public Cid10Subcateg() {
	}

	public Integer getCdSubcateg() {
		return this.cdSubcateg;
	}

	public void setCdSubcateg(Integer cdSubcateg) {
		this.cdSubcateg = cdSubcateg;
	}

	public String getCausaobito() {
		return this.causaobito;
	}

	public void setCausaobito(String causaobito) {
		this.causaobito = causaobito;
	}

	public String getClassif() {
		return this.classif;
	}

	public void setClassif(String classif) {
		this.classif = classif;
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

	public String getExcluido() {
		return this.excluido;
	}

	public void setExcluido(String excluido) {
		this.excluido = excluido;
	}

	public String getRefer() {
		return this.refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public String getRestrsexo() {
		return this.restrsexo;
	}

	public void setRestrsexo(String restrsexo) {
		this.restrsexo = restrsexo;
	}

	public String getSubcat() {
		return this.subcat;
	}

	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}

	public List<Doenca> getDoencas() {
		return this.doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}

	public Doenca addDoenca(Doenca doenca) {
		getDoencas().add(doenca);
		doenca.setCid10Subcateg(this);

		return doenca;
	}

	public Doenca removeDoenca(Doenca doenca) {
		getDoencas().remove(doenca);
		doenca.setCid10Subcateg(null);

		return doenca;
	}

}