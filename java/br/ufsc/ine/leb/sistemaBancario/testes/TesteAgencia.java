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
	public void bancoDoBrasilCentro() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		bancoDoBrasil.criarAgencia("Trindade");
		Agencia bancoDoBrasilPantanal = bancoDoBrasil.criarAgencia("Centro");
		assertEquals("002", bancoDoBrasilPantanal.obterIdentificador());
		assertEquals("Centro", bancoDoBrasilPantanal.obterNome());
		assertEquals(bancoDoBrasil, bancoDoBrasilPantanal.obterBanco());
	}

	@Test
	public void caixaEconomicaTrindade() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco caixaEconomica = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia caixaEconomicaTrindade = caixaEconomica.criarAgencia("Trindade");
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

}
