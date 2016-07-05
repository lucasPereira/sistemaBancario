package br.ufsc.ine.leb.sistemaBancario;

public class Agencia {

	private String nome;
	private Integer codigo;

	public Agencia(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String obterIdentificador() {
		return String.format("%03d", codigo);
	}

	public String obterNome() {
		return nome;
	}

}
