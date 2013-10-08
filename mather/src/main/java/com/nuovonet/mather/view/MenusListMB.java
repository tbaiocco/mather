package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.MenusBC;
import com.nuovonet.mather.domain.Menu;

@ViewController
@NextView("./menus_edit.jsf")
@PreviousView("./menus_list.jsf")
public class MenusListMB extends AbstractListPageBean<Menu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MenusBC menusBC;
	
	@Override
	protected List<Menu> handleResultList() {
		return this.menusBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				menusBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}