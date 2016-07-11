package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteBanco {

	@Test
	public void bancoDoBrasil() throws Exception {
		ValorMonetario zeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		assertTrue(bancoDoBrasil.aceitaMoeda(Moeda.BRL));
		assertEquals(zeroReais, bancoDoBrasil.construirValorMonetario());
	}

	@Test
	public void caixaEconomicaFederal() throws Exception {
		ValorMonetario zeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco caixaEconomicaFederal = sistemaBancario.criarBanco(Moeda.BRL);
		assertTrue(caixaEconomicaFederal.aceitaMoeda(Moeda.BRL));
		assertEquals(zeroReais, caixaEconomicaFederal.construirValorMonetario());
	}

}
