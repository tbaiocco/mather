package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Unidade;
import com.nuovonet.mather.persistence.UnidadeDAO;

@BusinessController
public class UnidadeBC extends DelegateCrud<Unidade, Long, UnidadeDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
