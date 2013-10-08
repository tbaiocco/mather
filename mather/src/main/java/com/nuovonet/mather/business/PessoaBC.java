package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Pessoa;
import com.nuovonet.mather.persistence.PessoaDAO;

@BusinessController
public class PessoaBC extends DelegateCrud<Pessoa, Long, PessoaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
