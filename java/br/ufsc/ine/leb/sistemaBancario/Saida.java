package br.ufsc.ine.leb.sistemaBancario;

public class Saida extends Transacao {

	public Saida(Banco origem, Conta destino, Moeda moeda, Dinheiro quantia) {
		super(origem, destino, new ValorMonetario(moeda).subtrair(quantia));
	}

	@Override
	public EstadosDeTransacao obterEstado() {
		return EstadosDeTransacao.SUCESSO;
	}

}
