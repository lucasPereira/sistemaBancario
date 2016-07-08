package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeTransacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.Transacao;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteSistemaBancario {

	@Test
	public void depositar() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario positivoDezReais = new ValorMonetario(Moeda.BRL).somar(dezReais);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Transacao transacao = sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void sacarComSaldo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Transacao transacao = sistemaBancario.sacar(lucasBancoDoBrasil, 5);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

	@Test
	public void sacarSemSaldo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Transacao transacao = sistemaBancario.sacar(lucasBancoDoBrasil, 15);
		assertEquals(EstadosDeTransacao.MOEDA_INVALIDA, transacao.obterEstado());
	}

	@Test
	public void transferir() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Patrícia");
		Transacao transacao = sistemaBancario.transferir(patriciaBancoDoBrasil, lucasBancoDoBrasil, 15);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
	}

}
