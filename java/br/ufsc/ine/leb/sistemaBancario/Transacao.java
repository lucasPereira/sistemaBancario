package br.ufsc.ine.leb.sistemaBancario;

public class Transacao {

	private EstadosDeTransacao estado;

	public Transacao(EstadosDeTransacao estado, Banco origem, Conta destino, Dinheiro valor) {
		this.estado = estado;
	}

	public EstadosDeTransacao obterEstado() {
		return estado;
	}

	public ValorMonetario obterValorMonetario() {
		return null;
	}

}
