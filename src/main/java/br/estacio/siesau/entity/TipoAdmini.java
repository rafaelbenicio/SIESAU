package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_adminis database table.
 * 
 */
@Entity
@Table(name="tipo_adminis")
@NamedQuery(name="TipoAdmini.findAll", query="SELECT t FROM TipoAdmini t")
public class TipoAdmini implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_ADMINIS_CDTIPOADMINIS_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_ADMINIS_CDTIPOADMINIS_GENERATOR")
	@Column(name="cd_tipoadminis")
	private Integer cdTipoadminis;

	private String nome;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="tipoAdmini", fetch=FetchType.EAGER)
	private List<Cargo> cargos;

	public TipoAdmini() {
	}

	public Integer getCdTipoadminis() {
		return this.cdTipoadminis;
	}

	public void setCdTipoadminis(Integer cdTipoadminis) {
		this.cdTipoadminis = cdTipoadminis;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo addCargo(Cargo cargo) {
		getCargos().add(cargo);
		cargo.setTipoAdmini(this);

		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setTipoAdmini(null);

		return cargo;
	}

}