package br.ufsc.ine.leb.sistemaBancario.testes;

import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Transacao;

public class Operacao {

	private EstadosDeOperacao estado;

	public Operacao(EstadosDeOperacao estado, Transacao... transacoes) {
		this.estado = estado;
	}

	public EstadosDeOperacao obterEstado() {
		return estado;
	}

}
