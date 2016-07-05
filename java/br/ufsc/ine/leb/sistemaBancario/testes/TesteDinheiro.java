package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteDinheiro {

	@Test
	public void iguais() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10);
		assertEquals(dezReais, new Dinheiro(Moeda.BRL, 10));
		assertEquals(dezReais, new Dinheiro(Moeda.BRL, 10, 0));
		assertEquals(dezReais, new Dinheiro(Moeda.BRL, 9, 100));
	}

	@Test
	public void diferentes() throws Exception {
		Dinheiro doisReaisTrintaCentavos = new Dinheiro(Moeda.BRL, 2, 30);
		assertNotEquals(doisReaisTrintaCentavos, new Dinheiro(Moeda.BRL, 2, 31));
		assertNotEquals(doisReaisTrintaCentavos, new Dinheiro(Moeda.BRL, 1, 30));
		assertNotEquals(doisReaisTrintaCentavos, new Dinheiro(Moeda.USD, 2, 30));
	}

	@Test
	public void inteiroDez() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10);
		assertEquals("10,00 BRL", dezReais.formatado());
	}

	@Test
	public void inteiroUmFracionadoNoventaNove() throws Exception {
		Dinheiro umRealNovamentaNoveCentavos = new Dinheiro(Moeda.BRL, 1, 99);
		assertEquals("1,99 BRL", umRealNovamentaNoveCentavos.formatado());
	}

	@Test
	public void inteiroCinquentaCincoFracionadoCentoCinquenta() throws Exception {
		Dinheiro cinquentaSeisReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 55, 150);
		assertEquals("56,50 BRL", cinquentaSeisReaisCinquentaCentavos.formatado());
	}

	@Test
	public void inteiroZeroFracionadoDuzentosTrinta() throws Exception {
		Dinheiro doisReaisTrintaCentavos = new Dinheiro(Moeda.BRL, 0, 230);
		assertEquals("2,30 BRL", doisReaisTrintaCentavos.formatado());
	}

	@Test
	public void zero() throws Exception {
		Dinheiro zero = new Dinheiro(Moeda.BRL, 0, 0);
		assertEquals("0,00", zero.formatado());
		assertEquals(zero, new Dinheiro(Moeda.BRL, 0, 0));
		assertEquals(zero, new Dinheiro(Moeda.USD, 0, 0));
	}

}
