package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.TipoServicoBC;
import com.nuovonet.mather.domain.TipoServico;

@ViewController
@NextView("./tipoServico_edit.jsf")
@PreviousView("./tipoServico_list.jsf")
public class TipoServicoListMB extends AbstractListPageBean<TipoServico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoServicoBC tipoServicoBC;
	
	@Override
	protected List<TipoServico> handleResultList() {
		return this.tipoServicoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tipoServicoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}