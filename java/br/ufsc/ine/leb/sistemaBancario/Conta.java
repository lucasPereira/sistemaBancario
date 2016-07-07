package br.ufsc.ine.leb.sistemaBancario;

public class Conta {

	private String titular;
	private Integer codigo;

	public Conta(String titular, Integer codigo, Agencia agencia) {
		this.titular = titular;
		this.codigo = codigo;
	}

	public String obterIdentificador() {
		return String.format("%04d-%d", codigo, titular.length() % 10);
	}

	public String obterTitular() {
		return titular;
	}

	public Dinheiro obterSaldo() {
		return new Dinheiro(Moeda.BRL, 0, 0);
	}

}
