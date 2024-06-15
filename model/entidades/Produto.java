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

	/** GETTERS e SETTERS **/
	public int getCod(){
		return this.codProduto;
	}

	public String getNome() {
		return this.nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public String getDesc(){
		return this.descricao;
	}

	public int getEstoque(){
		return this.estoque;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	/** FUNÇÕES **/
	public void decrementaEstoque(int quant) {
		if (quant > this.estoque){
			// Possível exceção aqui
		}
		this.estoque = this.estoque - quant;
	}

}
