package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.CidadeBC;
import com.nuovonet.mather.domain.Cidade;

@ViewController
@PreviousView("./cidade_list.jsf")
public class CidadeEditMB extends AbstractEditPageBean<Cidade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeBC cidadeBC;
	
	@Override
	@Transactional
	public String delete() {
		this.cidadeBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.cidadeBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.cidadeBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.cidadeBC.load(getId()));
	}

}