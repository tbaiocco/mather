package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoServicoBC;
import com.nuovonet.mather.domain.TipoServico;

@ViewController
@PreviousView("./tipoServico_list.jsf")
public class TipoServicoEditMB extends AbstractEditPageBean<TipoServico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoServicoBC tipoServicoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tipoServicoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoServicoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoServicoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tipoServicoBC.load(getId()));
	}

}