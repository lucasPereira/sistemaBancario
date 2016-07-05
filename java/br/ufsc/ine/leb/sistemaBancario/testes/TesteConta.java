package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;

public class TesteConta {

	@Test
	public void bancoDoBrasilLucas() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta bancoDoBrasilLucas = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		assertEquals("0001-5", bancoDoBrasilLucas.obterIdentificador());
		assertEquals("Lucas", bancoDoBrasilLucas.obterTitular());
		assertEquals("0,00", bancoDoBrasilLucas.obterSaldo().formatado());
	}

	@Test
	public void bancoDoBrasilPatricia() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Conta bancoDoBrasilPatricia = bancoDoBrasil.criarConta("Patrícia", bancoDoBrasilTrindade);
		assertEquals("0002-8", bancoDoBrasilPatricia.obterIdentificador());
		assertEquals("Patrícia", bancoDoBrasilPatricia.obterTitular());
		assertEquals("0,00", bancoDoBrasilPatricia.obterSaldo().formatado());
	}

}
