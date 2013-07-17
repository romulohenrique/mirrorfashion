package br.com.caelum.mirrorfashion.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.jsonp;

import java.util.List;

import br.com.caelum.mirrorfashion.modelo.GeradorDeProdutos;
import br.com.caelum.mirrorfashion.modelo.Produto;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.serialization.JSONPSerialization;
import br.com.caelum.vraptor.serialization.JSONSerialization;

@Resource
@RequestScoped
public class ProdutoController {

	@Get("/produtos")
	public void produtos(Result result, String callback) {

		GeradorDeProdutos geradorProdutos = new GeradorDeProdutos();

		List<Produto> produtos = geradorProdutos.geraProdutos();

		JSONPSerialization serialization = result.use(jsonp());

		JSONSerialization jsonSerialization = result.use(json());

		if (callback == null) {
			jsonSerialization.from(
					"Você precisa passar o parâmetro ?callback=nomeDaSuaFuncao",
					"erro").serialize();
		}

		if (!callback.matches("[a-z A-Z_0-9 ._]*")) {
			callback = "";
		}

		serialization.withCallback(callback).from(produtos, "produtos")
				.serialize();

	}

}