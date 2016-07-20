package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

@FixtureSetup(Testes.class)
public class Teste2 {
	
	@Fixture private Banco bancoDoBrasil;
	private Agencia centro;
	
	@Before
	public void setup() { 
		centro = bancoDoBrasil.criarAgencia("Centro");
	}
	
	@Test
	public void teste2() throws Exception {
		assertTrue(centro.obterIdentificador().equals("001"));
		assertTrue(centro.obterNome().equals("Centro"));
		assertTrue(centro.obterBanco().equals(bancoDoBrasil));
	}

}
