package br.ufsc.ine.leb.sistemaBancario;

public class ValorMonetario {

	private Moeda moeda;
	private Integer sinal;
	private Dinheiro quantia;

	public ValorMonetario(Moeda moeda) {
		this(moeda, 0);
	}

	private ValorMonetario(Moeda moeda, Integer valor) {
		this.moeda = moeda;
		this.sinal = valor >= 0 ? 1 : -1;
		this.quantia = new Dinheiro(moeda, 0, valor);
	}

	public Dinheiro obterQuantia() {
		return quantia;
	}

	public Boolean positivo() {
		return sinal >= 0;
	}

	public String formatado() {
		return positivo() ? formatarPositivo() : formatarNegativo();
	}

	private String formatarPositivo() {
		return String.format("+%s", quantia.formatado());
	}

	private String formatarNegativo() {
		return String.format("-%s", quantia.formatado());
	}

	public ValorMonetario somar(Dinheiro quantiaSomada) {
		Integer valor = quantia.obterQuantiaEmEscala() * sinal + quantiaSomada.obterQuantiaEmEscala();
		return new ValorMonetario(moeda, valor);
	}

	public ValorMonetario subtrair(Dinheiro quantiaSubtraida) {
		Integer valor = quantia.obterQuantiaEmEscala() * sinal - quantiaSubtraida.obterQuantiaEmEscala();
		return new ValorMonetario(moeda, valor);
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof ValorMonetario) {
			ValorMonetario outro = (ValorMonetario) objeto;
			return sinal.equals(outro.sinal) && quantia.equals(outro.quantia) && moeda.equals(outro.moeda);
		}
		return super.equals(objeto);
	}

	@Override
	public String toString() {
		return formatado();
	}
}
