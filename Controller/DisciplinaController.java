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
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Interface.IProcura;
import model.Disciplina;

public class DisciplinaController implements ActionListener, IProcura{
	private JTextField tfCodigoDisciplinaCriar;
	private JTextField tfNomeDisciplinaCriar;
	private JTextField tfDiaDisciplinaCriar;
	private JTextField tfDuracaoDisciplinaCriar;
	private JTextField tfHoraDisciplinaCriar;

	private JTextField tfCodigoDisciplinaAtualizar;
	private JTextField tfNomeDisciplinaAtualizar;
	private JTextField tfDiaDisciplinaAtualizar;
	private JTextField tfDuracaoDisciplinaAtualizar;
	private JTextField tfHoraDisciplinaAtualizar;
	private JTextArea taDisciplinaAtualizar;
	
	private JTextArea taDisciplinaLer;
	
	private JTextField tfCodigoDisciplinaDeletar;
	private JTextArea taDisciplinaDeletar;
	
	public DisciplinaController(JTextField tfCodigoDisciplinaCriar,JTextField tfNomeDisciplinaCriar,JTextField tfDuracaoDisciplinaCriar,JTextField tfHoraDisciplinaCriar,JTextField tfDiaDisciplinaCriar,
	 JTextField tfCodigoDisciplinaAtualizar, JTextField tfNomeDisciplinaAtualizar, JTextField tfDuracaoDisciplinaAtualizar, JTextField tfHoraDisciplinaAtualizar, JTextField tfDiaDisciplinaAtualizar,
	 JTextArea taDisciplinaAtualizar, JTextArea taDisciplinaLer,
	 JTextField tfCodigoDisciplinaDeletar, JTextArea taDisciplinaDeletar) {
		
		this.tfCodigoDisciplinaCriar = tfCodigoDisciplinaCriar;
		this.tfNomeDisciplinaCriar = tfNomeDisciplinaCriar;
		this.tfDuracaoDisciplinaCriar = tfDuracaoDisciplinaCriar;
		this.tfHoraDisciplinaCriar = tfHoraDisciplinaCriar;
		this.tfDiaDisciplinaCriar = tfDiaDisciplinaCriar;

		this.tfCodigoDisciplinaAtualizar = tfCodigoDisciplinaAtualizar;
		this.tfNomeDisciplinaAtualizar = tfNomeDisciplinaAtualizar;
		this.tfDuracaoDisciplinaAtualizar = tfDuracaoDisciplinaAtualizar;
		this.tfHoraDisciplinaAtualizar = tfHoraDisciplinaAtualizar;
		this.tfDiaDisciplinaAtualizar = tfDiaDisciplinaAtualizar;
		this.taDisciplinaAtualizar = taDisciplinaAtualizar;
		
		this.taDisciplinaLer = taDisciplinaLer;

		this.tfCodigoDisciplinaDeletar = tfCodigoDisciplinaDeletar;
		this.taDisciplinaDeletar = taDisciplinaDeletar;
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
		
	public void Criar() throws IOException {
		Disciplina disciplina = new Disciplina();
		
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodigoDisciplinaCriar.getText()));
		disciplina.setNomeDisciplina(tfNomeDisciplinaCriar.getText());
		disciplina.setDiaDisciplina(tfDiaDisciplinaCriar.getText());
		disciplina.setHoraDisciplina(tfHoraDisciplinaCriar.getText());
		disciplina.setDuracaoDisciplina(tfDuracaoDisciplinaCriar.getText());
		
		CriarDisciplina(disciplina.toString());
		tfCodigoDisciplinaCriar.setText("");
		tfNomeDisciplinaCriar.setText("");
		tfDuracaoDisciplinaCriar.setText("");
		tfHoraDisciplinaCriar.setText("");
		tfDiaDisciplinaCriar.setText("");
	}
	public void CriarDisciplina(String csvdisciplina) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "disciplina.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvdisciplina + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}
	

	@Override
	public void Deletar() throws IOException {
		int COD = Integer.parseInt(tfCodigoDisciplinaDeletar.getText());

		DeletarDisciplina(COD);
	}

	private void DeletarDisciplina(int COD) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "disciplina.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(COD)) {
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
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodigoDisciplinaAtualizar.getText()));

		disciplina = buscaDisciplina(disciplina);
		tfCodigoDisciplinaAtualizar.setText("");
		if (disciplina.getNomeDisciplina() != null) {
			taDisciplinaAtualizar.setText("Código: " + disciplina.getCodigoDisciplina() + " - Nome: " + disciplina.getNomeDisciplina()
					+ "  - Dia: " + disciplina.getDiaDisciplina() + " - Pontos: " + disciplina.getHoraDisciplina() + " - Pontos: " + disciplina.getDuracaoDisciplina()) ;
		} else {
			taDisciplinaAtualizar.setText("Cliente nao encontrado");
		}
	}
	private Disciplina buscaDisciplina(Disciplina disciplina) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "disciplina.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (Integer.parseInt(vetLinha[0]) == disciplina.getCodigoDisciplina()) {
					disciplina.setCodigoDisciplina(Integer.parseInt(vetLinha[0]));
					disciplina.setNomeDisciplina(vetLinha[1]);
					disciplina.setDiaDisciplina(vetLinha[2]);
					disciplina.setDuracaoDisciplina(vetLinha[3]);
					disciplina.setHoraDisciplina(vetLinha[4]);
					
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return disciplina;
	}
	@Override
	public void Atualizar() throws Exception {
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodigoDisciplinaAtualizar.getText()));
		disciplina.setNomeDisciplina(tfNomeDisciplinaAtualizar.getText());
		disciplina.setDiaDisciplina(tfDiaDisciplinaAtualizar.getText());
		disciplina.setDuracaoDisciplina(tfDuracaoDisciplinaAtualizar.getText());
		disciplina.setHoraDisciplina(tfHoraDisciplinaAtualizar.getText());

		AtualizarDisciplina(disciplina.toString());
	}
	public void AtualizarDisciplina(String disc) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "professor.csv");
		ListaGenerica<Disciplina> lista = new ListaGenerica<>();

		String[] vetDisciplina = disc.split(";");
		double COD = Double.parseDouble(vetDisciplina[0]);
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
				Disciplina disciplina = new Disciplina();

				if (verifica == 0 && (Double.parseDouble(vetLinha[0]) == COD)) {
					disciplina.setNomeDisciplina(vetDisciplina[1]);
					disciplina.setDiaDisciplina(vetDisciplina[2]);
					disciplina.setDuracaoDisciplina(vetDisciplina[3]);
					disciplina.setHoraDisciplina(vetDisciplina[4]);
					verifica++;
				} else {
					disciplina.setNomeDisciplina(vetDisciplina[1]);
					disciplina.setDiaDisciplina(vetDisciplina[2]);
					disciplina.setDuracaoDisciplina(vetDisciplina[3]);
					disciplina.setHoraDisciplina(vetDisciplina[4]);
					lista.addLast(disciplina);
					linha = buffer.readLine();
				}
			}

			FileWriter fw = new FileWriter(arq);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush();
			pw.close();
			fw.close();
			
			int tamanhoLista = lista.size();

			for (int i = 0; i < tamanhoLista; i++) {
				Disciplina disciplina = lista.get(i);
				FileWriter fw1 = new FileWriter(arq, existe);
				PrintWriter pw1 = new PrintWriter(fw1);
				pw1.write(disciplina.toString() + "\r\n");
				pw1.flush();
				pw1.close();
				fw1.close();
			}
		}
	}
	@Override
	public void Ler() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Buscar() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
