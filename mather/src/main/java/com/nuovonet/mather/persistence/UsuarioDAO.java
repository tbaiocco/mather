package com.nuovonet.mather.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	

}
