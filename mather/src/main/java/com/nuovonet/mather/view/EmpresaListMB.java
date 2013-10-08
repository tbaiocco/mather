package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.EmpresaBC;
import com.nuovonet.mather.domain.Empresa;

@ViewController
@NextView("./empresa_edit.jsf")
@PreviousView("./empresa_list.jsf")
public class EmpresaListMB extends AbstractListPageBean<Empresa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaBC empresaBC;
	
	@Override
	protected List<Empresa> handleResultList() {
		return this.empresaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				empresaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}