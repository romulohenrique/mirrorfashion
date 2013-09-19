package br.com.caelum.mirrorfashion.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.jsonp;

import java.util.List;

import br.com.caelum.mirrorfashion.modelo.treinamento.GeradorDeTreinamentos;
import br.com.caelum.mirrorfashion.modelo.treinamento.Treinamento;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.serialization.JSONPSerialization;
import br.com.caelum.vraptor.serialization.JSONSerialization;


@Resource
@RequestScoped
public class TreinamentoController {
	
	@Get("/treinamentos")
	public void produtos(Result result, String callback) {

		GeradorDeTreinamentos geradorTreinamentos = new GeradorDeTreinamentos();

		List<Treinamento> treinamentos = geradorTreinamentos.geraTreinamentos();

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

		serialization.withCallback(callback).from(treinamentos, "treinamentos")
				.serialize();

	}

}
