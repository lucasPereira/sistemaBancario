package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;

@FixtureSetup(Teste2.class)
public class Teste3 {
	
	@Fixture private Agencia centro;
	private Conta bContaDaMaria;
	
	@Before
	public void setup() { 
		bContaDaMaria = centro.criarConta("Maria");
	}
	
	@Test
	public void teste3() throws Exception {
		assertTrue(bContaDaMaria.obterIdentificador().equals("0001-5"));
		assertTrue(bContaDaMaria.obterTitular().equals("Maria"));
		assertTrue(bContaDaMaria.calcularSaldo().zero());
		assertTrue(bContaDaMaria.obterAgencia() == centro);
	}

}
