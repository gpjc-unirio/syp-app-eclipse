package br.unirio.jdbpn.narrativas.util;

import java.util.ArrayList;
import java.util.List;

public enum ArquetipoPersonagemEnum {

	ARQUETIPO_HEROI("Her�i"), ARQUETIPO_ARAUTO("Arauto"), ARQUETIPO_MENTOR("Mentor"), ARQUETIPO_GUARDIAO("Guardi�o"),
	ARQUETIPO_ALIVIO("Al�vio"), ARQUETIPO_CAMALEAO("Camale�o"), ARQUETIPO_VILAO("Vil�o");

	private final String arquetipo;

	ArquetipoPersonagemEnum(String arquetipo) {
		this.arquetipo = arquetipo;
	}

	public String getArquetipo() {
		return arquetipo;
	}

	public static List<String> getArquetipos() {
		List<String> arquetipos = new ArrayList<String>();
		ArquetipoPersonagemEnum[] arquetiposArray = ArquetipoPersonagemEnum.values();
		for (ArquetipoPersonagemEnum arquetipo : arquetiposArray) {
			arquetipos.add(arquetipo.getArquetipo());
		}
		return arquetipos;
	}

}
