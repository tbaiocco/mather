package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoAtividadeBC;
import com.nuovonet.mather.domain.TipoAtividade;

@ViewController
@PreviousView("./tipoAtividade_list.jsf")
public class TipoAtividadeEditMB extends AbstractEditPageBean<TipoAtividade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtividadeBC tipoAtividadeBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tipoAtividadeBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoAtividadeBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoAtividadeBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tipoAtividadeBC.load(getId()));
	}

}