package br.ufsc.ine.leb.sistemaBancario;

public abstract class Transacao {

	private ValorMonetario valor;

	public Transacao(Banco origem, Conta destino, ValorMonetario valor) {
		this.valor = valor;
	}

	public Transacao(Transacao transacao) {
		this.valor = transacao.valor;
	}

	public ValorMonetario obterValorMonetario() {
		return valor;
	}

	public abstract EstadosDeTransacao obterEstado();

}
