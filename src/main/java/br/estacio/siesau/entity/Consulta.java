package br.estacio.siesau.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consulta database table.
 * 
 */
@Entity
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsultaPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cons")
	private Date dataCons;

	@Temporal(TemporalType.DATE)
	private Date hora;

	private String motivo;

	public Consulta() {
	}

	public ConsultaPK getId() {
		return this.id;
	}

	public void setId(ConsultaPK id) {
		this.id = id;
	}

	public Date getDataCons() {
		return this.dataCons;
	}

	public void setDataCons(Date dataCons) {
		this.dataCons = dataCons;
	}

	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}