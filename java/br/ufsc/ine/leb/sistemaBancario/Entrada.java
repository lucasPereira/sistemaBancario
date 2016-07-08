package br.ufsc.ine.leb.sistemaBancario;

public class Entrada extends Transacao {

	public Entrada(Banco origem, Conta destino, Moeda moeda, Dinheiro quantia) {
		super(origem, destino, new ValorMonetario(moeda).somar(quantia));
	}

	@Override
	public EstadosDeTransacao obterEstado() {
		return EstadosDeTransacao.SUCESSO;
	}

}
