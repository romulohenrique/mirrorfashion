package br.com.caelum.mirrorfashion.controller;

import static br.com.caelum.vraptor.view.Results.jsonp;

import java.util.List;

import br.com.caelum.mirrorfashion.modelo.GeradorDeProdutos;
import br.com.caelum.mirrorfashion.modelo.Produto;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.serialization.JSONPSerialization;

@Resource
@RequestScoped
public class ProdutoController {

	@Get("/produtos")
	public void produtos(Result result, String callback) {

		GeradorDeProdutos geradorProdutos = new GeradorDeProdutos();

		List<Produto> produtos = geradorProdutos.geraProdutos();

		JSONPSerialization serialization = result.use(jsonp());

		if (!callback.matches("[a-z A-Z_0-9 ._]*")) {
			callback = "";
		}

		serialization.withCallback(callback).from(produtos, "produtos")
				.serialize();

	}

}