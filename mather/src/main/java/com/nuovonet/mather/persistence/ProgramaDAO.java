package com.nuovonet.mather.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.Programa;

@PersistenceController
public class ProgramaDAO extends JPACrud<Programa, Long> {

	private static final long serialVersionUID = 1L;
	

}
