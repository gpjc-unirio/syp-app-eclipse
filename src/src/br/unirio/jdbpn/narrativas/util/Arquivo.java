package br.unirio.jdbpn.narrativas.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Arquivo {

	@SuppressWarnings("unused")
	private String conteudoXml;
	private int projetoId;

	// Local para testes
	private static final String diretorioDosArquivosBpmn = "";

	public Arquivo(int projetoId) {
		this.projetoId = projetoId;
	}

	public String getConteudoXml() {
		File xmlFile = new File(diretorioDosArquivosBpmn + "/" + String.valueOf(projetoId) + ".bpmn");
		try {
			return new String(Files.readAllBytes(xmlFile.toPath()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return "";
		}
	}

	public void setConteudoXml(String conteudoXml) {
		this.conteudoXml = conteudoXml;
	}

	public int getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(int projetoId) {
		this.projetoId = projetoId;
	}

	public void upload(String nomeDoArquivo, InputStream arquivoCarregado) throws FileNotFoundException {

		String pasta = diretorioDosArquivosBpmn;

		String caminhoDoArquivo = pasta + "/" + nomeDoArquivo;
		File arquivo = new File(caminhoDoArquivo);
		FileOutputStream saida = new FileOutputStream(arquivo);
		copiar(arquivoCarregado, saida);

	}

	private void copiar(InputStream origem, OutputStream destino) {
		int byteLido = 0;
		byte[] tamanhoMaximo = new byte[1024 * 8];

		try {
			while ((byteLido = origem.read(tamanhoMaximo)) > 0) {
				destino.write(tamanhoMaximo, 0, byteLido);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
