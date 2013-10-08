package com.nuovonet.mather.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;

import com.nuovonet.mather.business.EstadoBC;
import com.nuovonet.mather.business.PaisBC;
import com.nuovonet.mather.domain.Estado;
import com.nuovonet.mather.domain.Pais;
import com.nuovonet.mather.persistence.PaisDAO;

@ViewController
@PreviousView("./estado_list.jsf")
public class EstadoEditMB extends AbstractEditPageBean<Estado, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoBC estadoBC;
	@Inject
	private PaisBC paisBC;
	
	private Parameter<Pais> parameter;
	
	@Override
	@Transactional
	public String delete() {
		this.estadoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
//		System.out.println("AQUI!!!!!!!!!!!!!!!>>>"+getBean().getPais());
//		System.out.println("AQUI!!!!!!!!!!!!!!!>>>"+getBean().getPais().getIdPais());
		this.estadoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.estadoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.estadoBC.load(getId()));
	}
	
//	@Transactional
//	public Pais getPais(Long idPais) {
//		return this.paisBC.load(idPais);
//	}

}