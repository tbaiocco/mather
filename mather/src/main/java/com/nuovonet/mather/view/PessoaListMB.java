package com.nuovonet.mather.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.nuovonet.mather.business.PessoaBC;
import com.nuovonet.mather.domain.Pessoa;

@ViewController
@NextView("./pessoa_edit.jsf")
@PreviousView("./pessoa_list.jsf")
public class PessoaListMB extends AbstractListPageBean<Pessoa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaBC pessoaBC;
	
	@Override
	protected List<Pessoa> handleResultList() {
		return this.pessoaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				pessoaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}