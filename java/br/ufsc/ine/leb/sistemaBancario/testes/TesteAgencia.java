package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteAgencia {

	@Test
	public void bancoDoBrasilTrindade() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		assertEquals("001", bancoDoBrasilTrindade.obterIdentificador());
		assertEquals("Trindade", bancoDoBrasilTrindade.obterNome());
		assertEquals(bancoDoBrasil, bancoDoBrasilTrindade.obterBanco());
	}

	@Test
	public void bancoDoBrasilCentro() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		bancoDoBrasil.criarAgencia("Trindade");
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		assertEquals("002", bancoDoBrasilCentro.obterIdentificador());
		assertEquals("Centro", bancoDoBrasilCentro.obterNome());
		assertEquals(bancoDoBrasil, bancoDoBrasilCentro.obterBanco());
	}

	@Test
	public void caixaEconomicaTrindade() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Banco caixaEconomica = sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
		bancoDoBrasil.criarAgencia("Trindade");
		Agencia caixaEconomicaTrindade = caixaEconomica.criarAgencia("Trindade");
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

	@Test
	public void swissBankZurique() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco swissBank = sistemaBancario.criarBanco("Swiss Bank", Moeda.CHF);
		Agencia swissBankZurique = swissBank.criarAgencia("Zurique");
		assertEquals("001", swissBankZurique.obterIdentificador());
		assertEquals("Zurique", swissBankZurique.obterNome());
		assertEquals(swissBank, swissBankZurique.obterBanco());
	}

}
