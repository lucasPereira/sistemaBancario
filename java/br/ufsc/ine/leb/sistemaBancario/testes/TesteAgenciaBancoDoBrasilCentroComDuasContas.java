package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteAgenciaBancoDoBrasilCentroComDuasContas {

	@Test
	public void testar() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Conta lucasBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Lucas");
		Conta patriciaBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Patrícia");
		assertEquals("0001-5", lucasBancoDoBrasilCentro.obterIdentificador());
		assertEquals("0002-8", patriciaBancoDoBrasilCentro.obterIdentificador());
	}

}
