package br.unirio.jdbpn.narrativas.util;

public enum EscopoEnum {
	Sentencas("Senten�as"), Cenas("Cenas");

	private final String descricao;

	EscopoEnum(String texto) {
		descricao = texto;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EscopoEnum getEscopo(String texto) {

		EscopoEnum escopoEscolhido = EscopoEnum.Sentencas;
		EscopoEnum[] escoposArray = EscopoEnum.values();

		for (EscopoEnum escopo : escoposArray) {
			if (escopo.getDescricao().equals(texto)) {
				escopoEscolhido = escopo;
			}
		}

		return escopoEscolhido;

	}

}
