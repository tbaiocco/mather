package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoChegadaBC;
import com.nuovonet.mather.domain.TipoChegada;

@ViewController
@NextView("./tipoChegada_edit.jsf")
@PreviousView("./tipoChegada_list.jsf")
public class TipoChegadaListMB extends AbstractListPageBean<TipoChegada, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoChegadaBC tipoChegadaBC;
	
	@Override
	protected List<TipoChegada> handleResultList() {
		return this.tipoChegadaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tipoChegadaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}