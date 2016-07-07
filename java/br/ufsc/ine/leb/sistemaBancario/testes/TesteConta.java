package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteConta {

	@Test
	public void bancoDoBrasilLucas() throws Exception {
		Dinheiro zero = new Dinheiro(Moeda.BRL, 0, 0);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		assertEquals("0001-5", lucasBancoDoBrasil.obterIdentificador());
		assertEquals("Lucas", lucasBancoDoBrasil.obterTitular());
		assertEquals(zero, lucasBancoDoBrasil.obterSaldo());
	}

	@Test
	public void bancoDoBrasilPatricia() throws Exception {
		Dinheiro zero = new Dinheiro(Moeda.BRL, 0, 0);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Conta patriciaBancoDoBrasil = bancoDoBrasil.criarConta("Patrícia", bancoDoBrasilTrindade);
		assertEquals("0002-8", patriciaBancoDoBrasil.obterIdentificador());
		assertEquals("Patrícia", patriciaBancoDoBrasil.obterTitular());
		assertEquals(zero, patriciaBancoDoBrasil.obterSaldo());
	}

}
