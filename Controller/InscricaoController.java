package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Interface.ICRUD;
import View.ErroTela;
import model.Inscricao;
import model.Professor;
import modeloLista.ListaGenerica;
import model.Disciplina;

public class InscricaoController implements ActionListener, ICRUD {

	private JTextField tfCPFInscricaoCriar;
	private JTextField tfCodDisciplinaInscricaoCriar;
	private JTextField tfCodProcessoInscricaoCriar;

	private JTextField tfCodProcessoBuscarInscricaoAtualizar;
	private JTextField tfCPFInscricaoAtualizar;
	private JTextField tfCodDisciplinaInscricaoAtualizar;
	private JTextArea taInscricaoListaAtualizar;

	private JTextArea taInscricaoListaLer;

	private JTextField tfCodProcessoInscricaoBuscarDeletar;
	private JTextArea taInscricaoListaDeletar;

	public InscricaoController(JTextField tfCPFInscricaoCriar, JTextField tfCodDisciplinaInscricaoCriar,
			JTextField tfCodProcessoInscricaoCriar, JTextField tfCodProcessoBuscarInscricaoAtualizar,
			JTextField tfCPFInscricaoAtualizar, JTextField tfCodDisciplinaInscricaoAtualizar,
			JTextArea taInscricaoListaAtualizar, JTextArea taInscricaoListaLer,
			JTextField tfCodProcessoInscricaoBuscarDeletar, JTextArea taInscricaoListaDeletar) {
		super();
		this.tfCPFInscricaoCriar = tfCPFInscricaoCriar;
		this.tfCodDisciplinaInscricaoCriar = tfCodDisciplinaInscricaoCriar;
		this.tfCodProcessoInscricaoCriar = tfCodProcessoInscricaoCriar;
		this.tfCodProcessoBuscarInscricaoAtualizar = tfCodProcessoBuscarInscricaoAtualizar;
		this.tfCPFInscricaoAtualizar = tfCPFInscricaoAtualizar;
		this.tfCodDisciplinaInscricaoAtualizar = tfCodDisciplinaInscricaoAtualizar;
		this.taInscricaoListaAtualizar = taInscricaoListaAtualizar;
		this.taInscricaoListaLer = taInscricaoListaLer;
		this.tfCodProcessoInscricaoBuscarDeletar = tfCodProcessoInscricaoBuscarDeletar;
		this.taInscricaoListaDeletar = taInscricaoListaDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();
	    ErroTela tela = new ErroTela();

	    if (cmd.equals("Criar")) {
	        try {
	            Criar();
	        } catch (IOException e1) {
	            tela.mostrarErros("Erro ao criar inscrição.");
	        } catch (NumberFormatException e1) {
	            tela.mostrarErros("Dados numéricos inválidos ao criar inscrição.");
	        }
	    }

	    if (cmd.equals("Deletar")) {
	        try {
	            Deletar();
	        } catch (IOException e1) {
	            tela.mostrarErros("Erro de leitura ao deletar inscrição.");
	        } catch (Exception e1) {
	            tela.mostrarErros("Erro ao deletar inscrição.");
	        }
	    }

	    if (cmd.equals("Buscar_AT")) {
	        try {
	            BuscarAtualizar();
	        } catch (IOException e1) {
	            tela.mostrarErros("Erro ao buscar inscrição para atualizar.");
	        }
	    }

	    if (cmd.equals("Buscar_DL")) {
	        try {
	            BuscarDeletar();
	        } catch (IOException e1) {
	            tela.mostrarErros("Erro ao buscar inscrição para deletar.");
	        }
	    }

	    if (cmd.equals("Atualizar")) {
	        try {
	            Atualizar();
	        } catch (IOException e1) {
	            tela.mostrarErros("Erro de leitura ao atualizar inscrição.");
	        } catch (Exception e1) {
	            tela.mostrarErros("Erro ao atualizar inscrição.");
	        }
	    }

	    if (cmd.equals("Ler")) {
	        try {
	            Ler();
	        } catch (IOException e1) {
	            tela.mostrarErros("Erro de leitura ao carregar lista de inscrições.");
	        } catch (Exception e1) {
	            tela.mostrarErros("Erro ao carregar lista de inscrições.");
	        }
	    }
	}

	@Override
	public void Criar() throws IOException {
		Inscricao inscricao = new Inscricao();
		Professor professor = new Professor();
		Disciplina disciplina = new Disciplina();

		professor.setCPFProfessor(Double.parseDouble(tfCPFInscricaoCriar.getText()));
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodDisciplinaInscricaoCriar.getText()));
		inscricao.setCodigoProcesso(Integer.parseInt(tfCodProcessoInscricaoCriar.getText()));

		StringBuffer buffer = new StringBuffer();
		buffer.append(professor.getCPFProfessor() + ";");
		buffer.append(disciplina.getCodigoDisciplina() + ";");
		buffer.append(inscricao);

		CriarInscricao(buffer.toString());
		tfCPFInscricaoCriar.setText("");
		tfCodDisciplinaInscricaoCriar.setText("");
		tfCodProcessoInscricaoCriar.setText("");
	}

	public void CriarInscricao(String csvInscricao) throws IOException {

		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "inscricoes.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvInscricao + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	private void BuscarDeletar() throws IOException {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodigoProcesso(Integer.parseInt(tfCodProcessoInscricaoBuscarDeletar.getText()));

		String linhacsv = buscaInscricao(inscricao);
		if (linhacsv != null) {
			String[] inscricaoCompleta = linhacsv.split(";");
			tfCodProcessoInscricaoBuscarDeletar.setText("");
			taInscricaoListaDeletar.setText("CPF: " + inscricaoCompleta[0] + " - Cod Disciplina: "
					+ inscricaoCompleta[1] + "  - Cod Processo: " + inscricaoCompleta[2]);
		} else {
			taInscricaoListaDeletar.setText("Cliente nao encontrado");
		}
	}

	@Override
	public void Deletar() throws IOException, Exception {
		double CodProcesso = Double.parseDouble(tfCodProcessoInscricaoBuscarDeletar.getText());

		DeletarInscricao(CodProcesso);
		tfCodProcessoInscricaoBuscarDeletar.setText("");
		taInscricaoListaAtualizar.setText("Incrição deletada com sucesso");
		
	}

	private void DeletarInscricao(Double CodProcesso) throws Exception {

		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "inscricoes.csv");
		ListaGenerica<String> lista = new ListaGenerica<>();

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String linha = buffer.readLine();
			int verifica = 0;
			while (linha != null) {
				String[] vetLinha = linha.split(";");

				if (verifica == 0 && (Double.parseDouble(vetLinha[2]) == CodProcesso)) {
					verifica++;
				} else {
					lista.addLast(linha);
				}
				linha = buffer.readLine();
			}
			fis.close();
			isr.close();
			buffer.close();

			FileWriter fw = new FileWriter(arq);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush();
			pw.close();
			fw.close();

			int tamanhoLista = lista.size();

			for (int i = 0; i < tamanhoLista; i++) {
				String inscricao = lista.get(i);
				FileWriter fw1 = new FileWriter(arq, existe);
				PrintWriter pw1 = new PrintWriter(fw1);
				pw1.write(inscricao + "\r\n");
				pw1.flush();
				pw1.close();
				fw1.close();
			}
		}
	}
	
	public static void DeletarInscricoesPorDisciplina(int codigoDisciplina) throws Exception {
	    String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
	    File arq = new File(path, "inscricao.csv");
	    ListaGenerica<String> lista = new ListaGenerica<>();

	    if (arq.exists() && arq.isFile()) {
	        FileInputStream fis = new FileInputStream(arq);
	        InputStreamReader isr = new InputStreamReader(fis);
	        BufferedReader buffer = new BufferedReader(isr);
	        String linha = buffer.readLine();

	        while (linha != null) {
	            String[] vetLinha = linha.split(";");

	            if (Integer.parseInt(vetLinha[1]) != codigoDisciplina) {
	                lista.addLast(linha);
	            }

	            linha = buffer.readLine();
	        }

	        buffer.close();
	        isr.close();
	        fis.close();

	        FileWriter fw = new FileWriter(arq);
	        PrintWriter pw = new PrintWriter(fw);

	        for (int i = 0; i < lista.size(); i++) {
	            pw.write(lista.get(i) + "\r\n");
	        }

	        pw.flush();
	        pw.close();
	        fw.close();
	    }
	}

	private void BuscarAtualizar() throws IOException {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodigoProcesso(Integer.parseInt(tfCodProcessoBuscarInscricaoAtualizar.getText()));

		String linhacsv = buscaInscricao(inscricao);
		if (linhacsv != null) {
			String[] inscricaoCompleta = linhacsv.split(";");
			tfCodProcessoBuscarInscricaoAtualizar.setText("");
			taInscricaoListaAtualizar.setText("CPF: " + inscricaoCompleta[0] + " - Cod Disciplina: "
					+ inscricaoCompleta[1] + "  - Cod Processo: " + inscricaoCompleta[2]);
		} else {
			taInscricaoListaAtualizar.setText("Inscrição não encontrada");
			
		}
	}

	@Override
	public void Atualizar() throws IOException, Exception {
		Inscricao inscricao = new Inscricao();
		Professor professor = new Professor();
		Disciplina disciplina = new Disciplina();

		professor.setCPFProfessor(Double.parseDouble(tfCPFInscricaoAtualizar.getText()));
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodDisciplinaInscricaoAtualizar.getText()));
		inscricao.setCodigoProcesso(Integer.parseInt(tfCodProcessoBuscarInscricaoAtualizar.getText()));

		StringBuffer buffer = new StringBuffer();
		buffer.append(professor.getCPFProfessor() + ";");
		buffer.append(disciplina.getCodigoDisciplina() + ";");
		buffer.append(inscricao + ";");

		AtualizarInscricao(buffer.toString());
		
		tfCPFInscricaoAtualizar.setText("");
		tfCodDisciplinaInscricaoAtualizar.setText("");
		taInscricaoListaAtualizar.setText("Inscrição atualizada com Sucesso");

	}

	private void AtualizarInscricao(String novaInscricao) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "inscricoes.csv");
		ListaGenerica<String> lista = new ListaGenerica<>();

		String[] vetInscricao = novaInscricao.split(";");
		double CodProcesso = Double.parseDouble(vetInscricao[2]);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String linha = buffer.readLine();
			int verifica = 0;
			while (linha != null) {
				String[] vetLinha = linha.split(";");

				if (verifica == 0 && (Double.parseDouble(vetLinha[2]) == CodProcesso)) {
					verifica++;
					linha = novaInscricao;
				}
				lista.addLast(linha);
				linha = buffer.readLine();
			}
			fis.close();
			isr.close();
			buffer.close();

			FileWriter fw = new FileWriter(arq);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush();
			pw.close();
			fw.close();

			int tamanhoLista = lista.size();

			for (int i = 0; i < tamanhoLista; i++) {
				String inscricao = lista.get(i);
				FileWriter fw1 = new FileWriter(arq, existe);
				PrintWriter pw1 = new PrintWriter(fw1);
				pw1.write(inscricao + "\r\n");
				pw1.flush();
				pw1.close();
				fw1.close();
			}
		}
	}

	@Override
	public void Ler() throws IOException, Exception {
		String pathProfessor = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arqProfessor = new File(pathProfessor, "professor.csv");
		
		taInscricaoListaAtualizar.setText("");

		ListaGenerica<Professor> listaAuxiliar = new ListaGenerica<>();
		ListaGenerica<Professor> lista = new ListaGenerica<>();

		if (arqProfessor.exists() && arqProfessor.isFile()) {
			FileInputStream fis = new FileInputStream(arqProfessor);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				Professor professor = new Professor();
				professor.setCPFProfessor(Double.parseDouble(vetLinha[0]));
				professor.setNomeProfessor(vetLinha[1]);
				professor.setAreaProfessor(vetLinha[2]);
				professor.setPontosProfessor(Integer.parseInt(vetLinha[3]));
				listaAuxiliar.addLast(professor);
				lista.addLast(professor);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		int tamanhoLista = lista.size();

		lista = bubbleSort(lista);

		String pathInscricoes = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arqInscricoes = new File(pathInscricoes, "inscricoes.csv");
		if (arqInscricoes.exists() && arqInscricoes.isFile()) {
			
			for (int i = 0; i < tamanhoLista; i++) {

				Professor professor = new Professor();
				professor = lista.get(i);

				FileInputStream fis1 = new FileInputStream(arqInscricoes);
				InputStreamReader isr1 = new InputStreamReader(fis1);
				BufferedReader buffer1 = new BufferedReader(isr1);
				String linha1 = buffer1.readLine();
				while (linha1 != null) {
					String[] vetLinha = linha1.split(";");
					if (Double.parseDouble(vetLinha[0]) == professor.getCPFProfessor()) {
						taInscricaoListaLer.append("CPF: " + professor.getCPFProfessor() + " - Nome: "
								+ professor.getNomeProfessor() + "  - Area: " + professor.getAreaProfessor()
								+ " - Pontos: " + professor.getPontosProfessor() + " - Cod Disciplina: " + vetLinha[1]
								+ "  - Cod Processo: " + vetLinha[2] +"\r\n");
					}
					linha1 = buffer1.readLine();
				}
				buffer1.close();
				isr1.close();
				fis1.close();
			}
		}
	}
	
	public ListaGenerica<Professor> bubbleSort(ListaGenerica<Professor> lista) throws Exception {
        int tamanho = lista.size();
        boolean trocou;

        for (int i = 0; i < tamanho - 1; i++) {
            trocou = false;

            for (int j = 0; j < tamanho - i - 1; j++) {
                Professor atual = lista.get(j);
                Professor proximo = lista.get(j + 1);

                if (atual.getCPFProfessor() > proximo.getCPFProfessor()) {  
                    swap(lista, j, j + 1);
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
		return lista;
    }
	
	private void swap(ListaGenerica<Professor> lista, int i, int j) throws Exception {
		Professor elemI = lista.get(i);
        Professor elemJ = lista.get(j);

        lista.remove(j);
        lista.remove(i);

        lista.add(elemJ, i);
        lista.add(elemI, j);
    }

	private String buscaInscricao(Inscricao inscricao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "inscricoes.csv");

		String linha = null;

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (Double.parseDouble(vetLinha[2]) == inscricao.getCodigoProcesso()) {
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}

		return linha;
	}
}
