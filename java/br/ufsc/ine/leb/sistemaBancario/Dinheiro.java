package br.ufsc.ine.leb.sistemaBancario;

public class Dinheiro {

	private Moeda moeda;
	private Integer inteiro;
	private Integer fracionado;

	public Dinheiro(Moeda moeda, Integer valorInteiro) {
		this(moeda, valorInteiro, 0);
	}

	public Dinheiro(Moeda moeda, Integer valorInteiro, Integer valorFracionado) {
		Integer restoFracionado = valorFracionado % 100;
		Integer excedenteFracionado = (valorFracionado - restoFracionado) / 100;
		this.moeda = moeda;
		this.inteiro = valorInteiro + excedenteFracionado;
		this.fracionado = restoFracionado;
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
			Boolean iguais = moeda.equals(outro.moeda) && inteiro.equals(outro.inteiro)	&& fracionado.equals(outro.fracionado);
			return zero() || iguais;
		}
		return super.equals(objeto);
	}

}
