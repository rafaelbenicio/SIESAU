package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidade database table.
 * 
 */
@Entity
@NamedQuery(name="Especialidade.findAll", query="SELECT e FROM Especialidade e")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESPECIALIDADE_CDESPEC_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESPECIALIDADE_CDESPEC_GENERATOR")
	@Column(name="cd_espec")
	private Integer cdEspec;

	private String descricao;

	//bi-directional many-to-many association to Cargo
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="med_espec"
		, joinColumns={
			@JoinColumn(name="fkcd_espec")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_cargo")
			}
		)
	private List<Cargo> cargos1;

	//bi-directional many-to-many association to Cargo
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="tec_espec"
		, joinColumns={
			@JoinColumn(name="fkcd_espec")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_cargo")
			}
		)
	private List<Cargo> cargos2;

	//bi-directional many-to-many association to UnidadeSaude
	@ManyToMany(mappedBy="especialidades", fetch=FetchType.EAGER)
	private List<UnidadeSaude> unidadeSaudes;

	public Especialidade() {
	}

	public Integer getCdEspec() {
		return this.cdEspec;
	}

	public void setCdEspec(Integer cdEspec) {
		this.cdEspec = cdEspec;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Cargo> getCargos1() {
		return this.cargos1;
	}

	public void setCargos1(List<Cargo> cargos1) {
		this.cargos1 = cargos1;
	}

	public List<Cargo> getCargos2() {
		return this.cargos2;
	}

	public void setCargos2(List<Cargo> cargos2) {
		this.cargos2 = cargos2;
	}

	public List<UnidadeSaude> getUnidadeSaudes() {
		return this.unidadeSaudes;
	}

	public void setUnidadeSaudes(List<UnidadeSaude> unidadeSaudes) {
		this.unidadeSaudes = unidadeSaudes;
	}

}