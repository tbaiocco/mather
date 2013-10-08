package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.ProgramaBC;
import com.nuovonet.mather.domain.Programa;

@ViewController
@NextView("./programa_edit.jsf")
@PreviousView("./programa_list.jsf")
public class ProgramaListMB extends AbstractListPageBean<Programa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProgramaBC programaBC;
	
	@Override
	protected List<Programa> handleResultList() {
		return this.programaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				programaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}