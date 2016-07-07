package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeTransacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Transacao;

public class TesteBanco {

	@Test
	public void depositar() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = bancoDoBrasil.depositar(lucasBancoDoBrasil, dezReais);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
		assertEquals(dezReais, lucasBancoDoBrasil.obterSaldo());
	}

	@Test
	public void depositarEmContaInvalida() throws Exception {
		Dinheiro zero = new Dinheiro(Moeda.BRL, 0, 0);
		Banco bancoDoBrasil = new Banco();
		Banco caixaEconomicaFederal = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = caixaEconomicaFederal.depositar(lucasBancoDoBrasil, zero);
		assertEquals(EstadosDeTransacao.CONTA_INVALIDA, transacao.obterEstado());
		assertEquals(zero, lucasBancoDoBrasil.obterSaldo());
	}

	@Test
	public void sacarComSaldo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		bancoDoBrasil.depositar(lucasBancoDoBrasil, dezReais);
		Transacao transacao = bancoDoBrasil.sacar(lucasBancoDoBrasil, 5);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

	@Test
	public void sacarSemSaldo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		bancoDoBrasil.depositar(lucasBancoDoBrasil, dezReais);
		Transacao transacao = bancoDoBrasil.sacar(lucasBancoDoBrasil, 15);
		assertEquals(EstadosDeTransacao.CONTA_INVALIDA, transacao.obterEstado());
	}

	@Test
	public void sacarDeContaInvalida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Banco bancoDoBrasil = new Banco();
		Banco caixaEconomicaFederal = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		bancoDoBrasil.depositar(lucasBancoDoBrasil, dezReais);
		Transacao transacao = caixaEconomicaFederal.sacar(lucasBancoDoBrasil, 5);
		assertEquals(EstadosDeTransacao.CONTA_INVALIDA, transacao.obterEstado());
	}

	@Test
	public void transferir() throws Exception {
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Conta patriciaBancoDoBrasil = bancoDoBrasil.criarConta("Patrícia", bancoDoBrasilTrindade);
		Transacao transacao = bancoDoBrasil.transferir(patriciaBancoDoBrasil, lucasBancoDoBrasil, 15);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

}
