package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoPublicacaoBC;
import com.nuovonet.mather.domain.TipoPublicacao;

@ViewController
@NextView("./tipoPublicacao_edit.jsf")
@PreviousView("./tipoPublicacao_list.jsf")
public class TipoPublicacaoListMB extends AbstractListPageBean<TipoPublicacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoPublicacaoBC tipoPublicacaoBC;
	
	@Override
	protected List<TipoPublicacao> handleResultList() {
		return this.tipoPublicacaoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tipoPublicacaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}