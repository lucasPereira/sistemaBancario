package br.ufsc.ine.leb.sistemaBancario;

public class Entrada implements Transacao {

	private Dinheiro quantia;

	public Entrada(Conta conta, Dinheiro quantia) {
		this.quantia = quantia;
	}

	@Override
	public EstadosDeTransacao obterEstado() {
		return EstadosDeTransacao.SUCESSO;
	}

	@Override
	public ValorMonetario obterValorMonetario() {
		return new ValorMonetario(quantia.obterMoeda()).somar(quantia);
	}

	@Override
	public ValorMonetario contabilizar(ValorMonetario saldo) {
		return saldo.somar(quantia);
	}

}
