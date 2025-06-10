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

import Interface.IProcura;
import model.Professor;
import modeloLista.ListaGenerica;

public class ProfessorController implements ActionListener, IProcura {

	private JTextField tfCPFProfessorCriar;
	private JTextField tfNomeProfessorCriar;
	private JTextField tfAreaProfessorCriar;
	private JTextField tfPontosProfessorCriar;

	private JTextField tfCPFProfessorBuscarAtualizar;
	private JTextField tfNomeProfessorAtualizar;
	private JTextField tfAreaProfessorAtualizar;
	private JTextField tfPontosProfessorAtualizar;
	private JTextArea taProfessorListaAtualizar;

	private JTextArea taProfessorListaLer;
	private JTextArea taProfessorListaDeletar;
	private JTextField tfCPFProfessorBuscarDeletar;

	public ProfessorController(JTextField tfCPFProfessorCriar, JTextField tfNomeProfessorCriar,
			JTextField tfAreaProfessorCriar, JTextField tfPontosProfessorCriar, JTextField tfCPFProfessorBuscarAtualizar,
			JTextField tfNomeProfessorAtualizar, JTextField tfAreaProfessorAtualizar,
			JTextField tfPontosProfessorAtualizar, JTextArea taProfessorListaAtualizar, JTextField tfCPFProfessorBuscarDeletar,
			JTextArea taProfessorListaDeletar, JTextArea taProfessorListaLer) {
		super();
		this.tfCPFProfessorCriar = tfCPFProfessorCriar;
		this.tfNomeProfessorCriar = tfNomeProfessorCriar;
		this.tfAreaProfessorCriar = tfAreaProfessorCriar;
		this.tfPontosProfessorCriar = tfPontosProfessorCriar;
		this.tfCPFProfessorBuscarAtualizar = tfCPFProfessorBuscarAtualizar;
		this.tfNomeProfessorAtualizar = tfNomeProfessorAtualizar;
		this.tfAreaProfessorAtualizar = tfAreaProfessorAtualizar;
		this.tfPontosProfessorAtualizar = tfPontosProfessorAtualizar;
		this.taProfessorListaAtualizar = taProfessorListaAtualizar;
		this.tfCPFProfessorBuscarDeletar = tfCPFProfessorBuscarDeletar;
		this.taProfessorListaDeletar = taProfessorListaDeletar;
		this.taProfessorListaLer = taProfessorListaLer;
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
		if (cmd.equals("Buscar_AT")) {
			try {
				BuscarAtualizar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Buscar_DL")) {
			try {
				BuscarDeletar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Atualizar")) {
			try {
				Atualizar();
			} catch (Exception e1) {
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
		Professor professor = new Professor();
		professor.setCPFProfessor(Double.parseDouble(tfCPFProfessorCriar.getText()));
		professor.setNomeProfessor(tfNomeProfessorCriar.getText());
		professor.setAreaProfessor(tfAreaProfessorCriar.getText());
		professor.setPontosProfessor(Integer.parseInt(tfPontosProfessorCriar.getText()));

		CriarProfessor(professor.toString());
		tfCPFProfessorCriar.setText("");
		tfNomeProfessorCriar.setText("");
		tfAreaProfessorCriar.setText("");
		tfPontosProfessorCriar.setText("");
	}

	public void CriarProfessor(String csvProfessor) throws IOException {

		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "professor.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProfessor + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	@Override
	public void Deletar() throws IOException {
		double CPF = Double.parseDouble(tfCPFProfessorBuscarDeletar.getText());

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

	public void BuscarAtualizar() throws IOException {
		Professor professor = new Professor();
		professor.setCPFProfessor(Double.parseDouble(tfCPFProfessorBuscarAtualizar.getText()));

		professor = buscaProfessor(professor);
		tfCPFProfessorBuscarAtualizar.setText("");
		if (professor.getNomeProfessor() != null) {
			taProfessorListaAtualizar.setText("CPF: " + professor.getCPFProfessor() + " - Nome: " + professor.getNomeProfessor()
					+ "  - Area: " + professor.getAreaProfessor() + " - Pontos: " + professor.getPontosProfessor());
		} else {
			taProfessorListaAtualizar.setText("Cliente nao encontrado");
		}
	}
	
	
	
	public void BuscarDeletar() throws IOException {
		Professor professor = new Professor();
		professor.setCPFProfessor(Double.parseDouble(tfCPFProfessorBuscarDeletar.getText()));

		professor = buscaProfessor(professor);
		tfCPFProfessorBuscarDeletar.setText("");
		if (professor.getNomeProfessor() != null) {
			taProfessorListaDeletar.setText("CPF: " + professor.getCPFProfessor() + " - Nome: " + professor.getNomeProfessor()
					+ "  - Area: " + professor.getAreaProfessor() + " - Pontos: " + professor.getPontosProfessor());
		} else {
			taProfessorListaDeletar.setText("Cliente nao encontrado");
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
				if (Double.parseDouble(vetLinha[0]) == professor.getCPFProfessor()) {
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

	public void Atualizar() throws Exception {
		Professor professor = new Professor();
		professor.setCPFProfessor(Double.parseDouble(tfCPFProfessorBuscarAtualizar.getText()));
		professor.setNomeProfessor(tfNomeProfessorAtualizar.getText());
		professor.setAreaProfessor(tfAreaProfessorAtualizar.getText());
		professor.setPontosProfessor(Integer.parseInt(tfPontosProfessorAtualizar.getText()));

		AtualizarProfessor(professor.toString());
	}
	
	

	private void AtualizarProfessor(String prof) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "professor.csv");
		ListaGenerica<Professor> lista = new ListaGenerica<>();

		String[] vetProfessor = prof.split(";");
		double CPF = Double.parseDouble(vetProfessor[0]);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				Professor professor = new Professor();
				professor.setCPFProfessor(Double.parseDouble(vetLinha[0]));
				professor.setNomeProfessor(vetLinha[1]);
				professor.setAreaProfessor(vetLinha[2]);
				professor.setPontosProfessor(Integer.parseInt(vetLinha[3]));
				lista.addLast(professor);
				linha = buffer.readLine();
			}	
			int tamanhoLista = lista.size();
			
			for (int i = 0; i < tamanhoLista; i++) {
				Professor professor = lista.get(i);
				if (professor.getCPFProfessor() == CPF) {
					professor.setNomeProfessor(vetProfessor[1]);
					professor.setAreaProfessor(vetProfessor[2]);
					professor.setPontosProfessor(Integer.parseInt(vetProfessor[3]));
				}
			}
			
			FileWriter fw = new FileWriter(arq);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush();
			pw.close();
			fw.close();
			
			for (int i = 0; i < tamanhoLista; i++) {
				Professor professor = lista.get(i);
				FileWriter fw1 = new FileWriter(arq, existe);
				PrintWriter pw1 = new PrintWriter(fw1);
				pw1.write(professor.toString() + "\r\n");
				pw1.flush();
				pw1.close();
				fw1.close();
			}
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
				taProfessorListaLer.append("CPF: " + vetLinha[0] + " - Nome: " + vetLinha[1] + "  - Area: " + vetLinha[2]+ " - Pontos: " + vetLinha[3] + "\r\n");
				//System.out.println("CPF: " + vetLinha[0] + " - Nome: " + vetLinha[1] + "  - Area: " + vetLinha[2]+ " - Pontos: " + vetLinha[3] + "\r\n");
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
	}

	@Override
	public void Buscar() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
