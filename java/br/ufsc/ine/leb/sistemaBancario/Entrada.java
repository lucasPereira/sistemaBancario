package br.ufsc.ine.leb.sistemaBancario;

public class Entrada extends Transacao {

	public Entrada(Banco origem, Conta destino, Dinheiro valor) {
		super(EstadosDeTransacao.SUCESSO, origem, destino, valor);
	}

}
