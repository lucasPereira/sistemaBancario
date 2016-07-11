package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteValorMonetario {

	@Test
	public void zero() throws Exception {
		Dinheiro zeroReais = new Dinheiro(Moeda.BRL, 0, 0);
		ValorMonetario valor = new ValorMonetario(Moeda.BRL);
		assertFalse(valor.negativo());
		assertEquals(zeroReais, valor.obterQuantia());
		assertEquals("0,00", valor.formatado());
	}

	@Test
	public void somarReaisSomarCentavos() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cinquentaCentavos = new Dinheiro(Moeda.BRL, 0, 50);
		Dinheiro dezReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 10, 50);
		ValorMonetario valor = new ValorMonetario(Moeda.BRL).somar(dezReais).somar(cinquentaCentavos);
		assertFalse(valor.negativo());
		assertEquals(dezReaisCinquentaCentavos, valor.obterQuantia());
		assertEquals("+10,50 BRL", valor.formatado());
	}

	@Test
	public void subtrairReaisSubtrairCentavos() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cinquentaCentavos = new Dinheiro(Moeda.BRL, 0, 50);
		Dinheiro dezReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 10, 50);
		ValorMonetario valor = new ValorMonetario(Moeda.BRL).subtrair(dezReais).subtrair(cinquentaCentavos);
		assertTrue(valor.negativo());
		assertEquals(dezReaisCinquentaCentavos, valor.obterQuantia());
		assertEquals("-10,50 BRL", valor.formatado());
	}

	@Test
	public void somarReaisSubtrairCentavos() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cinquentaCentavos = new Dinheiro(Moeda.BRL, 0, 50);
		Dinheiro noveReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 9, 50);
		ValorMonetario valor = new ValorMonetario(Moeda.BRL).somar(dezReais).subtrair(cinquentaCentavos);
		assertFalse(valor.negativo());
		assertEquals(noveReaisCinquentaCentavos, valor.obterQuantia());
		assertEquals("+9,50 BRL", valor.formatado());
	}

	@Test
	public void subtrairReaisSomarCentavos() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro cinquentaCentavos = new Dinheiro(Moeda.BRL, 0, 50);
		Dinheiro noveReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 9, 50);
		ValorMonetario valor = new ValorMonetario(Moeda.BRL).subtrair(dezReais).somar(cinquentaCentavos);
		assertTrue(valor.negativo());
		assertEquals(noveReaisCinquentaCentavos, valor.obterQuantia());
		assertEquals("-9,50 BRL", valor.formatado());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void somarMoedaDiferente() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		new ValorMonetario(Moeda.USD).somar(dezReais);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void subtrairMoedaDiferente() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		new ValorMonetario(Moeda.USD).subtrair(dezReais);
	}

	@Test
	public void iguais() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertEquals(new ValorMonetario(Moeda.BRL), new ValorMonetario(Moeda.BRL));
		assertEquals(new ValorMonetario(Moeda.BRL), new ValorMonetario(Moeda.USD));
		assertEquals(new ValorMonetario(Moeda.BRL).somar(dezReais), new ValorMonetario(Moeda.BRL).somar(dezReais));
		assertEquals(new ValorMonetario(Moeda.BRL).subtrair(dezReais),
				new ValorMonetario(Moeda.BRL).subtrair(dezReais));
	}

	@Test
	public void diferentes() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		assertNotEquals(new ValorMonetario(Moeda.BRL).somar(dezReais), new ValorMonetario(Moeda.BRL));
		assertNotEquals(new ValorMonetario(Moeda.BRL).subtrair(dezReais), new ValorMonetario(Moeda.BRL));
		assertNotEquals(new ValorMonetario(Moeda.BRL).somar(dezReais),
				new ValorMonetario(Moeda.BRL).subtrair(dezReais));
	}

}
