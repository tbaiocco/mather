package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.UnidadeBC;
import com.nuovonet.mather.domain.Unidade;

@ViewController
@PreviousView("./unidade_list.jsf")
public class UnidadeEditMB extends AbstractEditPageBean<Unidade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeBC unidadeBC;
	
	@Override
	@Transactional
	public String delete() {
		this.unidadeBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.unidadeBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.unidadeBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.unidadeBC.load(getId()));
	}

}