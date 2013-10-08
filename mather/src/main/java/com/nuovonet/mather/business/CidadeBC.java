package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Cidade;
import com.nuovonet.mather.persistence.CidadeDAO;

@BusinessController
public class CidadeBC extends DelegateCrud<Cidade, Long, CidadeDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
