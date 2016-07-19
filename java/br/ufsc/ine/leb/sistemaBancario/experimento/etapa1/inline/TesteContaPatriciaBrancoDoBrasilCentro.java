package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.inline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteContaPatriciaBrancoDoBrasilCentro {

	@Test
	public void patriciaBancoDoBrasil() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Conta patriciaBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Patrícia");
		assertEquals("Patrícia", patriciaBancoDoBrasilCentro.obterTitular());
		assertTrue(patriciaBancoDoBrasilCentro.calcularSaldo().zero());
		assertEquals(bancoDoBrasilCentro, patriciaBancoDoBrasilCentro.obterAgencia());
	}

}
