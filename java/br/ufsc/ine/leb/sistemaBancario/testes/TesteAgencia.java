package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteAgencia {

	@Test
	public void bancoDoBrasilTrindade() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		assertEquals("001", bancoDoBrasilTrindade.obterIdentificador());
		assertEquals("Trindade", bancoDoBrasilTrindade.obterNome());
		assertEquals(bancoDoBrasil, bancoDoBrasilTrindade.obterBanco());
	}

	@Test
	public void bancoDoBrasilPantanal() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		bancoDoBrasil.criarAgencia("Trindade");
		Agencia bancoDoBrasilPantanal = bancoDoBrasil.criarAgencia("Pantanal");
		assertEquals("002", bancoDoBrasilPantanal.obterIdentificador());
		assertEquals("Pantanal", bancoDoBrasilPantanal.obterNome());
		assertEquals(bancoDoBrasil, bancoDoBrasilPantanal.obterBanco());
	}

}
