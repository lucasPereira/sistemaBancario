package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.TransacaoNaoRealizada;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.Transacao;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteTransacao {

	@Test
	public void entrada() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		ValorMonetario positivoDezReais = dezReais.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Transacao transacao = new Entrada(lucasBancoDoBrasil, dezReais);
		assertEquals(positivoDezReais, transacao.obterValorMonetario());
		assertEquals(positivoDezReais, transacao.contabilizar(zero));
	}

	@Test
	public void saida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		ValorMonetario negativoDezReais = dezReais.negativo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Transacao transacao = new Saida(lucasBancoDoBrasil, dezReais);
		assertEquals(negativoDezReais, transacao.obterValorMonetario());
		assertEquals(negativoDezReais, transacao.contabilizar(zero));
	}

	@Test
	public void invalida() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		ValorMonetario zero = new ValorMonetario(Moeda.BRL);
		ValorMonetario negativoDezReais = dezReais.negativo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilTrindade = bancoDoBrasil.criarAgencia("Trindade");
		Conta lucasBancoDoBrasil = bancoDoBrasilTrindade.criarConta("Lucas");
		Transacao transacao = new TransacaoNaoRealizada(new Saida(lucasBancoDoBrasil, dezReais));
		assertEquals(negativoDezReais, transacao.obterValorMonetario());
		assertEquals(zero, transacao.contabilizar(zero));
	}

}
