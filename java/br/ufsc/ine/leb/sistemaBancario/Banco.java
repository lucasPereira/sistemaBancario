package br.ufsc.ine.leb.sistemaBancario;

import java.util.LinkedList;
import java.util.List;

public class Banco {

	private Moeda moeda;
	private List<Agencia> agencias;

	protected Banco(Moeda moeda) {
		this.moeda = moeda;
		this.agencias = new LinkedList<>();
	}

	public Agencia criarAgencia(String nome) {
		Agencia agencia = new Agencia(nome, agencias.size() + 1, this);
		agencias.add(agencia);
		return agencia;
	}

	public Boolean aceitaMoeda(Moeda outraMoeda) {
		return moeda.equals(outraMoeda);
	}

	public ValorMonetario construirValorMonetario() {
		return new ValorMonetario(moeda);
	}

}
