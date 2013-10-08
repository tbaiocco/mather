package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.ProgramaBC;
import com.nuovonet.mather.domain.Programa;

@ViewController
@PreviousView("./programa_list.jsf")
public class ProgramaEditMB extends AbstractEditPageBean<Programa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProgramaBC programaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.programaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.programaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.programaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.programaBC.load(getId()));
	}

}