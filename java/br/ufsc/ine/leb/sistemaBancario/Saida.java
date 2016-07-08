package br.ufsc.ine.leb.sistemaBancario;

public class Saida implements Transacao {

	private Dinheiro quantia;

	public Saida(Conta conta, Dinheiro quantia) {
		this.quantia = quantia;
	}

	@Override
	public EstadosDeTransacao obterEstado() {
		return EstadosDeTransacao.SUCESSO;
	}

	@Override
	public ValorMonetario obterValorMonetario() {
		return new ValorMonetario(quantia.obterMoeda()).subtrair(quantia);
	}

	@Override
	public ValorMonetario contabilizar(ValorMonetario saldo) {
		return saldo.subtrair(quantia);
	}

}
