package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.dependency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;

public class TesteConta {

	private Agencia caixaEconomicaTrindade;

	private Conta joaoCaixaEconomicaTrindade;

	@Before
	public void configurar() throws Exception {
		joaoCaixaEconomicaTrindade = caixaEconomicaTrindade.criarConta("João");
	}

	@Test
	public void joaoCaixaEconomicaTrindade() throws Exception {
		assertEquals("0001-8", joaoCaixaEconomicaTrindade.obterIdentificador());
		assertEquals("João", joaoCaixaEconomicaTrindade.obterTitular());
		assertTrue(joaoCaixaEconomicaTrindade.calcularSaldo().zero());
		assertEquals(caixaEconomicaTrindade, joaoCaixaEconomicaTrindade.obterAgencia());
	}

}
