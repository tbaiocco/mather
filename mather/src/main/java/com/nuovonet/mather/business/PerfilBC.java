package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Perfil;
import com.nuovonet.mather.persistence.PerfilDAO;

@BusinessController
public class PerfilBC extends DelegateCrud<Perfil, Long, PerfilDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
