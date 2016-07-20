package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {
	
	public static Conta criarMariaComSaldo(SistemaBancario sistema, Agencia ag, Dinheiro saldo)
	{
		Conta maria = ag.criarConta("Maria");
		sistema.depositar(maria, saldo);
		return maria;
	}

}
