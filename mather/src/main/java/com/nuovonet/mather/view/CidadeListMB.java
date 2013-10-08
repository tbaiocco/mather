package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.CidadeBC;
import com.nuovonet.mather.domain.Cidade;

@ViewController
@NextView("./cidade_edit.jsf")
@PreviousView("./cidade_list.jsf")
public class CidadeListMB extends AbstractListPageBean<Cidade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeBC cidadeBC;
	
	@Override
	protected List<Cidade> handleResultList() {
		return this.cidadeBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				cidadeBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}