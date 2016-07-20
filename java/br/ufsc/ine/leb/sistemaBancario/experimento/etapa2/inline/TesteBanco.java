package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.inline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBanco {

	@Test
	public void caixaEconomica() throws Exception {
		SistemaBancario sistema = new SistemaBancario();
		Banco caixaEconomica = sistema.criarBanco("Caixa Econômica", Moeda.BRL);
		assertEquals("Caixa Econômica", caixaEconomica.obterNome());
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
	}

}
