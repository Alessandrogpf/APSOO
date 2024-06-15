package model.entidades;

public class ItemDeVenda {

	private double preco_venda_item;

	private int quantidade_vendida;

	private Produto produto;

	/***********
	 * MÉTODOS *
	 ***********/

	/** GETTERS e SETTERS **/

	public double getPrecoItem(){
		return this.preco_venda_item;
	}

	public int getQuantVendida(){
		return this.quantidade_vendida;
	}

	public Produto getProdutoVenda(){
		return this.produto;
	}

	/** CREATE **/
	public void ItemDeVenda(Produto prod, int quant) {

	}

	/** FUNÇÕES **/
	public void calculaValor(Produto prod) {

	}

}
