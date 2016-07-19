package br.ufsc.ine.leb.sistemaBancario.experimento.etapa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteDinheiro {

	@Test
	public void zeroReais() throws Exception {
		Dinheiro zeroReais = new Dinheiro(Moeda.BRL, 0, 0);
		assertEquals("0,00", zeroReais.formatado());
		assertEquals(0, zeroReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, zeroReais.obterMoeda());
	}

	@Test
	public void dezReais() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertEquals("10,00 BRL", dezReais.formatado());
		assertEquals(1000, dezReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, dezReais.obterMoeda());
	}

	@Test
	public void seisReais() throws Exception {
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		assertEquals("6,00 BRL", seisReais.formatado());
		assertEquals(600, seisReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, seisReais.obterMoeda());
	}

	@Test
	public void quatroReais() throws Exception {
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		assertEquals("4,00 BRL", quatroReais.formatado());
		assertEquals(400, quatroReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, quatroReais.obterMoeda());
	}

}
