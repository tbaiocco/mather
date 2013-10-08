package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Programa;
import com.nuovonet.mather.persistence.ProgramaDAO;

@BusinessController
public class ProgramaBC extends DelegateCrud<Programa, Long, ProgramaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
