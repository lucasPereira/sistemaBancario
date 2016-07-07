package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteDinheiro {

	@Test
	public void inteiroDezFracionadoZero() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertEquals("10,00 BRL", dezReais.formatado());
		assertEquals(1000, dezReais.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroUmFracionadoNoventaNove() throws Exception {
		Dinheiro umRealNovamentaNoveCentavos = new Dinheiro(Moeda.BRL, 1, 99);
		assertEquals("1,99 BRL", umRealNovamentaNoveCentavos.formatado());
		assertEquals(199, umRealNovamentaNoveCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroCinquentaCincoFracionadoCentoCinquenta() throws Exception {
		Dinheiro cinquentaSeisReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 55, 150);
		assertEquals("56,50 BRL", cinquentaSeisReaisCinquentaCentavos.formatado());
		assertEquals(5650, cinquentaSeisReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroZeroFracionadoDuzentosTrinta() throws Exception {
		Dinheiro doisReaisTrintaCentavos = new Dinheiro(Moeda.BRL, 0, 230);
		assertEquals("2,30 BRL", doisReaisTrintaCentavos.formatado());
		assertEquals(230, doisReaisTrintaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroMenosSeteFracionadoCentoCinquenta() throws Exception {
		Dinheiro oitoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -7, 150);
		assertEquals("8,50 BRL", oitoReaisCinquentaCentavos.formatado());
		assertEquals(850, oitoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroMenosSeteFracionadoMenosCentoCinquenta() throws Exception {
		Dinheiro oitoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -7, -150);
		assertEquals("8,50 BRL", oitoReaisCinquentaCentavos.formatado());
		assertEquals(850, oitoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroSeteFracionadoMenosCentoCinquenta() throws Exception {
		Dinheiro oitoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 7, -150);
		assertEquals("8,50 BRL", oitoReaisCinquentaCentavos.formatado());
		assertEquals(850, oitoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroMenosDoisFracionadoQuinhentosCinquenta() throws Exception {
		Dinheiro tresReaiscinquentaCentavos = new Dinheiro(Moeda.BRL, -2, 150);
		assertEquals("3,50 BRL", tresReaiscinquentaCentavos.formatado());
		assertEquals(350, tresReaiscinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroMenosDoisFracionadoMenosQuinhentosCinquenta() throws Exception {
		Dinheiro tresReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -2, -150);
		assertEquals("3,50 BRL", tresReaisCinquentaCentavos.formatado());
		assertEquals(350, tresReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void inteiroDoisFracionadoMenosQuinhentosCinquenta() throws Exception {
		Dinheiro tresReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 2, -150);
		assertEquals("3,50 BRL", tresReaisCinquentaCentavos.formatado());
		assertEquals(350, tresReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void zero() throws Exception {
		Dinheiro zero = new Dinheiro(Moeda.BRL, 0, 0);
		assertEquals("0,00", zero.formatado());
		assertEquals(0, zero.obterQuantiaEmEscala().intValue());
	}

	@Test
	public void iguais() throws Exception {
		Dinheiro zero = new Dinheiro(Moeda.BRL, 0, 0);
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertEquals(dezReais, new Dinheiro(Moeda.BRL, 10, 0));
		assertEquals(dezReais, new Dinheiro(Moeda.BRL, 10, 0));
		assertEquals(dezReais, new Dinheiro(Moeda.BRL, 9, 100));
		assertEquals(zero, new Dinheiro(Moeda.BRL, 0, 0));
		assertEquals(zero, new Dinheiro(Moeda.USD, 0, 0));
	}

	@Test
	public void diferentes() throws Exception {
		Dinheiro doisReaisTrintaCentavos = new Dinheiro(Moeda.BRL, 2, 30);
		assertNotEquals(doisReaisTrintaCentavos, new Dinheiro(Moeda.BRL, 2, 31));
		assertNotEquals(doisReaisTrintaCentavos, new Dinheiro(Moeda.BRL, 1, 30));
		assertNotEquals(doisReaisTrintaCentavos, new Dinheiro(Moeda.USD, 2, 30));
	}

}
