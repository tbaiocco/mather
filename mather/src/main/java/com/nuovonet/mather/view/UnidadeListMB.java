package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.UnidadeBC;
import com.nuovonet.mather.domain.Unidade;

@ViewController
@NextView("./unidade_edit.jsf")
@PreviousView("./unidade_list.jsf")
public class UnidadeListMB extends AbstractListPageBean<Unidade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeBC unidadeBC;
	
	@Override
	protected List<Unidade> handleResultList() {
		return this.unidadeBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				unidadeBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}