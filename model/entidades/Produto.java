package model.entidades;

public class Produto {

	private int codProduto;

	private String nome;

	private double preco;

	private String descricao;

	private int estoque;

	private Categoria categoria;

	/***********
	 * MÉTODOS *
	 ***********/

	public int getCod(){
		return this.codProduto;
	}

	public double getPreco() {
		return this.preco;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDesc(){
		return this.descricao;
	}

	public void decrementaEstoque(int quant) {
		if (quant > this.estoque){
			// Possível exceção aqui
		}
		this.estoque = this.estoque - quant;
	}

}
