package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the receita database table.
 * 
 */
@Entity
@NamedQuery(name="Receita.findAll", query="SELECT r FROM Receita r")
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECEITA_CDRECEITA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECEITA_CDRECEITA_GENERATOR")
	@Column(name="cd_receita")
	private Integer cdReceita;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String obs;

	@Column(name="posologia_recei")
	private String posologiaRecei;

	//bi-directional many-to-many association to Medicamento
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="recei_medic"
		, joinColumns={
			@JoinColumn(name="fkcd_receita")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_medicam")
			}
		)
	private List<Medicamento> medicamentos;

	//bi-directional many-to-one association to PacienteProntuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fkcd_paciente", referencedColumnName="cd_paciente"),
		@JoinColumn(name="fkcd_prontuario", referencedColumnName="cd_prontuario")
		})
	private PacienteProntuario pacienteProntuario;

	public Receita() {
	}

	public Integer getCdReceita() {
		return this.cdReceita;
	}

	public void setCdReceita(Integer cdReceita) {
		this.cdReceita = cdReceita;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getPosologiaRecei() {
		return this.posologiaRecei;
	}

	public void setPosologiaRecei(String posologiaRecei) {
		this.posologiaRecei = posologiaRecei;
	}

	public List<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public PacienteProntuario getPacienteProntuario() {
		return this.pacienteProntuario;
	}

	public void setPacienteProntuario(PacienteProntuario pacienteProntuario) {
		this.pacienteProntuario = pacienteProntuario;
	}

}