package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

public class TesteAgencia {

	@Test
	public void bancoDoBrasilTrindade() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		assertEquals("001", bancoDoBrasilTrindade.obterIdentificador());
		assertEquals("Trindade", bancoDoBrasilTrindade.obterNome());
	}

	@Test
	public void bancoDoBrasilPantanal() throws Exception {
		Banco bancoDoBrasil = new Banco(0, 0);
		bancoDoBrasil.criarAgencia("Trindade");
		Agencia bancoDoBrasilPantanal = bancoDoBrasil.criarAgencia("Pantanal");
		assertEquals("002", bancoDoBrasilPantanal.obterIdentificador());
		assertEquals("Pantanal", bancoDoBrasilPantanal.obterNome());
	}

}
