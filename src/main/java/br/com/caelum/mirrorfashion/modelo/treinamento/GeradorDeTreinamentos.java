package br.com.caelum.mirrorfashion.modelo.treinamento;

import java.util.ArrayList;
import java.util.List;

public class GeradorDeTreinamentos {
	
	public List<Treinamento> geraTreinamentos() {

		Treinamento treinamento1 = new Treinamento("Vraptor: web fácil e rápida");

		Treinamento treinamento2 = new Treinamento("Git: trabalhe em equipe com controle e segurança");

		Treinamento treinamento3 = new Treinamento("Primeiros passos com Java");

		List<Treinamento> treinamentos = new ArrayList<Treinamento>();

		treinamentos.add(treinamento1);
		treinamentos.add(treinamento2);
		treinamentos.add(treinamento3);

		return treinamentos;
	}

}
