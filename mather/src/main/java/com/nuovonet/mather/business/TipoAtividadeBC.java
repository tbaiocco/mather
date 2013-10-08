package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.TipoAtividade;
import com.nuovonet.mather.persistence.TipoAtividadeDAO;

@BusinessController
public class TipoAtividadeBC extends DelegateCrud<TipoAtividade, Long, TipoAtividadeDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
