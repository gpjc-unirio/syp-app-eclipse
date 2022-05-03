package br.unirio.jdbpn.narrativas.util;

public enum JornadaDoHeroiEnum {
	mundoComum("Mundo Comum"), chamadoAAventura("Chamado � Aventura"), recusaDoChamado("Recusa do Chamado"),
	encontroComOMentor("Encontro com o Mentor"), travessiaDoPrimeiroLimiar("Travessia do Primeiro Limiar"),
	provasAliadosEInimigos("Provas, Aliados e Inimigos"), aproximacaoDaCavernaSecreta("Aproxima��o da Caverna Secreta"),
	provacao("Prova��o"), recompensaEmpunhandoAEspada("Recompensa (Empunhando a Espada)"),
	oCaminhoDeVolta("O Caminho de Volta"), ressurreicao("Ressurrei��o"), retornoComOElixir("Retorno com o Elixir");

	private final String nome;

	JornadaDoHeroiEnum(String estagio) {
		nome = estagio;
	}

	public String getNome() {
		return nome;
	}
}
