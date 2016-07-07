package br.ufsc.ine.leb.sistemaBancario;

public class Dinheiro {

	private static final Integer ESCALA = 100;

	private Moeda moeda;
	private Integer inteiro;
	private Integer fracionado;

	public Dinheiro(Moeda moeda, Integer inteiro, Integer fracionado) {
		this.moeda = moeda;
		this.inteiro = inteiro;
		this.fracionado = fracionado;
		normalizar();
	}

	private void normalizar() {
		Integer soma = obterQuantiaEmEscala();
		this.inteiro = (soma - (soma % ESCALA)) / ESCALA;
		this.fracionado = soma % ESCALA;
	}

	public Integer obterQuantiaEmEscala() {
		return Math.abs(inteiro) * ESCALA + Math.abs(fracionado);
	}

	public String formatado() {
		return zero() ? formatarSemMoeda() : formatarComMoeda();
	}

	private String formatarSemMoeda() {
		return String.format("%d,%02d", inteiro, fracionado);
	}

	private String formatarComMoeda() {
		return String.format("%d,%02d %s", inteiro, fracionado, moeda.toString());
	}

	private Boolean zero() {
		return inteiro == 0 && fracionado == 0;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Dinheiro) {
			Dinheiro outro = (Dinheiro) objeto;
			Boolean mesmaMoeda = moeda.equals(outro.moeda);
			Boolean mesmoValor = inteiro.equals(outro.inteiro) && fracionado.equals(outro.fracionado);
			return zero() || (mesmoValor && mesmaMoeda);
		}
		return super.equals(objeto);
	}

}
