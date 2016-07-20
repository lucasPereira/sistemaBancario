package br.ufsc.ine.leb.sistemaBancario.experimento.etapas3e4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;


@FixtureSetup(Testes.class)
public class TesteMariaCom10Reais {

	
	@Fixture
	SistemaBancario sistema;
	@Fixture
	Banco banco;
	@Fixture
	Agencia centro;
	@Fixture
	Conta maria;
	
	Conta mariaCom10Reais;
	Conta mariaCom4Reais;
	
	
	Dinheiro dezReais;
	Dinheiro quatroReais;
	Dinheiro seisReais;

		
	@Before
	public void setup() {
		dezReais = new Dinheiro(banco.obterMoeda(), 10, 0);
		quatroReais = new Dinheiro(banco.obterMoeda(), 4, 0);
		seisReais = new Dinheiro(banco.obterMoeda(), 6, 0);
		mariaCom10Reais = Auxiliar.criarMariaComSaldo(sistema, centro, dezReais);
		mariaCom4Reais = Auxiliar.criarMariaComSaldo(sistema, centro, quatroReais);
	}
	
	@Test
	public void contaMariaSaldoZerado() {
		ValorMonetario zero = new Dinheiro(banco.obterMoeda(), 0, 0).positivo();
		assertEquals("0001-5", maria.obterIdentificador());
		assertEquals("Maria", maria.obterTitular());
		assertEquals(zero, maria.calcularSaldo());
		assertEquals(centro, maria.obterAgencia());
	}
	
	@Test
	public void testeDepositoDeDezReaisNaContaDaMaria() {
		Operacao op = sistema.depositar(maria, dezReais);
		assertEquals(dezReais.positivo(), maria.calcularSaldo());
		assertEquals(EstadosDeOperacao.SUCESSO, op.obterEstado());
	}
	
	@Test
	public void testeSaqueDeSeisNaContaDaMariaComQuatro() {
		Operacao op = sistema.sacar(mariaCom4Reais, seisReais);
		assertEquals(quatroReais.positivo(), mariaCom4Reais.calcularSaldo());
		assertEquals(EstadosDeOperacao.SALDO_INSUFICIENTE, op.obterEstado());
	}
}
