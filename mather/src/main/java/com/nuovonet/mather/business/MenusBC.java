package com.nuovonet.mather.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.nuovonet.mather.domain.Menu;
import com.nuovonet.mather.persistence.MenusDAO;

@BusinessController
public class MenusBC extends DelegateCrud<Menu, Long, MenusDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
