package br.unirio.jdbpn.narrativas.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import br.unirio.jdbpn.narrativas.dao.CenaDao;
import br.unirio.jdbpn.narrativas.dao.DialogoDao;
import br.unirio.jdbpn.narrativas.dao.SentencaDao;
import br.unirio.jdbpn.narrativas.model.Cena;
import br.unirio.jdbpn.narrativas.model.Dialogo;
import br.unirio.jdbpn.narrativas.model.Projeto;
import br.unirio.jdbpn.narrativas.model.RelacaoSentencas;
import br.unirio.jdbpn.narrativas.model.Sentenca;

public abstract class InkConverter {

	// TODO: Alterar os nomes dos nós para prevenir repetições de complementos

	private static List<Sentenca> listaDeSentencasDoProjeto;
	private static List<Integer> listaDesentencasJaEscritas;
	private static int quantidadeDeGatewaysParalelos;
	private static List<String> textoFinal;
	private static int gatewaysParalelosEscritos;

	public static void gerarArquivo(Projeto projeto, BufferedWriter bufferedWriter, EscopoEnum escopo)
			throws IOException {

		if (escopo == EscopoEnum.Cenas
				&& (projeto.getStatus().equals(StatusProjetoEnum.STATUS_ROTEIRO_ELABORADO.getStatus())
						|| projeto.getStatus().equals(StatusProjetoEnum.STATUS_JORNADA_DO_HEROI.getStatus()))) {

			List<Cena> cenas = new CenaDao().buscarPorProjeto(projeto);

			for (Cena cena : cenas) {
				escreverCenaDaLista(cena, bufferedWriter, 0, (cena.getOrdem() == cenas.size()));
			}

			bufferedWriter.close();

		} else {

			listaDeSentencasDoProjeto = new SentencaDao().buscarPorProjeto(projeto);

			listaDesentencasJaEscritas = new ArrayList<Integer>();

			Sentenca primeiraSentenca = new Sentenca();

			quantidadeDeGatewaysParalelos = 0;

			for (Sentenca sentenca : listaDeSentencasDoProjeto) {
				if (primeiraSentenca.getId() == 0 && sentenca.getNumero() == 1) {
					primeiraSentenca = sentenca;
				}
				if (sentenca.getTipoDeElementoBPMN().equals(TipoDeElementoEnum.GATEWAY_PARALELO.getTipo())) {
					quantidadeDeGatewaysParalelos++;
				}
			}

			// Tratamento para os gateways paralelos (criação das variáveis)
			if (quantidadeDeGatewaysParalelos > 0) {
				textoFinal = new ArrayList<String>();
				for (int i = 1; i <= quantidadeDeGatewaysParalelos; i++) {
					bufferedWriter.write("VAR gtPar" + String.valueOf(i) + " = 0");
					bufferedWriter.newLine();
					bufferedWriter.newLine();
				}
			}

			int qtdDeIndentacao = 0;
			int rota = 0;
			gatewaysParalelosEscritos = 0;

			escreverSentencaDaListaB(primeiraSentenca, bufferedWriter, qtdDeIndentacao, rota);

			bufferedWriter.close();

		}

	}

	private static void escreverSentencaDaListaB(Sentenca sentenca, BufferedWriter bufferedWriter, int qtdDeIndentacao,
			int rota) {

		try {

			// Verificar primeiro se a sentença já foi escrita
			if (sentencaJaFoiEscrita(sentenca.getId())) {

				bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> " + removerAcentos(sentenca.getComplementos()));
				bufferedWriter.newLine();

			} else {

				listaDesentencasJaEscritas.add(sentenca.getId());

				List<RelacaoSentencas> mapeamentoDasProximasSentencas = new SentencaDao()
						.buscarProximasSentencas(sentenca);

				if (!sentenca.getTipoDeElementoBPMN().contains("Gateway")
						&& mapeamentoDasProximasSentencas.size() <= 1) {

					if (sentenca.isTemLoop()) {
						bufferedWriter.newLine();
						bufferedWriter.write(
								indentacao(qtdDeIndentacao) + "-> " + removerAcentos(sentenca.getComplementos()));
						bufferedWriter.newLine();

						bufferedWriter.write(
								indentacao(qtdDeIndentacao) + "=== " + removerAcentos(sentenca.getComplementos()));
						bufferedWriter.newLine();
					}

					bufferedWriter.write(indentacao(qtdDeIndentacao) + sentenca.getSentencaCompleta());
					bufferedWriter.newLine();

					if (sentenca.getTipoDeElementoBPMN().equals(TipoDeElementoEnum.EVENTO_FINAL.getTipo())) {

						bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> END");
						bufferedWriter.newLine();

					} else {

						if (sentenca.isTerminoDeParalelismo()) {

							for (String texto : textoFinal) {
								bufferedWriter.write(texto);
								bufferedWriter.newLine();
							}
							bufferedWriter.write(
									"-> " + removerAcentos(indentacao(qtdDeIndentacao) + mapeamentoDasProximasSentencas
											.iterator().next().getSentencaFilha().getComplementos()));
							bufferedWriter.newLine();

						} else {

							escreverSentencaDaListaB(
									mapeamentoDasProximasSentencas.iterator().next().getSentencaFilha(), bufferedWriter,
									qtdDeIndentacao, rota);

						}

					}

				} else {

					if (sentenca.getTipoDeElementoBPMN().equals(TipoDeElementoEnum.GATEWAY_EXCLUSIVO.getTipo())
							|| (!sentenca.getTipoDeElementoBPMN().contains("Gateway")
									&& mapeamentoDasProximasSentencas.size() > 1)) {

						if (sentenca.isTemLoop()) {
							bufferedWriter.newLine();
							bufferedWriter.write(
									indentacao(qtdDeIndentacao) + "-> " + removerAcentos(sentenca.getComplementos()));
							bufferedWriter.newLine();

							bufferedWriter.write(
									indentacao(qtdDeIndentacao) + "=== " + removerAcentos(sentenca.getComplementos()));
							bufferedWriter.newLine();
						}

						bufferedWriter.write(indentacao(qtdDeIndentacao) + sentenca.getSentencaCompleta());
						bufferedWriter.newLine();

						qtdDeIndentacao++;

						for (RelacaoSentencas relacaoSentencas : mapeamentoDasProximasSentencas) {
							bufferedWriter.write(indentacao(qtdDeIndentacao) + "+ [");
							if (relacaoSentencas.getNomeOpcao() == null || relacaoSentencas.getNomeOpcao().isBlank()) {
								rota++;
								bufferedWriter.write("Rota" + String.valueOf(rota));
							} else {
								bufferedWriter.write(relacaoSentencas.getNomeOpcao());
							}
							bufferedWriter.write("]");
							bufferedWriter.newLine();
							qtdDeIndentacao++;

							Sentenca proximaSentenca = relacaoSentencas.getSentencaFilha();

							bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> "
									+ removerAcentos(proximaSentenca.getComplementos()));
							bufferedWriter.newLine();

							qtdDeIndentacao--;
						}
						qtdDeIndentacao--;

						for (RelacaoSentencas relacaoSentencas : mapeamentoDasProximasSentencas) {
							bufferedWriter.newLine();

							Sentenca proximaSentenca = relacaoSentencas.getSentencaFilha();

							escreverProximaSentenca(bufferedWriter, qtdDeIndentacao, rota, proximaSentenca);
						}

					}

					if (sentenca.getTipoDeElementoBPMN().equals(TipoDeElementoEnum.GATEWAY_PARALELO.getTipo())) {

						rota++;
						gatewaysParalelosEscritos++;

						bufferedWriter.write(
								indentacao(qtdDeIndentacao) + "~ gtPar" + String.valueOf(gatewaysParalelosEscritos)
										+ " = gtPar" + String.valueOf(gatewaysParalelosEscritos) + " + 1");
						bufferedWriter.newLine();

						String rotaIniciada = "Rota" + String.valueOf(rota) + "Iniciada";
						String rotaFinalizada = "Rota" + String.valueOf(rota) + "Finalizada";

						bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> " + rotaIniciada);
						bufferedWriter.newLine();
						bufferedWriter.write(indentacao(qtdDeIndentacao) + "=== " + rotaIniciada);
						bufferedWriter.newLine();

						qtdDeIndentacao++;

						Sentenca proximaSentenca = new Sentenca();

						for (RelacaoSentencas relacaoSentencas : mapeamentoDasProximasSentencas) {
							bufferedWriter.write(indentacao(qtdDeIndentacao) + "* [");
							bufferedWriter.write(relacaoSentencas.getNomeOpcao());
							bufferedWriter.write("]");
							bufferedWriter.newLine();
							qtdDeIndentacao++;

							proximaSentenca = relacaoSentencas.getSentencaFilha();

							bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> "
									+ removerAcentos(proximaSentenca.getComplementos()));
							bufferedWriter.newLine();

							qtdDeIndentacao--;
						}
						qtdDeIndentacao--;

						bufferedWriter.write(indentacao(qtdDeIndentacao) + "* -> " + rotaFinalizada);
						bufferedWriter.newLine();

						bufferedWriter.write(indentacao(qtdDeIndentacao) + "=== " + rotaFinalizada);
						bufferedWriter.newLine();

						bufferedWriter.write(
								indentacao(qtdDeIndentacao) + "~ gtPar" + String.valueOf(gatewaysParalelosEscritos)
										+ " = gtPar" + String.valueOf(gatewaysParalelosEscritos) + " - 1");
						bufferedWriter.newLine();

						textoFinal.add("{ gtPar" + String.valueOf(gatewaysParalelosEscritos) + " > 0:");
						textoFinal.add(indentacao(1) + "-> " + rotaIniciada);
						textoFinal.add("}");

						Sentenca sequenciaDoParalelismo = getSequenciaDoParalelismo(proximaSentenca);

						if (sequenciaDoParalelismo != null && sequenciaDoParalelismo.getId() > 0) {

							bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> "
									+ removerAcentos(sequenciaDoParalelismo.getComplementos()));
							bufferedWriter.newLine();

							escreverProximaSentenca(bufferedWriter, qtdDeIndentacao, rota, sequenciaDoParalelismo);

						} else {
							bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> Fim");
							bufferedWriter.newLine();
						}

						for (RelacaoSentencas relacaoSentencas : mapeamentoDasProximasSentencas) {

							bufferedWriter.newLine();

							proximaSentenca = relacaoSentencas.getSentencaFilha();

							escreverProximaSentenca(bufferedWriter, qtdDeIndentacao, rota, proximaSentenca);

						}

					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Sentenca getSequenciaDoParalelismo(Sentenca ultimaSentencaDoRamo) {
		boolean chegouNoTerminoDoParalelismo = false;
		Sentenca sequenciaDoParalelismo = new Sentenca();

		while (!chegouNoTerminoDoParalelismo) {

			if (ultimaSentencaDoRamo.isTerminoDeParalelismo()) {
				chegouNoTerminoDoParalelismo = true;
				sequenciaDoParalelismo = ultimaSentencaDoRamo.getSentencasFilhas().iterator().next().getSentencaFilha();
			} else {
				if (ultimaSentencaDoRamo.getTipoDeElementoBPMN().equals(TipoDeElementoEnum.EVENTO_FINAL.getTipo())) {
					chegouNoTerminoDoParalelismo = true;
				} else {

					List<RelacaoSentencas> proximasSentencas = ultimaSentencaDoRamo.getSentencasFilhas();

					if (proximasSentencas.size() > 1) {
						for (RelacaoSentencas relacaoSentencas : proximasSentencas) {
							ultimaSentencaDoRamo = getSequenciaDoParalelismo(relacaoSentencas.getSentencaFilha());
						}
					} else {
						ultimaSentencaDoRamo = ultimaSentencaDoRamo.getSentencasFilhas().iterator().next()
								.getSentencaFilha();
					}

				}
			}

		}

		return sequenciaDoParalelismo;
	}

	public static void escreverProximaSentenca(BufferedWriter bufferedWriter, int qtdDeIndentacao, int rota,
			Sentenca proximaSentenca) throws IOException {
		if (!sentencaJaFoiEscrita(proximaSentenca.getId())) {

			if (!proximaSentenca.isTemLoop()) {
				bufferedWriter.newLine();
				bufferedWriter.write(
						indentacao(qtdDeIndentacao) + "=== " + removerAcentos(proximaSentenca.getComplementos()));
				bufferedWriter.newLine();
			}
			escreverSentencaDaListaB(proximaSentenca, bufferedWriter, qtdDeIndentacao, rota);

		}
	}

	private static void escreverCenaDaLista(Cena cena, BufferedWriter bufferedWriter, int qtdDeIndentacao,
			boolean ultimaCena) {
		try {
			bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> " + removerAcentos(cena.getTitulo()));
			bufferedWriter.newLine();

			bufferedWriter.write(indentacao(qtdDeIndentacao) + "=== " + removerAcentos(cena.getTitulo()));
			bufferedWriter.newLine();

			qtdDeIndentacao++;

			// Local da cena
			if (cena.getLocal() != null && cena.getLocal().length() > 1) {
				bufferedWriter.write(indentacao(qtdDeIndentacao) + "Local: " + cena.getLocal());
				bufferedWriter.newLine();
			}

			// Tempo da cena
			if (cena.getTempo() != null && cena.getTempo().length() > 1) {
				bufferedWriter.write(indentacao(qtdDeIndentacao) + "Tempo: " + cena.getTempo());
				bufferedWriter.newLine();
			}

			// Descrição breve da cena
			if (cena.getDescricaoBreve() != null && cena.getDescricaoBreve().length() > 1) {
				bufferedWriter.write(indentacao(qtdDeIndentacao) + cena.getDescricaoBreve());
				bufferedWriter.newLine();
			}

			// Diálogos da cena
			List<Dialogo> dialogos = new DialogoDao().buscarPorCena(cena);
			if (dialogos != null && dialogos.size() > 0) {
				for (Dialogo dialogo : dialogos) {
					if (dialogo.getIntroducao() != null && dialogo.getIntroducao().length() > 1) {
						bufferedWriter.write(indentacao(qtdDeIndentacao) + dialogo.getIntroducao());
						bufferedWriter.newLine();
					}

					bufferedWriter.write(indentacao(qtdDeIndentacao) + "[" + dialogo.getPersonagem().getNome() + "]");
					bufferedWriter.newLine();

					if (dialogo.getObservacoes() != null && dialogo.getObservacoes().length() > 1) {
						bufferedWriter.write(indentacao(qtdDeIndentacao) + "(" + dialogo.getObservacoes() + ")");
						bufferedWriter.newLine();
					}

					bufferedWriter.write(indentacao(qtdDeIndentacao) + "_ " + dialogo.getDiscurso());
					bufferedWriter.newLine();
				}
			}

			// Se for gateway exclusivo
			if (cena.getSentenca() != null && cena.getSentenca().getTipoDeElementoBPMN()
					.equals(TipoDeElementoEnum.GATEWAY_EXCLUSIVO.getTipo())) {

				List<RelacaoSentencas> relacoes = cena.getSentenca().getSentencasFilhas();

				for (RelacaoSentencas relacao : relacoes) {
					bufferedWriter.write(indentacao(qtdDeIndentacao) + "+ [" + relacao.getNomeOpcao() + "]");
					bufferedWriter.newLine();

					qtdDeIndentacao++;
					bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> "
							+ removerAcentos(relacao.getSentencaFilha().getCena().getTitulo()));
					bufferedWriter.newLine();
					qtdDeIndentacao--;
				}

			} else

			// Se for gateway paralelo
			if (cena.getSentenca() != null && cena.getSentenca().getTipoDeElementoBPMN()
					.equals(TipoDeElementoEnum.GATEWAY_PARALELO.getTipo())) {

				List<RelacaoSentencas> relacoes = cena.getSentenca().getSentencasFilhas();

				String rotaIniciada = "RotaCena" + String.valueOf(cena.getOrdem()) + "Iniciada";
				String rotaFinalizada = "RotaCena" + String.valueOf(cena.getOrdem()) + "Finalizada";

				bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> " + rotaIniciada);
				bufferedWriter.newLine();
				bufferedWriter.write(indentacao(qtdDeIndentacao) + "=== " + rotaIniciada);
				bufferedWriter.newLine();

				qtdDeIndentacao++;

				for (RelacaoSentencas relacao : relacoes) {
					bufferedWriter.write(indentacao(qtdDeIndentacao) + "* [" + relacao.getNomeOpcao() + "]");
					bufferedWriter.newLine();

					qtdDeIndentacao++;
					bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> "
							+ removerAcentos(relacao.getSentencaFilha().getCena().getTitulo()));
					bufferedWriter.newLine();
					qtdDeIndentacao--;

					bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> " + rotaIniciada);
					bufferedWriter.newLine();
				}

				qtdDeIndentacao--;

				bufferedWriter.write(indentacao(qtdDeIndentacao) + "* -> " + rotaFinalizada);
				bufferedWriter.newLine();
				qtdDeIndentacao++;

				bufferedWriter.write(indentacao(qtdDeIndentacao) + "=== " + rotaFinalizada);
				bufferedWriter.newLine();
				qtdDeIndentacao--;

			} else

			// Próxima cena, se houver

			if (!ultimaCena) {
				bufferedWriter.write(indentacao(qtdDeIndentacao) + "* [Próxima Cena]");
				bufferedWriter.newLine();
				qtdDeIndentacao--;
			}

			// Se não houver
			else {
				qtdDeIndentacao--;
				bufferedWriter.write(indentacao(qtdDeIndentacao) + "-> END");
				bufferedWriter.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean sentencaJaFoiEscrita(Integer idDaSentenca) {
		return listaDesentencasJaEscritas.contains(idDaSentenca);
	}

	private static String indentacao(int n) {
		String textoDeRetorno = "";

		if (n > 0) {
			for (int i = 0; i < n; i++) {
				textoDeRetorno = textoDeRetorno + "    ";
			}
		}

		return textoDeRetorno;
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str.replace(".", ""), Normalizer.Form.NFD).replaceAll("[^a-zA-Z1-9 ]", "")
				.replace(" ", "_");
	}

}
