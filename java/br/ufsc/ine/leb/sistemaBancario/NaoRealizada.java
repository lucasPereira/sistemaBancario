package br.ufsc.ine.leb.sistemaBancario;

public class NaoRealizada implements Transacao {

	private Transacao transacao;
	private EstadosDeTransacao estado;

	public NaoRealizada(EstadosDeTransacao estado, Transacao transacao) {
		this.estado = estado;
		this.transacao = transacao;
	}

	@Override
	public EstadosDeTransacao obterEstado() {
		return estado;
	}

	@Override
	public ValorMonetario obterValorMonetario() {
		return transacao.obterValorMonetario();
	}

	@Override
	public ValorMonetario contabilizar(ValorMonetario saldo) {
		return saldo;
	}

}
