package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeTransacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.Transacao;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteTransacao {

	@Test
	public void entrada() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario positivoDezReais = new ValorMonetario(Moeda.BRL).somar(dezReais);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = new Entrada(bancoDoBrasil, lucasBancoDoBrasil, Moeda.BRL, dezReais);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
		assertEquals(positivoDezReais, transacao.obterValorMonetario());
	}
	
	@Test
	public void saida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario negativoDezReais = new ValorMonetario(Moeda.BRL).subtrair(dezReais);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = new Saida(bancoDoBrasil, lucasBancoDoBrasil, Moeda.BRL, dezReais);
		assertEquals(EstadosDeTransacao.SUCESSO, transacao.obterEstado());
		assertEquals(negativoDezReais, transacao.obterValorMonetario());
	}

	@Test
	public void invalida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario negativoDezReais = new ValorMonetario(Moeda.BRL).subtrair(dezReais);
		Banco bancoDoBrasil = new Banco();
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasil.criarConta("Lucas", bancoDoBrasilTrindade);
		Transacao transacao = new NaoRealizada(EstadosDeTransacao.SALDO_INSUFICIENTE, new Saida(bancoDoBrasil, lucasBancoDoBrasil, Moeda.BRL, dezReais));
		assertEquals(EstadosDeTransacao.SALDO_INSUFICIENTE, transacao.obterEstado());
		assertEquals(negativoDezReais, transacao.obterValorMonetario());
	}

}
