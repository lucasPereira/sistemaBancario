package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteConta {

	@Test
	public void bancoDoBrasilLucas() throws Exception {
		ValorMonetario positivoZeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		assertEquals("0001-5", lucasBancoDoBrasil.obterIdentificador());
		assertEquals("Lucas", lucasBancoDoBrasil.obterTitular());
		assertEquals(positivoZeroReais, lucasBancoDoBrasil.calcularSaldo());
		assertEquals(bancoDoBrasilTrindade, lucasBancoDoBrasil.obterAgencia());
	}

	@Test
	public void bancoDoBrasilPatricia() throws Exception {
		ValorMonetario positivoZeroReais = new ValorMonetario(Moeda.BRL);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco(Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		bancoDoBrasilTrindade.criarConta("Lucas");
		Conta patriciaBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Patrícia");
		assertEquals("0002-8", patriciaBancoDoBrasil.obterIdentificador());
		assertEquals("Patrícia", patriciaBancoDoBrasil.obterTitular());
		assertEquals(positivoZeroReais, patriciaBancoDoBrasil.calcularSaldo());
		assertEquals(bancoDoBrasilTrindade, patriciaBancoDoBrasil.obterAgencia());
	}

}
