package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteConta {

	@Test
	public void lucasBancoDoBrasil() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		assertEquals("0001-5", lucasBancoDoBrasil.obterIdentificador());
		assertEquals("Lucas", lucasBancoDoBrasil.obterTitular());
		assertTrue(lucasBancoDoBrasil.calcularSaldo().zero());
		assertEquals(bancoDoBrasilTrindade, lucasBancoDoBrasil.obterAgencia());
	}

	@Test
	public void patriciaBancoDoBrasil() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Patrícia");
		assertEquals("0002-8", patriciaBancoDoBrasil.obterIdentificador());
		assertEquals("Patrícia", patriciaBancoDoBrasil.obterTitular());
		assertTrue(patriciaBancoDoBrasil.calcularSaldo().zero());
		assertEquals(bancoDoBrasilTrindade, patriciaBancoDoBrasil.obterAgencia());
	}

	@Test
	public void patriciaCaixaEconomica() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco caixaEconomica = sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
		Agencia caixaEconomicaTrindade = caixaEconomica.criarAgencia("Trindade");
		Conta patriciaCaixaEconomica = caixaEconomicaTrindade.criarConta("Patrícia");
		assertEquals("0001-8", patriciaCaixaEconomica.obterIdentificador());
		assertEquals("Patrícia", patriciaCaixaEconomica.obterTitular());
		assertTrue(patriciaCaixaEconomica.calcularSaldo().zero());
		assertEquals(caixaEconomicaTrindade, patriciaCaixaEconomica.obterAgencia());
	}

	@Test
	public void eduardoCunhaSwissBank() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco swissBank = sistemaBancario.criarBanco("Swiss Bank", Moeda.CHF);
		Agencia swissBankZurique = swissBank.criarAgencia("Zurique");
		Conta cunhaSwissBank = swissBankZurique.criarConta("Eduardo Cunha");
		assertEquals("0001-3", cunhaSwissBank.obterIdentificador());
		assertEquals("Eduardo Cunha", cunhaSwissBank.obterTitular());
		assertTrue(cunhaSwissBank.calcularSaldo().zero());
		assertEquals(swissBankZurique, cunhaSwissBank.obterAgencia());
	}

}
