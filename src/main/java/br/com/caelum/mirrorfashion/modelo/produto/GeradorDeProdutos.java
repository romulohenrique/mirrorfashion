package br.com.caelum.mirrorfashion.modelo.produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeradorDeProdutos {

	public List<Produto> geraProdutos() {

		Produto produto1 = new Produto("Messy Rocket", 200.0,
				"Não é necessária nenhuma explicação. É demais!",
				"img/produto-4.jpg");

		Produto produto2 = new Produto("Urban Mistery", 130.0,
				"Descubra você também este mistério.", "img/produto-5.jpg");

		Produto produto3 = new Produto("Golden Valve", 109.0,
				"Feito com o mais finos dos materiais especialmente para você",
				"img/produto-6.jpg");

		List<Produto> produtos = new ArrayList<Produto>();

		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);

		Collections.shuffle(produtos);

		return produtos;
	}

}