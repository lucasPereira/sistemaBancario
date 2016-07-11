package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteMoeda {

	@Test
	public void testar() throws Exception {
		List<Moeda> moedas = Arrays.asList(Moeda.values());
		assertEquals(Moeda.BRL, moedas.get(0));
		assertEquals(Moeda.USD, moedas.get(1));
		assertEquals(Moeda.CHF, moedas.get(2));
		assertEquals(3, moedas.size());
	}

	@Test
	public void brl() throws Exception {
		assertEquals("R$", Moeda.BRL.obterSimbolo());
		assertEquals(100, Moeda.BRL.obterBaseFracionaria().intValue());
	}

	@Test
	public void chf() throws Exception {
		assertEquals("Fr", Moeda.CHF.obterSimbolo());
		assertEquals(100, Moeda.CHF.obterBaseFracionaria().intValue());
	}

	@Test
	public void usd() throws Exception {
		assertEquals("$", Moeda.USD.obterSimbolo());
		assertEquals(100, Moeda.USD.obterBaseFracionaria().intValue());
	}

}
