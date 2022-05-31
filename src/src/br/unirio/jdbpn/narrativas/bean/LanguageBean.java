package br.unirio.jdbpn.narrativas.bean;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
//@ViewScoped
public class LanguageBean implements Serializable{

	private static final long serialVersionUID = 1L;	
	public static String Language = "en";
	
	private String titulo = "Appication to Support the SYP Method";
	private String menuArquivo = "My Projects";
	private String menuNovoProjeto = "New Project";
	private String menuSobre = "About";
	private String menuAjuda = "Help";
	private String menuAdministration = "Administration";
	private String menuNovoUsuario = "New User";
	private String menuAlterarUsuario = "Edit User";
	private String labelMeusProjetos = "My Projects";
	private String labelDescription = "Description";
	private String labelSenha = "Password";
	private String labelBtnLogin = "Log In";
	private String labelJoccon = "JoCCom - Complex Games Research Group";
	private String labelUnirio = "Federal University of State of Rio de Janeiro (UNIRIO)";
	private String labelPpgi = "Graduate Program in Informatics (PPGI)";
	private String labelBtnGerenciar = "Manage";
	private String labelManage = "Project Management";
	private String menuBPMN = "BPMN Diagram";
	private String menuPersonagens = "Characters";
	private String menuSentencas = "Sentences";
	private String menuCenas = "Scenes";
	private String menuAutores = "Project Authors";
	private String menuRoteiro = "Script";
	private String captionBPMN = "Importing BPMN Diagram";
	private String labelBtnSelecionar = "Select file...";
	private String labelEnviar = "Import";
	private String labelDica = "Tip";
	private String labelDicaBPMN = "Click above a BPMN element to view related sentences and scenes.";
	private String labelConfirmacao = "Confirmation";
	private String bpmnPerguntaConfirmacao = "Do you want to replace the BPMN diagram?";
	private String bpmnMsgConfirmacao = "All information that you recorded before will be lost.";
	private String labelSim = "Yes";
	private String labelNao = "No";
	private String bpmnDetalhesElemento = "Element details";
	private String bpmnSentencaCompleta = "Complete sentecen";
	private String labelTitulo = "Title";
	private String labelDescricaoCurta = "Short description";
	private String labelDescricao = "Description";
	private String labelPersonagens = "Characters";
	private String btnEditarCena = "Update scence";
	private String sentencaDica = "Click in a sentence to update it.";
	private String sentencaClmSentenca = "Sentença";
	private String sentencaClmBPMN = "BPMN Type";
	private String sentencaClmProxima = "Next";
	private String sentencaLblAjuste = "Sentence Adjustment";
	private String sentencaSujeito = "Subject";
	private String sentencaVerbo = "Verb";
	private String sentencaComplementos = "Complements";
	private String sentencaBtnAtualizar = "Update";
	private String sentencaLblCadastrada = "Recorded Sentences";
	private String authorLblAdicionar = "Add New Author";
	private String authorClmAutores = "Authors";
	private String authorBtnAdicionar = "Add";
	private String roteiroLabel = "Script";
	private String roteiroEscopo = "Type";
	private String roteiroBtnInk = "Create Ink Script";
	private String roteiroBtnTexto = "Create Text Script";
	private String roteiroConfiguracao = "Script Configuration";
	private String roteiroLblTexto = "Text";
	private String roteiroBtnImprimir = "Print";
	private String roteiroBtnPDF = "Export to PDF";
	private String menuIdioma = "Language";
	private String menuPortugues = "Portuguese";
	private String menuIngles = "English";

	
	
	public String getMenuIdioma() {
		return menuIdioma;
	}

	public void setMenuIdioma(String menuIdioma) {
		this.menuIdioma = menuIdioma;
	}

	public String getMenuPortugues() {
		return menuPortugues;
	}

	public void setMenuPortugues(String menuPortugues) {
		this.menuPortugues = menuPortugues;
	}

	public String getMenuIngles() {
		return menuIngles;
	}

	public void setMenuIngles(String menuIngles) {
		this.menuIngles = menuIngles;
	}

	public String getRoteiroLblTexto() {
		return roteiroLblTexto;
	}

	public void setRoteiroLblTexto(String roteiroLblTexto) {
		this.roteiroLblTexto = roteiroLblTexto;
	}

	public String getRoteiroBtnImprimir() {
		return roteiroBtnImprimir;
	}

	public void setRoteiroBtnImprimir(String roteiroBtnImprimir) {
		this.roteiroBtnImprimir = roteiroBtnImprimir;
	}

	public String getRoteiroBtnPDF() {
		return roteiroBtnPDF;
	}

	public void setRoteiroBtnPDF(String roteiroBtnPDF) {
		this.roteiroBtnPDF = roteiroBtnPDF;
	}

	public String getRoteiroConfiguracao() {
		return roteiroConfiguracao;
	}

	public void setRoteiroConfiguracao(String roteiroConfiguracao) {
		this.roteiroConfiguracao = roteiroConfiguracao;
	}

	public String getRoteiroBtnTexto() {
		return roteiroBtnTexto;
	}

	public void setRoteiroBtnTexto(String roteiroBtnTexto) {
		this.roteiroBtnTexto = roteiroBtnTexto;
	}

	public String getAuthorLblAdicionar() {
		return authorLblAdicionar;
	}

	public String getRoteiroLabel() {
		return roteiroLabel;
	}

	public void setRoteiroLabel(String roteiroLabel) {
		this.roteiroLabel = roteiroLabel;
	}

	public String getRoteiroEscopo() {
		return roteiroEscopo;
	}

	public void setRoteiroEscopo(String roteiroEscopo) {
		this.roteiroEscopo = roteiroEscopo;
	}

	public String getRoteiroBtnInk() {
		return roteiroBtnInk;
	}

	public void setRoteiroBtnInk(String roteiroBtnInk) {
		this.roteiroBtnInk = roteiroBtnInk;
	}

	public void setAuthorLblAdicionar(String authorLblAdicionar) {
		this.authorLblAdicionar = authorLblAdicionar;
	}

	public String getAuthorClmAutores() {
		return authorClmAutores;
	}

	public void setAuthorClmAutores(String authorClmAutores) {
		this.authorClmAutores = authorClmAutores;
	}

	public String getAuthorBtnAdicionar() {
		return authorBtnAdicionar;
	}

	public void setAuthorBtnAdicionar(String authorBtnAdicionar) {
		this.authorBtnAdicionar = authorBtnAdicionar;
	}

	public String getSentencaLblCadastrada() {
		return sentencaLblCadastrada;
	}

	public void setSentencaLblCadastrada(String sentencaLblCadastrada) {
		this.sentencaLblCadastrada = sentencaLblCadastrada;
	}

	public String getSentencaBtnAtualizar() {
		return sentencaBtnAtualizar;
	}

	public void setSentencaBtnAtualizar(String sentencaBtnAtualizar) {
		this.sentencaBtnAtualizar = sentencaBtnAtualizar;
	}

	public String getLabelConfirmacao() {
		return labelConfirmacao;
	}

	public String getSentencaDica() {
		return sentencaDica;
	}

	public void setSentencaDica(String sentencaDica) {
		this.sentencaDica = sentencaDica;
	}

	public String getSentencaClmSentenca() {
		return sentencaClmSentenca;
	}

	public void setSentencaClmSentenca(String sentencaClmSentenca) {
		this.sentencaClmSentenca = sentencaClmSentenca;
	}

	public String getSentencaClmBPMN() {
		return sentencaClmBPMN;
	}

	public void setSentencaClmBPMN(String sentencaClmBPMN) {
		this.sentencaClmBPMN = sentencaClmBPMN;
	}

	public String getSentencaClmProxima() {
		return sentencaClmProxima;
	}

	public void setSentencaClmProxima(String sentencaClmProxima) {
		this.sentencaClmProxima = sentencaClmProxima;
	}

	public String getSentencaLblAjuste() {
		return sentencaLblAjuste;
	}

	public void setSentencaLblAjuste(String sentencaLblAjuste) {
		this.sentencaLblAjuste = sentencaLblAjuste;
	}

	public String getSentencaSujeito() {
		return sentencaSujeito;
	}

	public void setSentencaSujeito(String sentencaSujeito) {
		this.sentencaSujeito = sentencaSujeito;
	}

	public String getSentencaVerbo() {
		return sentencaVerbo;
	}

	public void setSentencaVerbo(String sentencaVerbo) {
		this.sentencaVerbo = sentencaVerbo;
	}

	public String getSentencaComplementos() {
		return sentencaComplementos;
	}

	public void setSentencaComplementos(String sentencaComplementos) {
		this.sentencaComplementos = sentencaComplementos;
	}

	public void setLabelConfirmacao(String labelConfirmacao) {
		this.labelConfirmacao = labelConfirmacao;
	}

	public String getBpmnPerguntaConfirmacao() {
		return bpmnPerguntaConfirmacao;
	}

	public void setBpmnPerguntaConfirmacao(String bpmnPerguntaConfirmacao) {
		this.bpmnPerguntaConfirmacao = bpmnPerguntaConfirmacao;
	}

	public String getBpmnMsgConfirmacao() {
		return bpmnMsgConfirmacao;
	}

	public void setBpmnMsgConfirmacao(String bpmnMsgConfirmacao) {
		this.bpmnMsgConfirmacao = bpmnMsgConfirmacao;
	}

	public String getLabelSim() {
		return labelSim;
	}

	public void setLabelSim(String labelSim) {
		this.labelSim = labelSim;
	}

	public String getLabelNao() {
		return labelNao;
	}

	public void setLabelNao(String labelNao) {
		this.labelNao = labelNao;
	}

	public String getBpmnDetalhesElemento() {
		return bpmnDetalhesElemento;
	}

	public void setBpmnDetalhesElemento(String bpmnDetalhesElemento) {
		this.bpmnDetalhesElemento = bpmnDetalhesElemento;
	}

	public String getBpmnSentencaCompleta() {
		return bpmnSentencaCompleta;
	}

	public void setBpmnSentencaCompleta(String bpmnSentencaCompleta) {
		this.bpmnSentencaCompleta = bpmnSentencaCompleta;
	}

	public String getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(String labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	public String getLabelDescricaoCurta() {
		return labelDescricaoCurta;
	}

	public void setLabelDescricaoCurta(String labelDescricaoCurta) {
		this.labelDescricaoCurta = labelDescricaoCurta;
	}

	public String getLabelDescricao() {
		return labelDescricao;
	}

	public void setLabelDescricao(String labelDescricao) {
		this.labelDescricao = labelDescricao;
	}

	public String getLabelPersonagens() {
		return labelPersonagens;
	}

	public void setLabelPersonagens(String labelPersonagens) {
		this.labelPersonagens = labelPersonagens;
	}

	public String getBtnEditarCena() {
		return btnEditarCena;
	}

	public void setBtnEditarCena(String btnEditarCena) {
		this.btnEditarCena = btnEditarCena;
	}

	public String getLabelDica() {
		return labelDica;
	}

	public void setLabelDica(String labelDica) {
		this.labelDica = labelDica;
	}

	public String getLabelDicaBPMN() {
		return labelDicaBPMN;
	}

	public void setLabelDicaBPMN(String labelDicaBPMN) {
		this.labelDicaBPMN = labelDicaBPMN;
	}

	public String getCaptionBPMN() {
		return captionBPMN;
	}

	public void setCaptionBPMN(String captionBPMN) {
		this.captionBPMN = captionBPMN;
	}

	public String getLabelBtnSelecionar() {
		return labelBtnSelecionar;
	}

	public void setLabelBtnSelecionar(String labelBtnSelecionar) {
		this.labelBtnSelecionar = labelBtnSelecionar;
	}

	public String getLabelEnviar() {
		return labelEnviar;
	}

	public void setLabelEnviar(String labelEnviar) {
		this.labelEnviar = labelEnviar;
	}
	
	public String getLabelBtnGerenciar() {
		return labelBtnGerenciar;
	}

	public void setLabelBtnGerenciar(String labelBtnGerenciar) {
		this.labelBtnGerenciar = labelBtnGerenciar;
	}

	public String getLabelManage() {
		return labelManage;
	}

	public void setLabelManage(String labelManage) {
		this.labelManage = labelManage;
	}

	public String getMenuBPMN() {
		return menuBPMN;
	}

	public void setMenuBPMN(String menuBPMN) {
		this.menuBPMN = menuBPMN;
	}

	public String getMenuPersonagens() {
		return menuPersonagens;
	}

	public void setMenuPersonagens(String menuPersonagens) {
		this.menuPersonagens = menuPersonagens;
	}

	public String getMenuSentencas() {
		return menuSentencas;
	}

	public void setMenuSentencas(String menuSentencas) {
		this.menuSentencas = menuSentencas;
	}

	public String getMenuCenas() {
		return menuCenas;
	}

	public void setMenuCenas(String menuCenas) {
		this.menuCenas = menuCenas;
	}

	public String getMenuAutores() {
		return menuAutores;
	}

	public void setMenuAutores(String menuAutores) {
		this.menuAutores = menuAutores;
	}

	public String getMenuRoteiro() {
		return menuRoteiro;
	}

	public void setMenuRoteiro(String menuRoteiro) {
		this.menuRoteiro = menuRoteiro;
	}

	public String getLabelJoccon() {
		return labelJoccon;
	}

	public void setLabelJoccon(String labelJoccon) {
		this.labelJoccon = labelJoccon;
	}

	public String getLabelUnirio() {
		return labelUnirio;
	}

	public void setLabelUnirio(String labelUnirio) {
		this.labelUnirio = labelUnirio;
	}

	public String getLabelPpgi() {
		return labelPpgi;
	}

	public void setLabelPpgi(String labelPpgi) {
		this.labelPpgi = labelPpgi;
	}

	public String getLabelSenha() {
		return labelSenha;
	}

	public void setLabelSenha(String labelSenha) {
		this.labelSenha = labelSenha;
	}

	public String getLabelBtnLogin() {
		return labelBtnLogin;
	}

	public void setLabelBtnLogin(String labelBtnLogin) {
		this.labelBtnLogin = labelBtnLogin;
	}

	public LanguageBean() {
		
		//LanguageBean.Language = this.verificarIdioma();
		
		//if(LanguageBean.Language.equals("en")) {
			LoadEnglish();
		//}else if(LanguageBean.Language.equals("pt")) {
			//LoadPortuguese();
		//}
	}
	
	@SuppressWarnings("finally")
	private String verificarIdioma() {
		String lang = "pt";
		
		try {
			InputStream directorioFile = this.getClass().getClassLoader().getResourceAsStream("META-INF/language.txt");
						
			Scanner scaner = new Scanner(directorioFile);
			String fileContent = (scaner.hasNext() ? scaner.next() : "");
			
			lang = fileContent;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			return lang;
		}
	}
	
	private void LoadPortuguese() {
		this.titulo = "Aplicativo de Suporte ao Método SYP";		
		this.menuArquivo = "Meus Projetos";
		this.menuNovoProjeto = "Novo Projeto";
		this.menuSobre = "Sobre";
		this.menuAjuda = "Ajuda";
		this.menuAdministration = "Administração";
		this.menuNovoUsuario = "Novo Usuário";
		this.menuAlterarUsuario = "Alterar Usuário";
		this.labelMeusProjetos = "Meus Projetos";
		this.labelDescription = "Descrição";
		this.labelSenha = "Senha";
		this.labelBtnLogin = "Efeturar Login";
		this.labelJoccon = "JoCCom - Grupo de Pesquisa em Jogos Complexos";
		this.labelUnirio = "Universidade Federal do Estado do Rio de Janeiro (UNIRIO)";
		this.labelPpgi = "Programa de Pós Graduação em Informática (PPGI)";
		this.labelBtnGerenciar = "Gerenciar";
		this.labelManage = "Gerenciar Projeto";
		this.menuBPMN = "Diagrama BPMN";
		this.menuPersonagens = "Personagens";
		this.menuSentencas = "Sentenças";
		this.menuCenas = "Cenas";
		this.menuAutores = "Autores do Projeto";
		this.menuRoteiro = "Roteiro";
		this.captionBPMN = "Importar diagrama BPMN";
		this.labelBtnSelecionar = "Selecione...";
		this.labelEnviar = "Enviar";
		this.labelDica = "DICA";
		this.labelDicaBPMN = "Clique em um dos elementos do diagrama para obter a sentença e a cena associadas.";
		this.labelConfirmacao = "Confirmação";
		this.bpmnPerguntaConfirmacao = "Deseja substituir o diagrama BPMN?";
		this.bpmnMsgConfirmacao = "Toda a informação que você gravou antes sobre o BPMN será perdida.";
		this.labelSim = "Sim";
		this.labelNao = "Não";
		this.bpmnDetalhesElemento = "Detalhes do elemento";
		this.bpmnSentencaCompleta = "Sentença completa";
		this.labelTitulo = "Título";
		this.labelDescricaoCurta = "Breve descrição";
		this.labelDescricao = "Descrição";
		this.labelPersonagens = "Personagens";
		this.btnEditarCena = "Editar Cena";
		this.sentencaDica = "Clique na sentença abaixo para alterar.";
		this.sentencaClmSentenca = "Sentença";
		this.sentencaClmBPMN = "Tipo BPMN";
		this.sentencaClmProxima = "Próxima";
		this.sentencaLblAjuste = "Adjuste de Sentença";
		this.sentencaSujeito = "Sujeito";
		this.sentencaVerbo = "Verbo";
		this.sentencaComplementos = "Complementos";
		this.sentencaBtnAtualizar = "Atualizar";
		this.sentencaLblCadastrada = "Sentenças Cadastradas";
		this.authorLblAdicionar = "Adicionar Autor ao Projeto";
		this.authorClmAutores = "Autores Cadastrados";
		this.authorBtnAdicionar = "Adicionar";
		this.roteiroLabel = "Roteiro";
		this.roteiroEscopo = "Escopo";
		this.roteiroBtnInk = "Gerar Roteiro em Ink";
		this.roteiroBtnTexto = "Gerar Roteiro em Texto";
		this.roteiroConfiguracao = "Configuração do Roteiro";
		this.roteiroLblTexto = "Texto";
		this.roteiroBtnImprimir = "Imprimir Roteiro";
		this.roteiroBtnPDF = "Exportar como PDF";
		this.menuIdioma = "Idioma";
		this.menuPortugues = "Português";
		this.menuIngles = "Inglês";
	}
	
	private void LoadEnglish() {
		this.titulo = "Appication to Support the SYP Method";
		this.menuArquivo = "My Projects";
		this.menuNovoProjeto = "New Project";
		this.menuSobre = "About";
		this.menuAjuda = "Help";
		this.menuAdministration = "Administration";
		this.menuNovoUsuario = "New User";
		this.menuAlterarUsuario = "Edit User";
		this.labelMeusProjetos = "My Projects";
		this.labelDescription = "Description";
		this.labelSenha = "Password";
		this.labelBtnLogin = "Log In";
		this.labelJoccon = "JoCCom - Complex Games Research Group";
		this.labelUnirio = "Federal University of State of Rio de Janeiro (UNIRIO)";
		this.labelPpgi = "Graduate Program in Informatics (PPGI)";
		this.labelBtnGerenciar = "Manage";
		this.labelManage = "Project Management";
		this.menuBPMN = "BPMN Diagram";
		this.menuPersonagens = "Characters";
		this.menuSentencas = "Sentences";
		this.menuCenas = "Scenes";
		this.menuAutores = "Project Authors";
		this.menuRoteiro = "Script";
		this.captionBPMN = "Importing BPMN Diagram";
		this.labelBtnSelecionar = "Select file...";
		this.labelEnviar = "Import";
		this.labelDica = "TIP";
		this.labelDicaBPMN = "Click above a BPMN element to view related sentences and scenes.";
		this.labelConfirmacao = "Confirmation";
		this.bpmnPerguntaConfirmacao = "Do you want to replace the BPMN diagram?";
		this.bpmnMsgConfirmacao = "All information that you recorded before will be lost.";
		this.labelSim = "Yes";
		this.labelNao = "No";
		this.bpmnDetalhesElemento = "Element details";
		this.bpmnSentencaCompleta = "Complete sentece";
		this.labelTitulo = "Title";
		this.labelDescricaoCurta = "Short description";
		this.labelDescricao = "Description";
		this.labelPersonagens = "Characters";
		this.btnEditarCena = "Update scence";
		this.sentencaDica = "Click in a sentence to update it.";
		this.sentencaClmSentenca = "Sentence";
		this.sentencaClmBPMN = "BPMN Type";
		this.sentencaClmProxima = "Next";
		this.sentencaLblAjuste = "Sentence Adjustment";
		this.sentencaSujeito = "Subject";
		this.sentencaVerbo = "Verb";
		this.sentencaComplementos = "Complements";
		this.sentencaBtnAtualizar = "Update";
		this.sentencaLblCadastrada = "Recorded Sentences";
		this.authorLblAdicionar = "Add New Author";
		this.authorClmAutores = "Authors";
		this.authorBtnAdicionar = "Add";
		this.roteiroLabel = "Script";
		this.roteiroEscopo = "Type";
		this.roteiroBtnInk = "Create Ink Script";
		this.roteiroBtnTexto = "Create Text Script";
		this.roteiroConfiguracao = "Script Configuration";
		this.roteiroLblTexto = "Text";
		this.roteiroBtnImprimir = "Print";
		this.roteiroBtnPDF = "Export to PDF";
		this.menuIdioma = "Language";
		this.menuPortugues = "Portuguese";
		this.menuIngles = "English";
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getMenuArquivo() {
		return menuArquivo;
	}
	
	public void setMenuArquivo(String menuArquivo) {
		this.menuArquivo = menuArquivo;
	}
	
	public String getMenuNovoProjeto() {
		return menuNovoProjeto;
	}
	
	public void setMenuNovoProjeto(String menuNovoProjeto) {
		this.menuNovoProjeto = menuNovoProjeto;
	}
	
	public String getMenuAjuda() {
		return menuAjuda;
	}
	
	public void setMenuAjuda(String menuAjuda) {
		this.menuAjuda = menuAjuda;
	}
	
	public String getMenuSobre() {
		return menuSobre;
	}
	
	public void setMenuSobre(String menuSobre) {
		this.menuSobre = menuSobre;
	}
	
	public String getMenuAdministration() {
		return menuAdministration;
	}
	
	public void setMenuAdministration(String menuAdministration) {
		this.menuAdministration = menuAdministration;
	}
		
	public String getMenuNovoUsuario() {
		return menuNovoUsuario;
	}
	
	public void setMenuNovoUsuario(String menuNovoUsuario) {
		this.menuNovoUsuario = menuNovoUsuario;
	}
	
	public String getMenuAlterarUsuario() {
		return menuAlterarUsuario;
	}
	
	public void setMenuAlterarUsuario(String menuAlterarUsuario) {
		this.menuAlterarUsuario = menuAlterarUsuario;
	}
	
	public String getLabelMeusProjetos() {
		return labelMeusProjetos;
	}
	
	public void setLabelMeusProjetos(String labelMeusProjetos) {
		this.labelMeusProjetos = labelMeusProjetos;
	}
	
	public String getLabelDescription() {
		return labelDescription;
	}
	
	public void setLabelDescription(String labelDescription) {
		this.labelDescription = labelDescription;
	}
	
	public String mudarIdioma(int lang) {
		if(lang == 2) {
			LanguageBean.Language = "en";
			LoadEnglish();
		}else if(lang == 1) {
			LanguageBean.Language = "pt";
			LoadPortuguese();
		}
		
		return "inicio?faces-redirect=true";
	}
}
