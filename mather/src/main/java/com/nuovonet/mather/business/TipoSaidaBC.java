package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.TipoSaida;
import com.nuovonet.mather.persistence.TipoSaidaDAO;

@BusinessController
public class TipoSaidaBC extends DelegateCrud<TipoSaida, Long, TipoSaidaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
