package br.ufsc.ine.leb.sistemaBancario.experimento.etapa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteAgencia {

	@Test
	public void bancoDoBrasilCentro() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		assertEquals("001", bancoDoBrasilCentro.obterIdentificador());
		assertEquals("Centro", bancoDoBrasilCentro.obterNome());
		assertEquals(bancoDoBrasil, bancoDoBrasilCentro.obterBanco());
	}

}
