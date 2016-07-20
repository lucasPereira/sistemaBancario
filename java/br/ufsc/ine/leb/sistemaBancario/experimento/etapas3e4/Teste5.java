package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

@FixtureSetup({Teste4.class, Testes.class})
public class Teste5 {
	
	@Fixture private SistemaBancario sistemaBancario;
	@Fixture private Conta bContaDaMaria;
	private Operacao saqueDeMaria;
	private Dinheiro amount;
	private Dinheiro v4reais;
	
	@Before
	public void setup() {
		amount = new Dinheiro(Moeda.BRL, 6, 0);
		v4reais = new Dinheiro(Moeda.BRL, 4, 0);
		saqueDeMaria = sistemaBancario.sacar(bContaDaMaria, amount);
	}
	
	@Test
	public void teste5() throws Exception {
		assertEquals(EstadosDeOperacao.SUCESSO, saqueDeMaria.obterEstado());
		assertEquals(v4reais, bContaDaMaria.calcularSaldo().obterQuantia());
	}
}
