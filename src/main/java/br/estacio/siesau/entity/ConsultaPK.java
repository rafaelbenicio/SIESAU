package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the consulta database table.
 * 
 */
@Embeddable
public class ConsultaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cd_consulta")
	private Integer cdConsulta;

	@Column(name="cd_paciente")
	private Integer cdPaciente;

	@Column(name="cd_prontuario")
	private Integer cdProntuario;

	@Column(name="cd_doenca")
	private Integer cdDoenca;

	@Column(name="cd_receita")
	private Integer cdReceita;

	@Column(name="cd_exame")
	private Integer cdExame;

	@Column(name="cd_func")
	private Integer cdFunc;

	public ConsultaPK() {
	}
	public Integer getCdConsulta() {
		return this.cdConsulta;
	}
	public void setCdConsulta(Integer cdConsulta) {
		this.cdConsulta = cdConsulta;
	}
	public Integer getCdPaciente() {
		return this.cdPaciente;
	}
	public void setCdPaciente(Integer cdPaciente) {
		this.cdPaciente = cdPaciente;
	}
	public Integer getCdProntuario() {
		return this.cdProntuario;
	}
	public void setCdProntuario(Integer cdProntuario) {
		this.cdProntuario = cdProntuario;
	}
	public Integer getCdDoenca() {
		return this.cdDoenca;
	}
	public void setCdDoenca(Integer cdDoenca) {
		this.cdDoenca = cdDoenca;
	}
	public Integer getCdReceita() {
		return this.cdReceita;
	}
	public void setCdReceita(Integer cdReceita) {
		this.cdReceita = cdReceita;
	}
	public Integer getCdExame() {
		return this.cdExame;
	}
	public void setCdExame(Integer cdExame) {
		this.cdExame = cdExame;
	}
	public Integer getCdFunc() {
		return this.cdFunc;
	}
	public void setCdFunc(Integer cdFunc) {
		this.cdFunc = cdFunc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsultaPK)) {
			return false;
		}
		ConsultaPK castOther = (ConsultaPK)other;
		return 
			this.cdConsulta.equals(castOther.cdConsulta)
			&& this.cdPaciente.equals(castOther.cdPaciente)
			&& this.cdProntuario.equals(castOther.cdProntuario)
			&& this.cdDoenca.equals(castOther.cdDoenca)
			&& this.cdReceita.equals(castOther.cdReceita)
			&& this.cdExame.equals(castOther.cdExame)
			&& this.cdFunc.equals(castOther.cdFunc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdConsulta.hashCode();
		hash = hash * prime + this.cdPaciente.hashCode();
		hash = hash * prime + this.cdProntuario.hashCode();
		hash = hash * prime + this.cdDoenca.hashCode();
		hash = hash * prime + this.cdReceita.hashCode();
		hash = hash * prime + this.cdExame.hashCode();
		hash = hash * prime + this.cdFunc.hashCode();
		
		return hash;
	}
}