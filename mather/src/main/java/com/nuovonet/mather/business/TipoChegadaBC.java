package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.TipoChegada;
import com.nuovonet.mather.persistence.TipoChegadaDAO;

@BusinessController
public class TipoChegadaBC extends DelegateCrud<TipoChegada, Long, TipoChegadaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
