package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeTransacao;
import br.ufsc.ine.leb.sistemaBancario.Transacao;

public class TesteBanco {

	@Test
	public void depositar() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta bancoDoBrasilLucas = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = bancoDoBrasil.depositar(bancoDoBrasilLucas, 10);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

	@Test
	public void depositarEmContaInvalida() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Banco caixaEconomicaFederal = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta bancoDoBrasilLucas = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = caixaEconomicaFederal.depositar(bancoDoBrasilLucas, 10);
		assertEquals(EstadosDeTransacao.CONTA_INVALIDA, transacao.obterEstado());
	}

	@Test
	public void sacarComSaldo() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta bancoDoBrasilLucas = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		bancoDoBrasil.depositar(bancoDoBrasilLucas, 10);
		Transacao transacao = bancoDoBrasil.sacar(bancoDoBrasilLucas, 5);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

	@Test
	public void sacarSemSaldo() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta bancoDoBrasilLucas = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		bancoDoBrasil.depositar(bancoDoBrasilLucas, 10);
		Transacao transacao = bancoDoBrasil.sacar(bancoDoBrasilLucas, 15);
		assertEquals(EstadosDeTransacao.SALDO_INSUFICIENTE, transacao.obterEstado());
	}

	@Test
	public void transferir() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta bancoDoBrasilLucas = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Conta bancoDoBrasilPatricia = bancoDoBrasil.criarConta("Patrícia", bancoDoBrasilTrindade);
		Transacao transacao = bancoDoBrasil.transferir(bancoDoBrasilPatricia, bancoDoBrasilLucas, 15);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

}
