package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.EmpresaBC;
import com.nuovonet.mather.domain.Empresa;

@ViewController
@PreviousView("./empresa_list.jsf")
public class EmpresaEditMB extends AbstractEditPageBean<Empresa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaBC empresaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.empresaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.empresaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.empresaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.empresaBC.load(getId()));
	}

}