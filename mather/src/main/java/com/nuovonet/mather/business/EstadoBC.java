package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Estado;
import com.nuovonet.mather.persistence.EstadoDAO;

@BusinessController
public class EstadoBC extends DelegateCrud<Estado, Long, EstadoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
