package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.TipoPublicacao;
import com.nuovonet.mather.persistence.TipoPublicacaoDAO;

@BusinessController
public class TipoPublicacaoBC extends DelegateCrud<TipoPublicacao, Long, TipoPublicacaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
