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

@FixtureSetup({Teste3.class, Testes.class})
public class Teste4 {
	@Fixture private SistemaBancario sistemaBancario;
	@Fixture private Conta bContaDaMaria;
	private Operacao depositoDeMaria;
	private Dinheiro amount;

	@Before
	public void setup() {
		amount = new Dinheiro(Moeda.BRL, 10, 0);
		depositoDeMaria = sistemaBancario.depositar(bContaDaMaria, amount);
	}
	
	@Test
	public void teste4() throws Exception {
		assertEquals(EstadosDeOperacao.SUCESSO, depositoDeMaria.obterEstado());
		assertEquals(amount, bContaDaMaria.calcularSaldo().obterQuantia());
	}
}
