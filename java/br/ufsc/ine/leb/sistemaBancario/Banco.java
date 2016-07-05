package br.ufsc.ine.leb.sistemaBancario;

import java.util.LinkedList;
import java.util.List;

public class Banco {

	private List<Conta> contas;
	private List<Agencia> agencias;

	public Banco(Integer taxaCobradaPorOperacao, Integer taxaDeJurosPagaAosCorrentistas) {
		contas = new LinkedList<>();
		agencias = new LinkedList<>();
	}

	public Agencia criarAgencia(String nome) {
		Agencia agencia = new Agencia(nome, agencias.size() + 1);
		agencias.add(agencia);
		return agencia;
	}

	public Conta criarConta(String titular, Agencia agencia) {
		Conta conta = new Conta(titular, contas.size() + 1, agencia);
		contas.add(conta);
		return conta;
	}

	public Transacao depositar(Conta conta, Integer valor) {
		return null;
	}

	public Transacao sacar(Conta conta, Integer valor) {
		return null;
	}

	public Transacao transferir(Conta origem, Conta destino, Integer valor) {
		return null;
	}

}
