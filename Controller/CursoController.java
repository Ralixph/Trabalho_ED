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

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Interface.IProcura;
import model.Curso;
import model.Professor;

public class CursoController implements ActionListener, IProcura {

	private JTextField tfCodigoCursoCriar;
	private JTextField tfNomeCursoCriar;
	private JTextField tfAreaCursoCriar;
	
	private JTextField tfCodigoCursoBuscarAtualizar;
	private JTextField tfNomeCursoAtualizar;
	private JTextField tfAreaCursoAtualizar;
	private JTextField tfPontosProfessorAtualizar;
	private JTextArea taProfessorListaAtualizar;
	
	private JTextField tfCPFProfessorBuscar; 
	private JTextArea taProfessorListaLer;
	private JTextArea taProfessorListaDeletar;
	private JTextField tfCPFProfessorBuscarDeletar;
	
	

	public CursoController(JTextField tfAreaCursoAtualizar,JTextField tfAreaCursoCriar, 
			JTextField tfAreaCursoDeletar, JTextField tfAreaCursoLer, 
			
			JTextField tfCodigoCursoAtualizar,JTextField tfCodigoCursoCriar,
			JTextField tfCodigoCursoLer,JTextField tfCodigoCursoDeletar, 
			
			JTextField tfNomeCursoCriar, JTextField tfNomeCursoAtualizar, 
			JTextField tfNomeCursoLer, JTextField tfNomeCursoDeletar) {
		super();
		this.tfCodigoCursoCriar = tfCodigoCursoCriar;
		this.tfNomeCursoCriar = tfNomeCursoCriar;
		this.tfAreaCursoCriar = tfAreaCursoCriar;
		this.tfCodigoCursoBuscarAtualizar = tfCodigoCursoBuscarAtualizar;
		this.tfNomeCursoAtualizar = tfNomeCursoAtualizar;
		this.tfAreaCursoAtualizar = tfAreaCursoAtualizar;
		
		this.taProfessorListaAtualizar = taProfessorListaAtualizar;
		this.taProfessorListaLer = taProfessorListaLer;
		this.taProfessorListaDeletar = taProfessorListaDeletar;
		this.tfCPFProfessorBuscarDeletar = tfCPFProfessorBuscarDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Criar")) {
			try {
				Criar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (cmd.equals("Deletar")) {
			try {
				Deletar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Buscar")) {
			try {
				Buscar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Atualizar")) {
			try {
				Atualizar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Ler")) {
			try {
				Ler();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void Criar() throws IOException {
		Curso curso = new Curso();
		curso.setCodigoCurso(Integer.parseInt(tfCodigoCursoCriar.getText()));
		curso.setNomeCurso(tfNomeCursoCriar.getText());
		curso.setAreaCurso(tfAreaCursoCriar.getText());
		

		CriarCurso(curso.toString());
		tfCodigoCursoCriar.setText("");
		tfNomeCursoCriar.setText("");
		tfAreaCursoCriar.setText("");
		
	}

	public void CriarCurso(String csvCurso) throws IOException {

		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "curso.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvCurso + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	@Override
	public void Deletar() throws IOException {
		double CPF = Double.parseDouble(tfCPFProfessor.getText());

		DeletarProfessor(CPF);
	}

	private void DeletarProfessor(Double CPF) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "professor.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(CPF)) {
					vetLinha[1] = null;
					vetLinha[2] = null;
					vetLinha[3] = null;
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
	}

	public void Buscar() throws IOException {
		Professor professor = new Professor();
		professor.setCPFProfessor(Double.parseDouble(tfCPFProfessor.getText()));

		professor = buscaProfessor(professor);
		tfCPFProfessor.setText("");
		if (professor.getNomeProfessor() != null) {
			taProfessorLista.setText("CPF: " + professor.getCPFProfessor() + " - Nome: " + professor.getNomeProfessor()
					+ "  - Area: " + professor.getAreaProfessor() + " - Pontos: " + professor.getPontosProfessor());
		} else {
			taProfessorLista.setText("Cliente nao encontrado");
		}
	}

	private Professor buscaProfessor(Professor professor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "professor.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(professor.getCPFProfessor())) {
					professor.setNomeProfessor(vetLinha[1]);
					professor.setAreaProfessor(vetLinha[2]);
					professor.setPontosProfessor(Integer.parseInt(vetLinha[3]));
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return professor;
	}

	public void Atualizar() throws IOException {
		Professor professor = new Professor();
		professor.setCPFProfessor(Double.parseDouble(tfCPFProfessorAtualizar.getText()));
		professor.setNomeProfessor(tfNomeCursoAtualizar.getText());
		professor.setAreaProfessor(tfAreaCursoAtualizar.getText());
		professor.setPontosProfessor(Integer.parseInt(tfPontosProfessorAtualizar.getText()));

		AtualizarProfessor(professor.toString());
	}

	private void AtualizarProfessor(String professor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "professor.csv");

		String[] vetProfessor = professor.split(";");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(vetProfessor[0])) {
					vetLinha[1] = vetProfessor[1];
					vetLinha[2] = vetProfessor[2];
					vetLinha[3] = vetProfessor[3];
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
	}

	@Override
	public void Ler() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "professor.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				taProfessorLista.setText("CPF: " + vetLinha[0] + " - Nome: " + vetLinha[1] + "  - Area: " + vetLinha[2]
						+ " - Pontos: " + vetLinha[3]);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
	}
}

