package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Testes {

	SistemaBancario sistema;
	Banco banco;
	Agencia centro;
	Conta maria;
	
	@Before
	public void setup() {
		sistema = new SistemaBancario();
		banco = sistema.criarBanco("Banco do Brasil", Moeda.BRL);
		centro = banco.criarAgencia("Centro");
		maria = centro.criarConta("Maria");
	}
	
	@Test
	public void testeBancoDoBrasil() {
		assertEquals("Banco do Brasil", banco.obterNome());
	}
	
	@Test
	public void testeAgenciaCentro() {
		assertEquals("001", centro.obterIdentificador());
		assertEquals("Centro", centro.obterNome());
		assertEquals(banco, centro.obterBanco());
	}
	
	
	
	

}
