package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.TipoServico;
import com.nuovonet.mather.persistence.TipoServicoDAO;

@BusinessController
public class TipoServicoBC extends DelegateCrud<TipoServico, Long, TipoServicoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
