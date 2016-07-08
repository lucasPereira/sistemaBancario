package br.ufsc.ine.leb.sistemaBancario;

public interface Transacao {

	public ValorMonetario obterValorMonetario();

	public EstadosDeTransacao obterEstado();

	public ValorMonetario contabilizar(ValorMonetario positivoZeroReais);

}
