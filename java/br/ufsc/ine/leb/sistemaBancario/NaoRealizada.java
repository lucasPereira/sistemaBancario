package br.ufsc.ine.leb.sistemaBancario;

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
