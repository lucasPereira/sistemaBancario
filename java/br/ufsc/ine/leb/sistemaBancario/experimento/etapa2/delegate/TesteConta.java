package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.delegate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;

public class TesteConta {

	@Test
	public void joaoCaixaEconomicaTrindade() throws Exception {
		
		Agencia caixaEconomicaTrindade = Auxiliar.criarTrindade(Auxiliar.criarCaixaEconomica());
		Conta joaoCaixaEconomicaTrindade = caixaEconomicaTrindade.criarConta("João");
		assertEquals("0001-4", joaoCaixaEconomicaTrindade.obterIdentificador());
		assertEquals("João", joaoCaixaEconomicaTrindade.obterTitular());
		assertTrue(joaoCaixaEconomicaTrindade.calcularSaldo().zero());
		assertEquals(caixaEconomicaTrindade, joaoCaixaEconomicaTrindade.obterAgencia());
	}

}
