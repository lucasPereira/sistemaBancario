package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.delegate;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {

	public static Banco criarCaixaEconomica() {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco caixaEconomica = sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
		return caixaEconomica;
	}

	public static Agencia criarTrindade(Banco banco) {
		Agencia trindade = banco.criarAgencia("Trindade");
		return trindade;
	}

	public static Conta cirarJoao(Agencia agencia) {
		return agencia.criarConta("João");
	}

}
