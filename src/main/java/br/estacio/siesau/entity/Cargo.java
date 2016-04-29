package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARGO_CDCARGO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARGO_CDCARGO_GENERATOR")
	@Column(name="cd_cargo")
	private Integer cdCargo;

	@Column(name="cd_administrativo")
	private Integer cdAdministrativo;

	@Column(name="cd_enfermeira")
	private Integer cdEnfermeira;

	@Column(name="cd_medico")
	private Integer cdMedico;

	@Column(name="cd_tecradiologia")
	private Integer cdTecradiologia;

	private String coren;

	private Integer crm;

	private String crtr;

	private String nome;

	//bi-directional many-to-one association to TipoAdmini
	@ManyToOne
	@JoinColumn(name="fkcd_tipoadminis")
	private TipoAdmini tipoAdmini;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="cargo", fetch=FetchType.EAGER)
	private List<Funcionario> funcionarios;

	//bi-directional many-to-many association to Especialidade
	@ManyToMany(mappedBy="cargos1", fetch=FetchType.EAGER)
	private List<Especialidade> especialidades1;

	//bi-directional many-to-many association to Especialidade
	@ManyToMany(mappedBy="cargos2", fetch=FetchType.EAGER)
	private List<Especialidade> especialidades2;

	public Cargo() {
	}

	public Integer getCdCargo() {
		return this.cdCargo;
	}

	public void setCdCargo(Integer cdCargo) {
		this.cdCargo = cdCargo;
	}

	public Integer getCdAdministrativo() {
		return this.cdAdministrativo;
	}

	public void setCdAdministrativo(Integer cdAdministrativo) {
		this.cdAdministrativo = cdAdministrativo;
	}

	public Integer getCdEnfermeira() {
		return this.cdEnfermeira;
	}

	public void setCdEnfermeira(Integer cdEnfermeira) {
		this.cdEnfermeira = cdEnfermeira;
	}

	public Integer getCdMedico() {
		return this.cdMedico;
	}

	public void setCdMedico(Integer cdMedico) {
		this.cdMedico = cdMedico;
	}

	public Integer getCdTecradiologia() {
		return this.cdTecradiologia;
	}

	public void setCdTecradiologia(Integer cdTecradiologia) {
		this.cdTecradiologia = cdTecradiologia;
	}

	public String getCoren() {
		return this.coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}

	public Integer getCrm() {
		return this.crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
	}

	public String getCrtr() {
		return this.crtr;
	}

	public void setCrtr(String crtr) {
		this.crtr = crtr;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAdmini getTipoAdmini() {
		return this.tipoAdmini;
	}

	public void setTipoAdmini(TipoAdmini tipoAdmini) {
		this.tipoAdmini = tipoAdmini;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setCargo(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setCargo(null);

		return funcionario;
	}

	public List<Especialidade> getEspecialidades1() {
		return this.especialidades1;
	}

	public void setEspecialidades1(List<Especialidade> especialidades1) {
		this.especialidades1 = especialidades1;
	}

	public List<Especialidade> getEspecialidades2() {
		return this.especialidades2;
	}

	public void setEspecialidades2(List<Especialidade> especialidades2) {
		this.especialidades2 = especialidades2;
	}

}