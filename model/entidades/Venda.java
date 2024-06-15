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

	public void adicionarItem(Produto prod, int quant) {

	}

	public void debitarPreco(double valorPago) {

	}

	public void autenticaCartao() {

	}

	public double getTotal() {
		return valor_total;
	}

	public void Venda(Cliente cli, Date agora) {

	}

	public void Venda(Date agora) {

	}

}
