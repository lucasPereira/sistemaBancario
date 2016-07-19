package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.dependency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteSistemaBancario {

	private SistemaBancario sistemaBancario;
	private Banco caixaEconomica;

	@Before
	public void configurar() throws Exception {
		sistemaBancario = new SistemaBancario();
		caixaEconomica = sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
	}

	@Test
	public void testar() throws Exception {
		assertEquals(1, sistemaBancario.obterBancos().size());
		assertEquals(caixaEconomica, sistemaBancario.obterBancos().size());
	}

}
