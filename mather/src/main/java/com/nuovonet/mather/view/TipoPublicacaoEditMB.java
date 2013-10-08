package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoPublicacaoBC;
import com.nuovonet.mather.domain.TipoPublicacao;

@ViewController
@PreviousView("./tipoPublicacao_list.jsf")
public class TipoPublicacaoEditMB extends AbstractEditPageBean<TipoPublicacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoPublicacaoBC tipoPublicacaoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tipoPublicacaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoPublicacaoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoPublicacaoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tipoPublicacaoBC.load(getId()));
	}

}