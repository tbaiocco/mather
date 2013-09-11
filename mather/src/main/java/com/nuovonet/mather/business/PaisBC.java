package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Pais;
import com.nuovonet.mather.persistence.PaisDAO;

@BusinessController
public class PaisBC extends DelegateCrud<Pais, Long, PaisDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
