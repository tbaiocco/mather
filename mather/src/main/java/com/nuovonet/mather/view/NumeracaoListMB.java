package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.NumeracaoBC;
import com.nuovonet.mather.domain.Numeracao;

@ViewController
@NextView("./numeracao_edit.jsf")
@PreviousView("./numeracao_list.jsf")
public class NumeracaoListMB extends AbstractListPageBean<Numeracao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NumeracaoBC numeracaoBC;
	
	@Override
	protected List<Numeracao> handleResultList() {
		return this.numeracaoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				numeracaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}