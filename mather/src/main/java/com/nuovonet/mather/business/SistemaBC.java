package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Sistema;
import com.nuovonet.mather.persistence.SistemaDAO;

@BusinessController
public class SistemaBC extends DelegateCrud<Sistema, Long, SistemaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
