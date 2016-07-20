package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.dependency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBanco {

	private Banco caixaEconomica;
	
	@Before
	public void setup() throws Exception {
		SistemaBancario sistema = new SistemaBancario();
		caixaEconomica = sistema.criarBanco("Caixa Econômica", Moeda.BRL);
	}

	@Test
	public void caixaEconomica() throws Exception {
		assertEquals("Caixa Econômica", caixaEconomica.obterNome());
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
	}

}
