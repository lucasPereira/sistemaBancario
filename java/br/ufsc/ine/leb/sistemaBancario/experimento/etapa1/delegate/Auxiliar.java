package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.delegate;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {

	public static Banco criarCaixaEconomica() {
		SistemaBancario sistemaBancario = new SistemaBancario();
		return sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
	}

	public static Agencia criarTrindade(Banco banco) {
		return banco.criarAgencia("Trindade");
	}

}
