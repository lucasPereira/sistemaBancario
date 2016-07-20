package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Testes {
	
	private SistemaBancario sistemaBancario;
	private Banco bancoDoBrasil;
	private Dinheiro taxa;
	
	@Before
	public void setup() {
		sistemaBancario = new SistemaBancario();
		taxa = new Dinheiro(Moeda.BRL, 0, 0);
		bancoDoBrasil = sistemaBancario.criarBanco("Banco Do Brasil", Moeda.BRL, taxa);
	}
	

	@Test
	public void testar() throws Exception {
		assertTrue(bancoDoBrasil.obterNome().equals("Banco Do Brasil"));
		assertTrue(bancoDoBrasil.obterMoeda() == Moeda.BRL);
	}

}
