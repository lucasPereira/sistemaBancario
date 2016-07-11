package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

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
		ValorMonetario positivoDezReais = new ValorMonetario(Moeda.BRL).somar(dezReais);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Operacao operacao = sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void depositarMoedaInvalida() throws Exception {
		Dinheiro dezDolares = new Dinheiro(Moeda.USD, 10, 0);
		ValorMonetario positivoZeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Operacao operacao = sistemaBancario.depositar(lucasBancoDoBrasil, dezDolares);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoZeroReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void sacar() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cincoReais = new Dinheiro(Moeda.BRL, 5, 0);
		ValorMonetario positivoCincoReais = new ValorMonetario(Moeda.BRL).somar(cincoReais);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
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
		ValorMonetario positivoZeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Operacao operacao = sistemaBancario.sacar(lucasBancoDoBrasil, dezReais);
		assertEquals(EstadosDeOperacao.SALDO_INSUFICIENTE, operacao.obterEstado());
		assertEquals(positivoZeroReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void sacarMoedaInvalida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro dezDolares = new Dinheiro(Moeda.USD, 10, 0);
		ValorMonetario positivoZeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.sacar(lucasBancoDoBrasil, dezDolares);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoZeroReais, lucasBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void transferir() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cincoReais = new Dinheiro(Moeda.BRL, 5, 0);
		ValorMonetario positivoCincoReais = new ValorMonetario(Moeda.BRL).somar(cincoReais);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Patrícia");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasil, patriciaBancoDoBrasil, cincoReais);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(positivoCincoReais, lucasBancoDoBrasil.calcularSaldo());
		assertEquals(positivoCincoReais, patriciaBancoDoBrasil.calcularSaldo());
	}

	@Test
	public void transferirMoedaInvalidaOrigem() throws Exception {
		Dinheiro dezDolares = new Dinheiro(Moeda.USD, 10, 0);
		Dinheiro cincoReais = new Dinheiro(Moeda.BRL, 5, 0);
		ValorMonetario positivoZeroReais = new ValorMonetario(Moeda.BRL);
		ValorMonetario positivoDezDolares = new ValorMonetario(Moeda.USD).somar(dezDolares);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.USD);
		Banco caixaEconomicaFederal = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Agencia caixaEconomicaFederalTrindade = caixaEconomicaFederal.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaCaixaEconomicaFederal = caixaEconomicaFederalTrindade.criarConta("Patrícia");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezDolares);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasil, patriciaCaixaEconomicaFederal, cincoReais);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoDezDolares, lucasBancoDoBrasil.calcularSaldo());
		assertEquals(positivoZeroReais, patriciaCaixaEconomicaFederal.calcularSaldo());
	}

	@Test
	public void transferirMoedaInvalidaDestino() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cincoReais = new Dinheiro(Moeda.BRL, 5, 0);
		ValorMonetario positivoZeroDolares = new ValorMonetario(Moeda.USD);
		ValorMonetario positivoDezReais = new ValorMonetario(Moeda.BRL).somar(dezReais);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Banco caixaEconomicaFederal = sistemaBancario.criarBanco(Moeda.USD);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Agencia caixaEconomicaFederalTrindade = caixaEconomicaFederal.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaCaixaEconomicaFederal = caixaEconomicaFederalTrindade.criarConta("Patrícia");
		sistemaBancario.depositar(lucasBancoDoBrasil, dezReais);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasil, patriciaCaixaEconomicaFederal, cincoReais);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
		assertEquals(positivoDezReais, lucasBancoDoBrasil.calcularSaldo());
		assertEquals(positivoZeroDolares, patriciaCaixaEconomicaFederal.calcularSaldo());
	}
	
}
