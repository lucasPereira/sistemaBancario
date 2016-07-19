package br.ufsc.ine.leb.sistemaBancario.experimento.etapa2.implicit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteAgencia {

	private Banco caixaEconomica;
	private Agencia caixaEconomicaTrindade;

	@Before
	public void configurar() throws Exception {
		/** Completar */
		SistemaBancario sistemaBancario = new SistemaBancario();
		caixaEconomica = sistemaBancario.criarBanco("Caixa Econômica", Moeda.BRL);
		caixaEconomicaTrindade = caixaEconomica.criarAgencia("Trindade");
		/** Completar */
	}

	@Test
	public void testar() throws Exception {
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

}
