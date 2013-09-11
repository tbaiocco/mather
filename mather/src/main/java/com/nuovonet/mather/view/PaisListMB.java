package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.PaisBC;
import com.nuovonet.mather.domain.Pais;

@ViewController
@NextView("./pais_edit.jsf")
@PreviousView("./pais_list.jsf")
public class PaisListMB extends AbstractListPageBean<Pais, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PaisBC paisBC;
	
	@Override
	protected List<Pais> handleResultList() {
		return this.paisBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				paisBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}