package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.delegate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteBanco {

	@Test
	public void testar() throws Exception {
		Banco caixaEconomica = Auxiliar.criarCaixaEconomica();
		assertEquals("Caixa Econômica", caixaEconomica.obterNome());
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
	}

}
