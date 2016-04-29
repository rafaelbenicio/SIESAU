package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the exame database table.
 * 
 */
@Entity
@NamedQuery(name="Exame.findAll", query="SELECT e FROM Exame e")
public class Exame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXAME_CDEXAME_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXAME_CDEXAME_GENERATOR")
	@Column(name="cd_exame")
	private Integer cdExame;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String nome;

	private String obs;

	//bi-directional many-to-many association to Laudo
	@ManyToMany(mappedBy="exames", fetch=FetchType.EAGER)
	private List<Laudo> laudos;

	//bi-directional many-to-one association to PacienteProntuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fkcd_paciente", referencedColumnName="cd_paciente"),
		@JoinColumn(name="fkcd_prontuario", referencedColumnName="cd_prontuario")
		})
	private PacienteProntuario pacienteProntuario;

	//bi-directional many-to-one association to TipoExame
	@ManyToOne
	@JoinColumn(name="fkcd_tipoexame")
	private TipoExame tipoExame;

	public Exame() {
	}

	public Integer getCdExame() {
		return this.cdExame;
	}

	public void setCdExame(Integer cdExame) {
		this.cdExame = cdExame;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Laudo> getLaudos() {
		return this.laudos;
	}

	public void setLaudos(List<Laudo> laudos) {
		this.laudos = laudos;
	}

	public PacienteProntuario getPacienteProntuario() {
		return this.pacienteProntuario;
	}

	public void setPacienteProntuario(PacienteProntuario pacienteProntuario) {
		this.pacienteProntuario = pacienteProntuario;
	}

	public TipoExame getTipoExame() {
		return this.tipoExame;
	}

	public void setTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

}