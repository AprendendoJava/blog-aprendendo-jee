package org.jugvale.config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.jugvale.model.Produto;
import org.jugvale.service.ProdutoService;

@Startup
@Singleton
public class AppStartup {
	
	@Inject
	ProdutoService service;
	
	@PostConstruct
	public void addDadosTeste() {
		service.salvar(new Produto("Pão", 0.90f, 100));
		service.salvar(new Produto("Arroz", 5, 2));
		service.salvar(new Produto("Farofa", 3, 10));
		service.salvar(new Produto("Colírio", 15, 2));
		service.salvar(new Produto("Copo", 10, 1));
	}

}
