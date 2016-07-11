package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBanco {

	@Test
	public void bancoDoBrasil() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		assertEquals("Banco do Brasil", bancoDoBrasil.obterNome());
		assertEquals(Moeda.BRL, bancoDoBrasil.obterMoeda());
	}

	@Test
	public void caixaEconomica() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco caixaEconomica = sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
		assertEquals("Caixa Econômica", caixaEconomica.obterNome());
	}

	@Test
	public void swissBank() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco swissBank = sistemaBancario.criarBanco("Swiss Bank", Moeda.CHF);
		assertEquals(Moeda.CHF, swissBank.obterMoeda());
		assertEquals("Swiss Bank", swissBank.obterNome());
	}

}
