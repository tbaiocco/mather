package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.PessoaBC;
import com.nuovonet.mather.domain.Pessoa;

@ViewController
@PreviousView("./pessoa_list.jsf")
public class PessoaEditMB extends AbstractEditPageBean<Pessoa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaBC pessoaBC;
	
	@Override
	@Transactional
	public String delete() {
		this.pessoaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.pessoaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.pessoaBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.pessoaBC.load(getId()));
	}

}