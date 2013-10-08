package com.nuovonet.mather.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.Menu;

@PersistenceController
public class MenusDAO extends JPACrud<Menu, Long> {

	private static final long serialVersionUID = 1L;
	

}
