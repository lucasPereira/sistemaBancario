package br.ufsc.ine.leb.sistemaBancario;

public class Banco {

	public Banco(Integer taxaCobradaPorOperacao, Integer taxaDeJurosPagaAosCorrentistas) {

	}

	public Agencia criarAgencia() {
		return new Agencia(0);
	}

	public Conta criarConta(String nomeDoTitular, Agencia agencia) {
		return new Conta(nomeDoTitular, 0, agencia);
	}

	public void depositar(Conta conta, Integer valor) {

	}

	public void sacar(Conta conta, Integer valor) {

	}

	public void transferir(Conta origem, Conta destino, Integer valor) {

	}

	public void pagarJurosAosCorrentistas() {

	}

}
