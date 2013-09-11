package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.PerfilBC;
import com.nuovonet.mather.domain.Perfil;

@ViewController
@PreviousView("./perfil_list.jsf")
public class PerfilEditMB extends AbstractEditPageBean<Perfil, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilBC perfilBC;
	
	@Override
	@Transactional
	public String delete() {
		this.perfilBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.perfilBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.perfilBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.perfilBC.load(getId()));
	}

}