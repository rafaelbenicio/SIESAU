package br.estacio.siesau.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.estacio.siesau.entity.Fornecedor;
import br.estacio.siesau.persistence.FornecedoreDao;

@ManagedBean(name = "mbFornecedor")
public class ManagerBeanFornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;

	@PostConstruct
	public void init() {
		fornecedor = new Fornecedor();
		fornecedores = new FornecedoreDao(new Fornecedor()).lista();

	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			new FornecedoreDao(new Fornecedor()).salva(fornecedor);
			fc.addMessage("form1", new FacesMessage("Fornecedor " + fornecedor.getRazSocial() + " salvo com sucesso"));
			fornecedor = new Fornecedor();

		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Error: " + e.getMessage()));
			e.printStackTrace();
		}

	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
