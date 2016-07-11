package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteSistemaBancario {

	@Test
	public void depositar() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario positivoDezReais = dezReais.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Operacao operacao = sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void depositarMoedaInvalida() throws Exception {
		Dinheiro dezDolares = new Dinheiro(Moeda.USD, 10, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Operacao operacao = sistemaBancario.depositar(lucasBancoDoBrasil, dezDolares);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertTrue(lucasBancoDoBrasil.calcularSaldo().zero());
	}

	@Test
	public void sacar() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cincoReais = new Dinheiro(Moeda.BRL, 5, 0);
		ValorMonetario positivoCincoReais = cincoReais.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.sacar(lucasBancoDoBrasil, cincoReais);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(positivoCincoReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void sacarSemSaldo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Operacao operacao = sistemaBancario.sacar(lucasBancoDoBrasil, dezReais);
		assertEquals(EstadosDeOperacao.SALDO_INSUFICIENTE, operacao.obterEstado());
		assertTrue(lucasBancoDoBrasil.calcularSaldo().zero());
	}

	@Test
	public void sacarMoedaInvalida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro dezDolares = new Dinheiro(Moeda.USD, 10, 0);
		ValorMonetario positivoDezReais = dezReais.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.sacar(lucasBancoDoBrasil, dezDolares);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void transferir() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro quatroReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 4, 50);
		Dinheiro cincoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 5, 50);
		ValorMonetario positivoQuatroReaisCinquentaCentavos = quatroReaisCinquentaCentavos.positivo();
		ValorMonetario positivoCincoReaisCinquentaCentavos = cincoReaisCinquentaCentavos.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Patrícia");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasil, patriciaBancoDoBrasil, quatroReaisCinquentaCentavos);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(positivoCincoReaisCinquentaCentavos, lucasBancoDoBrasil.calcularSaldo());
		assertEquals(positivoQuatroReaisCinquentaCentavos, patriciaBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void transferirMoedaInvalidaOrigem() throws Exception {
		Dinheiro dezFrancosSuicos = new Dinheiro(Moeda.CHF, 10, 0);
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario positivoDezReais = dezReais.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Banco swissBank = sistemaBancario.criarBanco("Swiss Bank", Moeda.CHF);
		Agencia swissBankZurique = swissBank.criarAgencia("Zurique");
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta cunhaSwissBank = swissBankZurique.criarConta("Eduardo Cunha");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasil, cunhaSwissBank, dezFrancosSuicos);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
		assertTrue(cunhaSwissBank.calcularSaldo().zero());
	}

	@Test
	public void transferirMoedaInvalidaDestino() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario positivoDezReais = dezReais.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Banco swissBank = sistemaBancario.criarBanco("Swiss Bank", Moeda.CHF);
		Agencia swissBankZurique = swissBank.criarAgencia("Zurique");
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta cunhaSwissBank = swissBankZurique.criarConta("Eduardo Cunha");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasil, cunhaSwissBank, dezReais);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
		assertTrue(cunhaSwissBank.calcularSaldo().zero());
	}

}
