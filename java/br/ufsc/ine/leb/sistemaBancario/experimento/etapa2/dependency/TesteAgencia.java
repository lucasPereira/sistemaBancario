package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.dependency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

public class TesteAgencia {

	private Banco caixaEconomica;

	private Agencia caixaEconomicaTrindade;

	@Before
	public void configurar() throws Exception {
		caixaEconomicaTrindade = caixaEconomica.criarAgencia("Trindade");
	}

	@Test
	public void caixaEconomicaTrindade() throws Exception {
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

}
