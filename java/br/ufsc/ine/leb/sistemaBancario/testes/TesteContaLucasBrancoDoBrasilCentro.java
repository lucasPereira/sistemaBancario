package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteContaLucasBrancoDoBrasilCentro {

	@Test
	public void testar() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Centro");
		Conta lucasBancoDoBrasilCentro = bancoDoBrasilTrindade.criarConta("Lucas");
		assertEquals("Lucas", lucasBancoDoBrasilCentro.obterTitular());
		assertTrue(lucasBancoDoBrasilCentro.calcularSaldo().zero());
		assertEquals(bancoDoBrasilTrindade, lucasBancoDoBrasilCentro.obterAgencia());
	}

}
