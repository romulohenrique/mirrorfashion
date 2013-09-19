package br.com.caelum.mirrorfashion.modelo.produto;

public class Produto {

	private final String nome;
	private final double preco;
	private final String descricao;
	private final String imagem;

	public Produto(String nome, double preco, String descricao, String imagem) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getImagem() {
		return imagem;
	}
}
