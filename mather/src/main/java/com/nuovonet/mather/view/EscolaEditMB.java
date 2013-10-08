package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.EscolaBC;
import com.nuovonet.mather.domain.Escola;

@ViewController
@PreviousView("./escola_list.jsf")
public class EscolaEditMB extends AbstractEditPageBean<Escola, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EscolaBC escolaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.escolaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.escolaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.escolaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.escolaBC.load(getId()));
	}

}