package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.delegate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.delegate.Auxiliar;

public class TesteAgencia {

	@Test
	public void caixaEconomicaTrindade() throws Exception {
		
		Banco caixaEconomica = Auxiliar.criarCaixaEconomica();
		Agencia caixaEconomicaTrindade = Auxiliar.criarTrindade(caixaEconomica);
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

}
