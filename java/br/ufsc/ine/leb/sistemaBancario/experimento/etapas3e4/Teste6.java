package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

@FixtureSetup({Teste5.class, Testes.class})
public class Teste6 {
	
	@Fixture private SistemaBancario sistemaBancario;
	@Fixture private Conta bContaDaMaria;
	@Fixture private Dinheiro v4reais;
	private Operacao saqueDeMaria;
	@Fixture private Dinheiro amount;
	
	@Before
	public void setup() {
		saqueDeMaria = sistemaBancario.sacar(bContaDaMaria, amount);
	}

	@Test
	public void teste6() throws Exception {
		assertEquals(EstadosDeOperacao.SALDO_INSUFICIENTE, saqueDeMaria.obterEstado());
		assertEquals(v4reais, bContaDaMaria.calcularSaldo().obterQuantia());
	}
}
