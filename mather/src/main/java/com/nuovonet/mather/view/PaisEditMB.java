package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.PaisBC;
import com.nuovonet.mather.domain.Pais;

@ViewController
@PreviousView("./pais_list.jsf")
public class PaisEditMB extends AbstractEditPageBean<Pais, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PaisBC paisBC;
	
	@Override
	@Transactional
	public String delete() {
		this.paisBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.paisBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.paisBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.paisBC.load(getId()));
	}

}