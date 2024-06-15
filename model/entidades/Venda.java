package model.entidades;

import java.util.Date;

public class Venda {

	private int vendaID;

	private Date data_hora;

	private double valor_total;

	private Cliente cliente;

	private Pagamento[] pagamento;

	/***********
	 * MÉTODOS *
	 ***********/

	/** GETTERS e SETTERS **/ 
	public int getVendaID(){
		return this.vendaID;
	}

	public Date getData(){
		return this.data_hora;
	}

	public double getTotal() {
		return this.valor_total;
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	/** FUNÇÕES **/
	public void adicionarItem(Produto prod, int quant) {

	}

	public void debitarPreco(double valorPago) {

	}

	public void autenticaCartao() {
		// Revisar...
	}

	/** CREATE **/
	public void Venda(Cliente cli, Date agora) {

	}

	public void Venda(Date agora) { // Sem CPF

	}

}
