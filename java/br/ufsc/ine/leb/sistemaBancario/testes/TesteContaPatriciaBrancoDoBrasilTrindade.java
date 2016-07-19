package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteContaPatriciaBrancoDoBrasilTrindade {

	@Test
	public void testar() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta patriciaBancoDoBrasilTrindade = bancoDoBrasilTrindade.criarConta("Patrícia");
		assertEquals("Patrícia", patriciaBancoDoBrasilTrindade.obterTitular());
		assertTrue(patriciaBancoDoBrasilTrindade.calcularSaldo().zero());
		assertEquals(bancoDoBrasilTrindade, patriciaBancoDoBrasilTrindade.obterAgencia());
	}

}
