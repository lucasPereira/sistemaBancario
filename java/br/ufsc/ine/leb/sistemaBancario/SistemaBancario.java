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
		EstadosDeOperacao estado = EstadosDeOperacao.SUCESSO;
		Entrada entrada = new Entrada(conta, quantia);
		conta.adicionarTransacao(entrada);
		return new Operacao(estado, entrada);
	}

	public Operacao sacar(Conta conta, Dinheiro quantia) {
		EstadosDeOperacao estado = EstadosDeOperacao.SUCESSO;
		ValorMonetario saldo = conta.calcularSaldo();
		Transacao saida = new Saida(conta, quantia);
		if (!saldo.positivo() || saldo.obterQuantia().obterQuantiaEmEscala() < quantia.obterQuantiaEmEscala()) {
			saida = new NaoRealizada(saida);
			estado = EstadosDeOperacao.SALDO_INSUFICIENTE;
		}
		conta.adicionarTransacao(saida);
		return new Operacao(estado, saida);
	}

	public Operacao transferir(Conta origem, Conta destino, Dinheiro quantia) {
		Saida saida = new Saida(origem, quantia);
		Entrada entrada = new Entrada(destino, quantia);
		origem.adicionarTransacao(saida);
		destino.adicionarTransacao(entrada);
		return new Operacao(EstadosDeOperacao.SUCESSO, saida, entrada);
	}

}
