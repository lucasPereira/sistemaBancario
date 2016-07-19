package br.ufsc.ine.leb.sistemaBancario.experimento.etapa4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteSistemaBancario {

	@Test
	public void depositar() throws Exception {
		Dinheiro dez = new Dinheiro(Moeda.BRL, 10, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Conta mariaBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Maria");
		Operacao operacao = sistemaBancario.depositar(mariaBancoDoBrasilCentro, dez);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(dez.positivo(), mariaBancoDoBrasilCentro.calcularSaldo());
	}

	@Test
	public void sacar() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Conta mariaBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Maria");
		sistemaBancario.depositar(mariaBancoDoBrasilCentro, dezReais);
		Operacao operacao = sistemaBancario.sacar(mariaBancoDoBrasilCentro, seisReais);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(quatroReais.positivo(), mariaBancoDoBrasilCentro.calcularSaldo());
	}

	@Test
	public void sacarSemSaldo() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro seisReais = new Dinheiro(Moeda.BRL, 6, 0);
		Dinheiro quatroReais = new Dinheiro(Moeda.BRL, 4, 0);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Conta mariaBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Maria");
		sistemaBancario.depositar(mariaBancoDoBrasilCentro, dezReais);
		sistemaBancario.sacar(mariaBancoDoBrasilCentro, seisReais);
		Operacao operacao = sistemaBancario.sacar(mariaBancoDoBrasilCentro, dezReais);
		assertEquals(EstadosDeOperacao.SALDO_INSUFICIENTE, operacao.obterEstado());
		assertEquals(quatroReais.positivo(), mariaBancoDoBrasilCentro.calcularSaldo());
	}

}
