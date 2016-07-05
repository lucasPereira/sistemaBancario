package br.ufsc.ine.leb.sistemaBancario;

public enum Moeda {

	BRL("R$"), USD("$");

	private String simbolo;

	private Moeda(String simbolo) {
		this.simbolo = simbolo;
	}

	public String obterSimbolo() {
		return simbolo;
	}

}
