package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoSaidaBC;
import com.nuovonet.mather.domain.TipoSaida;

@ViewController
@PreviousView("./tipoSaida_list.jsf")
public class TipoSaidaEditMB extends AbstractEditPageBean<TipoSaida, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoSaidaBC tipoSaidaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tipoSaidaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoSaidaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoSaidaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tipoSaidaBC.load(getId()));
	}

}