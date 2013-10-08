package com.nuovonet.mather.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.Escola;

@PersistenceController
public class EscolaDAO extends JPACrud<Escola, Long> {

	private static final long serialVersionUID = 1L;
	

}
