package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoOcorrenciaBC;
import com.nuovonet.mather.domain.TipoOcorrencia;

@ViewController
@NextView("./tipoOcorrencia_edit.jsf")
@PreviousView("./tipoOcorrencia_list.jsf")
public class TipoOcorrenciaListMB extends AbstractListPageBean<TipoOcorrencia, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoOcorrenciaBC tipoOcorrenciaBC;
	
	@Override
	protected List<TipoOcorrencia> handleResultList() {
		return this.tipoOcorrenciaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tipoOcorrenciaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}