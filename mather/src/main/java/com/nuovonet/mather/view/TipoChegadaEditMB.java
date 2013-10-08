package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoChegadaBC;
import com.nuovonet.mather.domain.TipoChegada;

@ViewController
@PreviousView("./tipoChegada_list.jsf")
public class TipoChegadaEditMB extends AbstractEditPageBean<TipoChegada, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoChegadaBC tipoChegadaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tipoChegadaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoChegadaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoChegadaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tipoChegadaBC.load(getId()));
	}

}