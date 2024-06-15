package model.entidades;

public class Cliente extends Usuario {

	private String cpf;

	private Entrega[] entrega;

	/***********
	 * MÉTODOS *
	 ***********/

	public String getCPF() {
		return cpf;
	}

}
