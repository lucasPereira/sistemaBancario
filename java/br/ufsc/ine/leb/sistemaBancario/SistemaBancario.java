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

	public Transacao depositar(Conta conta, Dinheiro quantia) {
		Entrada entrada = new Entrada(conta, quantia);
		conta.adicionarTransacao(entrada);
		return entrada;
	}

	public Transacao sacar(Conta conta, Integer valor) {
		return null;
	}

	public Transacao transferir(Conta origem, Conta destino, Integer valor) {
		return null;
	}

}
