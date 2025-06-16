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
import model.Disciplina;

import modeloLista.ListaGenerica;
import modelFila.Fila;

public class DisciplinaController implements ActionListener, ICRUD{
	
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
				} catch (Exception e1) {
					// TODO Auto-generated catch block
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
				} catch (Exception e1) {
					// TODO Auto-generated catch block
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
	public void BuscarDeletar() throws IOException {
	    Disciplina disciplina = new Disciplina();
	    disciplina.setCodigoDisciplina(Integer.parseInt(tfCodigoDisciplinaDeletar.getText()));

	    disciplina = buscaDisciplina(disciplina);

	    if (disciplina.getNomeDisciplina() != null) {
	        taDisciplinaDeletar.setText(
	            "Código: " + disciplina.getCodigoDisciplina() +
	            " - Nome: " + disciplina.getNomeDisciplina() +
	            " - Dia: " + disciplina.getDiaDisciplina() +
	            " - Início: " + disciplina.getDuracaoDisciplina() +
	            " - Duração: " + disciplina.getHoraDisciplina()
	        );
	    } else {
	        taDisciplinaDeletar.setText("Disciplina não encontrada");
	    }
	}
	@Override
	public void Deletar() throws Exception {
		int COD = Integer.parseInt(tfCodigoDisciplinaDeletar.getText());

		DeletarDisciplina(COD);
		tfCodigoDisciplinaCriar.setText("");
		taDisciplinaAtualizar.setText("Disciplina deletada com Sucesso");
	}
	private void DeletarDisciplina(int cod) throws Exception {
	    String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
	    File arq = new File(path, "disciplina.csv");
	    ListaGenerica<Disciplina> lista = new ListaGenerica<>();

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

	            if (verifica == 0 && (Double.parseDouble(vetLinha[0]) == cod)) {
					verifica++;
				} else {
	                disciplina.setCodigoDisciplina(Integer.parseInt(vetLinha[0]));
	                disciplina.setNomeDisciplina(vetLinha[1].trim());
	                disciplina.setDiaDisciplina(vetLinha[2].trim());
	                disciplina.setHoraDisciplina(vetLinha[3].trim());
	                disciplina.setHoraDisciplina(vetLinha[4].trim());
	                lista.addLast(disciplina);
	            }
	            linha = buffer.readLine();
	        }
	        InscricaoController.DeletarInscricoesPorDisciplina(cod);
	        buffer.close();
	        isr.close();
	        fis.close();

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

	public void BuscarAtualizar() throws IOException {
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodigoDisciplinaAtualizar.getText()));

		disciplina = buscaDisciplina(disciplina);
		if (disciplina.getNomeDisciplina() != null) {
			taDisciplinaAtualizar.setText("Código: " + disciplina.getCodigoDisciplina() + " - Nome: " + disciplina.getNomeDisciplina()
					+ "  - Dia: " + disciplina.getDiaDisciplina() + " - Hora: " + disciplina.getHoraDisciplina() + " - Duração: " + disciplina.getDuracaoDisciplina()) ;
		} else {
			taDisciplinaAtualizar.setText("Cliente não encontrado");
		}
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
		tfCodigoDisciplinaCriar.setText("");
		tfNomeDisciplinaCriar.setText("");
		tfDuracaoDisciplinaCriar.setText("");
		tfHoraDisciplinaCriar.setText("");
		tfDiaDisciplinaCriar.setText("");
		taDisciplinaAtualizar.setText("Disciplina atualizada com Sucesso");
	}
	
	public void AtualizarDisciplina(String disc) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "disciplina.csv");
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
				}
				lista.addLast(disciplina);
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
	@SuppressWarnings("unchecked")
	public void Ler() throws Exception {
	    String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
	    File arq = new File(path, "disciplina.csv");

	    taDisciplinaLer.setText("");
	    
	    Fila<Disciplina>[] tabela = new Fila[10];
	    for (int i = 0; i < 10; i++) {
	        tabela[i] = new Fila<>();
	    }

	    if (arq.exists() && arq.isFile()) {
	        FileInputStream fis = new FileInputStream(arq);
	        InputStreamReader isr = new InputStreamReader(fis);
	        BufferedReader buffer = new BufferedReader(isr);
	        String linha = buffer.readLine();

	        while (linha != null) {
	            String[] vetLinha = linha.split(";");
	            Disciplina disciplina = new Disciplina();
	            disciplina.setCodigoDisciplina(Integer.parseInt(vetLinha[0].trim()));
	            disciplina.setNomeDisciplina(vetLinha[1].trim());
	            disciplina.setDiaDisciplina(vetLinha[2].trim());
	            disciplina.setDuracaoDisciplina(vetLinha[3].trim());
	            disciplina.setHoraDisciplina(vetLinha[4].trim());

	            int codigo = disciplina.getCodigoDisciplina();
	            int indice = hashMultiplicacao(codigo, 10);

	            tabela[indice].insert(disciplina);

	            linha = buffer.readLine();
	        }

	        for (int i = 0; i < tabela.length; i++) {
	            if (!tabela[i].isEmpty()) {
	                taDisciplinaLer.append("Divisão " + i + ":\n");
	                int tamanho = tabela[i].size();
	                for (int j = 0; j < tamanho; j++) {
	                    Disciplina d = tabela[i].remove();
	                    taDisciplinaLer.append("  " + d.toString() + "\n");
	                    tabela[i].insert(d);
	                }
	            }
	        }

	        buffer.close();
	        isr.close();
	        fis.close();
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
				if (Integer.parseInt(vetLinha[0].trim()) == disciplina.getCodigoDisciplina()) {
					disciplina.setNomeDisciplina(vetLinha[1].trim());
					disciplina.setDiaDisciplina(vetLinha[2].trim());
					disciplina.setDuracaoDisciplina(vetLinha[3].trim());
					disciplina.setHoraDisciplina(vetLinha[4].trim());
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

	private int hashMultiplicacao(int chave, int m) {
	    double A = 0.6180339887; // (√5 - 1) / 2
	    double prod = chave * A;
	    double frac = prod - Math.floor(prod);
	    return (int) Math.floor(m * frac);
	}
}
