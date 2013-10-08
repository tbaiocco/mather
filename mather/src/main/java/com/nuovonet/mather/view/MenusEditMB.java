package com.nuovonet.mather.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.MenusBC;
import com.nuovonet.mather.domain.Menu;

@ViewController
@PreviousView("./menus_list.jsf")
public class MenusEditMB extends AbstractEditPageBean<Menu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MenusBC menusBC;
	
	@Override
	@Transactional
	public String delete() {
		this.menusBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.menusBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.menusBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.menusBC.load(getId()));
	}

}