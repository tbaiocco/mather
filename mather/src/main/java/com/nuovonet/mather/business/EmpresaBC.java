package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Empresa;
import com.nuovonet.mather.persistence.EmpresaDAO;

@BusinessController
public class EmpresaBC extends DelegateCrud<Empresa, Long, EmpresaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
