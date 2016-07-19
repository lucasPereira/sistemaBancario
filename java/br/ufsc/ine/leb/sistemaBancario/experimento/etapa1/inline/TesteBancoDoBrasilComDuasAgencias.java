package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.inline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBancoDoBrasilComDuasAgencias {

	@Test
	public void testar() throws Exception {
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		assertEquals("001", bancoDoBrasilCentro.obterIdentificador());
		assertEquals("002", bancoDoBrasilTrindade.obterIdentificador());
	}

}
