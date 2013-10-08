package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.NumeracaoBC;
import com.nuovonet.mather.domain.Numeracao;

@ViewController
@PreviousView("./numeracao_list.jsf")
public class NumeracaoEditMB extends AbstractEditPageBean<Numeracao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NumeracaoBC numeracaoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.numeracaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.numeracaoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.numeracaoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.numeracaoBC.load(getId()));
	}

}