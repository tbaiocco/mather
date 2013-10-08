package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoOcorrenciaBC;
import com.nuovonet.mather.domain.TipoOcorrencia;

@ViewController
@PreviousView("./tipoOcorrencia_list.jsf")
public class TipoOcorrenciaEditMB extends AbstractEditPageBean<TipoOcorrencia, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoOcorrenciaBC tipoOcorrenciaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tipoOcorrenciaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoOcorrenciaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoOcorrenciaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tipoOcorrenciaBC.load(getId()));
	}

}