package com.nuovonet.mather.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.Empresa;

@PersistenceController
public class EmpresaDAO extends JPACrud<Empresa, Long> {

	private static final long serialVersionUID = 1L;
	

}
