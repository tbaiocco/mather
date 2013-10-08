package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Escola;
import com.nuovonet.mather.persistence.EscolaDAO;

@BusinessController
public class EscolaBC extends DelegateCrud<Escola, Long, EscolaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
