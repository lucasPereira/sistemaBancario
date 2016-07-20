package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.delegate;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {

	public static Banco criarCaixaEconomica() {
		SistemaBancario sistema = new SistemaBancario();
		return sistema.criarBanco("Caixa Econômica", Moeda.BRL);
	}

	public static Agencia criarTrindade(Banco caixaEconomica) {
		return caixaEconomica.criarAgencia("Trindade");
	}

}
