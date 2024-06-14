package model.entidades;

public class Funcionario extends Usuario {

	private int id;

	private double salario;

	private boolean admin;

	private Produto[] produto;

	private Venda venda;

	private void setSalario(double salarioNovo) {
		if (this.admin == true){
			this.salario = salarioNovo; //REVISAR LÓGICA
		}
	}

	public double getSalario(){
		return salario;
	}

	public String getName(){
		return this.nome;
	}

}
