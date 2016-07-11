package br.ufsc.ine.leb.sistemaBancario;

import java.util.LinkedList;
import java.util.List;

public class SistemaBancario {

	private List<Banco> bancos;

	public SistemaBancario() {
		bancos = new LinkedList<>();
	}

	public Banco criarBanco(Moeda moeda) {
		Banco banco = new Banco(moeda);
		bancos.add(banco);
		return banco;
	}

	public Operacao depositar(Conta conta, Dinheiro quantia) {
		Transacao entrada = new Entrada(conta, quantia);
		EstadosDeOperacao estado = EstadosDeOperacao.SUCESSO;
		if (moedaInvalida(conta, quantia)) {
			entrada = new NaoRealizada(entrada);
			estado = EstadosDeOperacao.MOEDA_INVALIDA;
		}
		conta.adicionarTransacao(entrada);
		return new Operacao(estado, entrada);
	}

	public Operacao sacar(Conta conta, Dinheiro quantia) {
		ValorMonetario saldo = conta.calcularSaldo();
		Transacao saida = new Saida(conta, quantia);
		EstadosDeOperacao estado = EstadosDeOperacao.SUCESSO;
		if (saldo.negativo() || saldoFicaraNegativo(saldo, quantia)) {
			saida = new NaoRealizada(saida);
			estado = EstadosDeOperacao.SALDO_INSUFICIENTE;
		}
		if (moedaInvalida(conta, quantia)) {
			saida = new NaoRealizada(saida);
			estado = EstadosDeOperacao.MOEDA_INVALIDA;
		}
		conta.adicionarTransacao(saida);
		return new Operacao(estado, saida);
	}

	public Operacao transferir(Conta origem, Conta destino, Dinheiro quantia) {
		Transacao saida = new Saida(origem, quantia);
		Transacao entrada = new Entrada(destino, quantia);
		EstadosDeOperacao estado = EstadosDeOperacao.SUCESSO;
		if (moedaInvalida(origem, quantia) || moedaInvalida(destino, quantia)) {
			saida = new NaoRealizada(saida);
			entrada = new NaoRealizada(entrada);
			estado = EstadosDeOperacao.MOEDA_INVALIDA;
		}
		origem.adicionarTransacao(saida);
		destino.adicionarTransacao(entrada);
		return new Operacao(estado, saida, entrada);
	}
	
	private boolean saldoFicaraNegativo(ValorMonetario saldo, Dinheiro quantia) {
		return saldo.obterQuantia().obterQuantiaEmEscala() < quantia.obterQuantiaEmEscala();
	}

	private boolean moedaInvalida(Conta conta, Dinheiro quantia) {
		return !conta.obterAgencia().obterBanco().aceitaMoeda(quantia.obterMoeda());
	}

}
