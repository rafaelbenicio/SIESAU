package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the laudo database table.
 * 
 */
@Entity
@NamedQuery(name="Laudo.findAll", query="SELECT l FROM Laudo l")
public class Laudo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LAUDO_CDLAUDO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LAUDO_CDLAUDO_GENERATOR")
	@Column(name="cd_laudo")
	private Integer cdLaudo;

	private String resultado;

	//bi-directional many-to-many association to Exame
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="exam_laud"
		, joinColumns={
			@JoinColumn(name="fkcd_laudo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fkcd_exame")
			}
		)
	private List<Exame> exames;

	//bi-directional many-to-one association to PacienteProntuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fkcd_paciente", referencedColumnName="cd_paciente"),
		@JoinColumn(name="fkcd_prontuario", referencedColumnName="cd_prontuario")
		})
	private PacienteProntuario pacienteProntuario;

	public Laudo() {
	}

	public Integer getCdLaudo() {
		return this.cdLaudo;
	}

	public void setCdLaudo(Integer cdLaudo) {
		this.cdLaudo = cdLaudo;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<Exame> getExames() {
		return this.exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public PacienteProntuario getPacienteProntuario() {
		return this.pacienteProntuario;
	}

	public void setPacienteProntuario(PacienteProntuario pacienteProntuario) {
		this.pacienteProntuario = pacienteProntuario;
	}

}