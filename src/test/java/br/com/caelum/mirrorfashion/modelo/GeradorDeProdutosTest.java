package br.com.caelum.mirrorfashion.modelo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.mirrorfashion.modelo.produto.GeradorDeProdutos;
import br.com.caelum.mirrorfashion.modelo.produto.Produto;

public class GeradorDeProdutosTest {

	@Test
	public void deveSempreGerarTresProdutos() {

		GeradorDeProdutos geradorProdutos = new GeradorDeProdutos();

		List<Produto> produtos = geradorProdutos.geraProdutos();
		
		assertEquals(3, produtos.size());
	}
}
