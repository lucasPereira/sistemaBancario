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
		assertEquals("Caixa Econômica", caixaEconomica.obterNome());
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
	}

	@Test
	public void swissBank() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco swissBank = sistemaBancario.criarBanco("Swiss Bank", Moeda.CHF);
		assertEquals("Swiss Bank", swissBank.obterNome());
		assertEquals(Moeda.CHF, swissBank.obterMoeda());
	}

}
