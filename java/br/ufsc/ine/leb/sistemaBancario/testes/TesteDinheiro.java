package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteDinheiro {

	@Test
	public void zero() throws Exception {
		Dinheiro zeroReais = new Dinheiro(Moeda.BRL, 0, 0);
		assertEquals("0,00", zeroReais.formatado());
		assertEquals(0, zeroReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, zeroReais.obterMoeda());
	}

	@Test
	public void inteiroDezFracionadoZero() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertEquals("10,00 BRL", dezReais.formatado());
		assertEquals(1000, dezReais.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, dezReais.obterMoeda());
	}

	@Test
	public void inteiroUmFracionadoNoventaNove() throws Exception {
		Dinheiro umRealNovamentaNoveCentavos = new Dinheiro(Moeda.BRL, 1, 99);
		assertEquals("1,99 BRL", umRealNovamentaNoveCentavos.formatado());
		assertEquals(199, umRealNovamentaNoveCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, umRealNovamentaNoveCentavos.obterMoeda());
	}

	@Test
	public void inteiroCinquentaCincoFracionadoCentoCinquenta() throws Exception {
		Dinheiro cinquentaSeisReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 55, 150);
		assertEquals("56,50 BRL", cinquentaSeisReaisCinquentaCentavos.formatado());
		assertEquals(5650, cinquentaSeisReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, cinquentaSeisReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void inteiroZeroFracionadoDuzentosTrinta() throws Exception {
		Dinheiro doisReaisTrintaCentavos = new Dinheiro(Moeda.BRL, 0, 230);
		assertEquals("2,30 BRL", doisReaisTrintaCentavos.formatado());
		assertEquals(230, doisReaisTrintaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, doisReaisTrintaCentavos.obterMoeda());
	}

	@Test
	public void inteiroMenosSeteFracionadoCentoCinquenta() throws Exception {
		Dinheiro oitoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -7, 150);
		assertEquals("8,50 BRL", oitoReaisCinquentaCentavos.formatado());
		assertEquals(850, oitoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, oitoReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void inteiroMenosSeteFracionadoMenosCentoCinquenta() throws Exception {
		Dinheiro oitoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -7, -150);
		assertEquals("8,50 BRL", oitoReaisCinquentaCentavos.formatado());
		assertEquals(850, oitoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, oitoReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void inteiroSeteFracionadoMenosCentoCinquenta() throws Exception {
		Dinheiro oitoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 7, -150);
		assertEquals("8,50 BRL", oitoReaisCinquentaCentavos.formatado());
		assertEquals(850, oitoReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, oitoReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void inteiroMenosDoisFracionadoQuinhentosCinquenta() throws Exception {
		Dinheiro tresReaiscinquentaCentavos = new Dinheiro(Moeda.BRL, -2, 150);
		assertEquals("3,50 BRL", tresReaiscinquentaCentavos.formatado());
		assertEquals(350, tresReaiscinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, tresReaiscinquentaCentavos.obterMoeda());
	}

	@Test
	public void inteiroMenosDoisFracionadoMenosQuinhentosCinquenta() throws Exception {
		Dinheiro tresReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, -2, -150);
		assertEquals("3,50 BRL", tresReaisCinquentaCentavos.formatado());
		assertEquals(350, tresReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, tresReaisCinquentaCentavos.obterMoeda());
	}

	@Test
	public void inteiroDoisFracionadoMenosQuinhentosCinquenta() throws Exception {
		Dinheiro tresReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 2, -150);
		assertEquals("3,50 BRL", tresReaisCinquentaCentavos.formatado());
		assertEquals(350, tresReaisCinquentaCentavos.obterQuantiaEmEscala().intValue());
		assertEquals(Moeda.BRL, tresReaisCinquentaCentavos.obterMoeda());
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
