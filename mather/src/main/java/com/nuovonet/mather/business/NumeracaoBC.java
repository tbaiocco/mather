package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Numeracao;
import com.nuovonet.mather.persistence.NumeracaoDAO;

@BusinessController
public class NumeracaoBC extends DelegateCrud<Numeracao, Long, NumeracaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
