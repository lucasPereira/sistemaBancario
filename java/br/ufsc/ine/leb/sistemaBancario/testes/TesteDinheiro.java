package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteDinheiro {

	@Test
	public void reaisInteiroZeroFracionadoZero() throws Exception {
		Dinheiro zeroReais = new Dinheiro(Moeda.BRL, 0, 0);
		assertEquals("0,00", zeroReais.formatado());
		assertEquals(0, zeroReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, zeroReais.obterMoeda());
	}

	@Test
	public void reaisInteiroDezFracionadoZero() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertEquals("10,00 BRL", dezReais.formatado());
		assertEquals(1000, dezReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, dezReais.obterMoeda());
	}

	@Test
	public void francosSuicosInteiroDezFracionadoCem() throws Exception {
		Dinheiro dezFrancosSuicos = new Dinheiro(Moeda.CHF, 10, 0);
		assertEquals("10,00 CHF", dezFrancosSuicos.formatado());
		assertEquals(1000, dezFrancosSuicos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.CHF, dezFrancosSuicos.obterMoeda());
	}


	@Test
	public void reaisInteiroQuatroFracionadoCinquenta() throws Exception {
		Dinheiro quatroReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 4, 50);
		assertEquals("4,50 BRL", quatroReaisCinquentaCentavos.formatado());
		assertEquals(450, quatroReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, quatroReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void reaisInteiroZeroFracionadoCinquenta() throws Exception {
		Dinheiro cincquentaCentavos = new Dinheiro(Moeda.BRL, 0, 50);
		assertEquals("0,50 BRL", cincquentaCentavos.formatado());
		assertEquals(50, cincquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, cincquentaCentavos.obterMoeda());
	}

	@Test
	public void reaisInteiroQuatroFracionadoCem() throws Exception {
		Dinheiro cincoReais = new Dinheiro(Moeda.BRL, 4, 100);
		assertEquals("5,00 BRL", cincoReais.formatado());
		assertEquals(500, cincoReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, cincoReais.obterMoeda());
	}


	@Test
	public void reaisInteiroMenosCincoFracionadoMenosCinquenta() throws Exception {
		Dinheiro cincoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -5, -50);
		assertEquals("5,50 BRL", cincoReaisCinquentaCentavos.formatado());
		assertEquals(550, cincoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, cincoReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void comoValorMonetarioPositivo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario positivoDezReais = dezReais.positivo();
		assertFalse(positivoDezReais.negativo());
		assertEquals(dezReais, positivoDezReais.obterQuantia());
	}

	@Test
	public void comoValorMonetarioNegativo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario negativoDezReais = dezReais.negativo();
		assertTrue(negativoDezReais.negativo());
		assertEquals(dezReais, negativoDezReais.obterQuantia());
	}

	@Test
	public void iguais() throws Exception {
		assertEquals(new Dinheiro(Moeda.BRL, 0, 0), new Dinheiro(Moeda.BRL, 0, 0));
		assertEquals(new Dinheiro(Moeda.BRL, 0, 0), new Dinheiro(Moeda.USD, 0, 0));
		assertEquals(new Dinheiro(Moeda.BRL, 10, 0), new Dinheiro(Moeda.BRL, 10, 0));
		assertEquals(new Dinheiro(Moeda.BRL, 10, 0), new Dinheiro(Moeda.BRL, 10, 0));
		assertEquals(new Dinheiro(Moeda.BRL, 10, 0), new Dinheiro(Moeda.BRL, 9, 100));
	}

	@Test
	public void diferentes() throws Exception {
		assertNotEquals(new Dinheiro(Moeda.BRL, 2, 30), new Dinheiro(Moeda.BRL, 2, 31));
		assertNotEquals(new Dinheiro(Moeda.BRL, 2, 30), new Dinheiro(Moeda.BRL, 1, 30));
		assertNotEquals(new Dinheiro(Moeda.BRL, 2, 30), new Dinheiro(Moeda.USD, 2, 30));
	}

}
