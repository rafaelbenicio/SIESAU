package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the paciente_prontuario database table.
 * 
 */
@Embeddable
public class PacienteProntuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cd_paciente")
	private Integer cdPaciente;

	@Column(name="cd_prontuario")
	private Integer cdProntuario;

	public PacienteProntuarioPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PacienteProntuarioPK)) {
			return false;
		}
		PacienteProntuarioPK castOther = (PacienteProntuarioPK)other;
		return 
			this.cdPaciente.equals(castOther.cdPaciente)
			&& this.cdProntuario.equals(castOther.cdProntuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdPaciente.hashCode();
		hash = hash * prime + this.cdProntuario.hashCode();
		
		return hash;
	}
}