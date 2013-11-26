package br.com.caelum.mirrorfashion.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.jsonp;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mirrorfashion.modelo.produto.GeradorDeProdutos;
import br.com.caelum.mirrorfashion.modelo.produto.Produto;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.serialization.JSONPSerialization;
import br.com.caelum.vraptor.serialization.JSONSerialization;

@Resource
@RequestScoped
public class ProdutoController {

	private Result result;
	private List<Produto> produtos;
	private JSONSerialization jsonSerialization;

	public ProdutoController(Result result) {
		this.result = result;
		this.produtos = new GeradorDeProdutos().geraProdutos();
		this.jsonSerialization = result.use(json());
	}

	@Get("/produtos")
	public void produtos(String callback) {

		JSONPSerialization jsonpSerialization = this.result.use(jsonp());

		if (callback == null) {
			this.jsonSerialization
					.from("Você precisa passar o parâmetro ?callback=nomeDaSuaFuncao",
							"erro").serialize();
		}

		if (!callback.matches("[a-z A-Z_0-9 ._]*")) {
			callback = "";
		}

		jsonpSerialization.withCallback(callback)
				.from(this.produtos, "produtos").serialize();

	}

	@Get("/public/produtos")
	public void produtosHeader(HttpServletResponse response) {

		response.addHeader("Access-Control-Allow-Origin", "*");

		this.jsonSerialization.from(this.produtos, "produtos").serialize();

	}

}