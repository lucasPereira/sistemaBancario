package br.ufsc.ine.leb.sistemaBancario;

public class NaoRealizada implements Transacao {

	private Transacao transacao;

	public NaoRealizada(Transacao transacao) {
		this.transacao = transacao;
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
