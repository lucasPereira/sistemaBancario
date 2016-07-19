package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.inline;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteTransferencia {

	@Test
	public void transferir() throws Exception {
		Dinheiro dezReais = new Dinheiro(Moeda.BRL, 10, 0);
		Dinheiro quatroReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 4, 50);
		Dinheiro cincoReaisCinquentaCentavos = new Dinheiro(Moeda.BRL, 5, 50);
		ValorMonetario positivoQuatroReaisCinquentaCentavos = quatroReaisCinquentaCentavos.positivo();
		ValorMonetario positivoCincoReaisCinquentaCentavos = cincoReaisCinquentaCentavos.positivo();
		SistemaBancario sistemaBancario = new SistemaBancario();
		Banco bancoDoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		Agencia bancoDoBrasilCentro = bancoDoBrasil.criarAgencia("Centro");
		Conta lucasBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Lucas");
		Conta patriciaBancoDoBrasilCentro = bancoDoBrasilCentro.criarConta("Patrícia");
		sistemaBancario.depositar(lucasBancoDoBrasilCentro, dezReais);
		Operacao operacao = sistemaBancario.transferir(lucasBancoDoBrasilCentro, patriciaBancoDoBrasilCentro, quatroReaisCinquentaCentavos);
		assertEquals(EstadosDeOperacao.SUCESSO, operacao.obterEstado());
		assertEquals(positivoCincoReaisCinquentaCentavos, lucasBancoDoBrasilCentro.calcularSaldo());
		assertEquals(positivoQuatroReaisCinquentaCentavos, patriciaBancoDoBrasilCentro.calcularSaldo());
	}

}
