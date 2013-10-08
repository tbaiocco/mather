package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.TipoOcorrencia;
import com.nuovonet.mather.persistence.TipoOcorrenciaDAO;

@BusinessController
public class TipoOcorrenciaBC extends DelegateCrud<TipoOcorrencia, Long, TipoOcorrenciaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
