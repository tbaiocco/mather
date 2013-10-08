package com.nuovonet.mather.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.Cidade;

@PersistenceController
public class CidadeDAO extends JPACrud<Cidade, Long> {

	private static final long serialVersionUID = 1L;
	

}
