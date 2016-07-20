package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.dependency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;

@FixtureSetup(TesteAgencia.class)
public class TesteConta {
	
	@Fixture private Banco caixaEconomica;
	@Fixture private Agencia caixaEconomicaTrindade;
	private Conta joaoCaixaEconomicaTrindade;
	
	@Before
	public void configurar() throws Exception {
		joaoCaixaEconomicaTrindade = caixaEconomicaTrindade.criarConta("João");
	}

	@Test
	public void joaoCaixaEconomicaTrindade() throws Exception {
		assertEquals("0001-4", joaoCaixaEconomicaTrindade.obterIdentificador());
		assertEquals("João", joaoCaixaEconomicaTrindade.obterTitular());
		assertTrue(joaoCaixaEconomicaTrindade.calcularSaldo().zero());
		assertEquals(caixaEconomicaTrindade, joaoCaixaEconomicaTrindade.obterAgencia());
	}

}
