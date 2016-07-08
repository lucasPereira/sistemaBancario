package br.ufsc.ine.leb.sistemaBancario.testes;

import br.ufsc.ine.leb.sistemaBancario.EstadosDeTransacao;
import br.ufsc.ine.leb.sistemaBancario.Transacao;

public class NaoRealizada extends Transacao {

	private EstadosDeTransacao estado;

	public NaoRealizada(EstadosDeTransacao estado, Transacao transacao) {
		super(transacao);
		this.estado = estado;
	}

	@Override
	public EstadosDeTransacao obterEstado() {
		return estado;
	}

}
