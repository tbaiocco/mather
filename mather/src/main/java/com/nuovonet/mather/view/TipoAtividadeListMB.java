package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoAtividadeBC;
import com.nuovonet.mather.domain.TipoAtividade;

@ViewController
@NextView("./tipoAtividade_edit.jsf")
@PreviousView("./tipoAtividade_list.jsf")
public class TipoAtividadeListMB extends AbstractListPageBean<TipoAtividade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtividadeBC tipoAtividadeBC;
	
	@Override
	protected List<TipoAtividade> handleResultList() {
		return this.tipoAtividadeBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tipoAtividadeBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}