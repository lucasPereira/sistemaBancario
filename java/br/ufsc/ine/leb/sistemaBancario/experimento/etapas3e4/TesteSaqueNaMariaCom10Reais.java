package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

@FixtureSetup(TesteMariaCom10Reais.class)
public class TesteSaqueNaMariaCom10Reais {

	@Fixture
	Banco banco;
	@Fixture
	SistemaBancario sistema;

	@Fixture
	Conta mariaCom10Reais;

	@Fixture
	Dinheiro seisReais;
	@Fixture
	Dinheiro quatroReais;
	
	@Test
	public void testeSaqueNaMaria()
	{
		Operacao op = sistema.sacar(mariaCom10Reais, seisReais);
		assertEquals(EstadosDeOperacao.SUCESSO, op.obterEstado());
		assertEquals(quatroReais.positivo(), mariaCom10Reais.calcularSaldo());
	}
	
	
}
