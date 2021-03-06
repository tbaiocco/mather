package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.PerfilBC;
import com.nuovonet.mather.domain.Perfil;

@ViewController
@NextView("./perfil_edit.jsf")
@PreviousView("./perfil_list.jsf")
public class PerfilListMB extends AbstractListPageBean<Perfil, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilBC perfilBC;
	
	@Override
	protected List<Perfil> handleResultList() {
		return this.perfilBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				perfilBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}