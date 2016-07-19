package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.delegate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

public class TesteAgencia {

	@Test
	public void testar() throws Exception {
		/** Completar */
		Banco caixaEconomica = Auxiliar.criarCaixaEconomica();
		Agencia caixaEconomicaTrindade = Auxiliar.criarTrindade(caixaEconomica);
		/** Completar */
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

}
