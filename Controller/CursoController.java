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
import modeloLista.ListaGenerica;

public class CursoController implements ActionListener, IProcura {

	private JTextField tfCodigoCursoCriar;
	private JTextField tfNomeCursoCriar;
	private JTextField tfAreaCursoCriar;
	
	private JTextField tfCodigoCursoBuscarAtualizar;
	private JTextField tfNomeCursoAtualizar;
	private JTextField tfAreaCursoAtualizar;
	private JTextField tfPontosProfessorAtualizar;
	private JTextArea taCursoListaAtualizar;
	
	private JTextField tfAreaCursoLer;
	private JTextField tfCodigoCursoLer;
	private JTextArea taCursoListaLer;
	
	private JTextArea taCursoListaDeletar;
	private JTextField tfCodigoCursoBuscarDeletar;
	
	
	private JTextField tfAreaCursoDeletar;
	
	private JTextField tfCodigoCursoDeletar;
	
	
	

	public CursoController(JTextField tfAreaCursoAtualizar,JTextField tfAreaCursoCriar, 
			JTextField tfAreaCursoDeletar, JTextField tfAreaCursoLer, 
			
			JTextField tfCodigoCursoAtualizar,JTextField tfCodigoCursoCriar,
			JTextField tfCodigoCursoLer,JTextField tfCodigoCursoDeletar, 
			JTextField tfCodigoCursoBuscarDeletar,
			
			JTextField tfNomeCursoCriar, JTextField tfNomeCursoAtualizar, 
			JTextField tfNomeCursoLer, JTextField tfNomeCursoDeletar,
			
			JTextArea taCursoListaDeletar){
		super();
		
		this.tfAreaCursoAtualizar = tfAreaCursoAtualizar;
		this.tfAreaCursoCriar = tfAreaCursoCriar;
		this.tfAreaCursoLer = tfAreaCursoLer;
		this.tfAreaCursoDeletar = tfAreaCursoDeletar;
		
		
		this.tfCodigoCursoCriar = tfCodigoCursoCriar;
		this.tfCodigoCursoLer = tfCodigoCursoLer;
		this.tfCodigoCursoDeletar = tfCodigoCursoDeletar;
		this.tfCodigoCursoBuscarDeletar = tfCodigoCursoBuscarDeletar;
		
		
		this.tfNomeCursoAtualizar = tfNomeCursoAtualizar;
		this.tfNomeCursoCriar = tfNomeCursoCriar;
		
		this.taCursoListaDeletar = taCursoListaDeletar;
		
		
		
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
			} catch (Exception e1) {
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
	
	public void BuscarAtualizar() throws IOException {
		Curso curso = new Curso();
		curso.setCodigoCurso(Integer.parseInt(tfCodigoCursoBuscarAtualizar.getText()));

		curso = buscaCurso(curso);
		tfCodigoCursoBuscarAtualizar.setText("");
		if (curso.getNomeCurso() != null) {
			taCursoListaAtualizar.setText("Codigo: " + curso.getCodigoCurso() + " - Nome: " + curso.getNomeCurso()
					+ "  - Area: " + curso.getAreaCurso() + " - Pontos: ");
		} else {
			taCursoListaAtualizar.setText("Cliente nao encontrado");
		}
	}
	
	public void BuscarDeletar() throws IOException {
		Curso curso = new Curso();
		curso.setCodigoCurso(Integer.parseInt(tfCodigoCursoBuscarDeletar.getText()));

		curso = buscaCurso(curso);
		tfCodigoCursoBuscarDeletar.setText("");
		if (curso.getNomeCurso() != null) {
			taCursoListaDeletar.setText("Codigo: " + curso.getCodigoCurso() + " - Nome: " + curso.getNomeCurso()
					+ "  - Area: " + curso.getAreaCurso() + " - Pontos: ");
		} else {
			taCursoListaDeletar.setText("Curso não encontrado");
		}
	}
	
	private Curso buscaCurso(Curso curso) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "curso.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (Double.parseDouble(vetLinha[0]) == curso.getCodigoCurso()) {
					curso.setNomeCurso(vetLinha[1]);
					curso.setAreaCurso(vetLinha[2]);
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return curso;
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
	public void Deletar() throws Exception {
		
		int Codigo = Integer.parseInt(tfCodigoCursoDeletar.getText());

			DeletarCurso(Codigo);
		
	}
	
	private void DeletarCurso(int cod) throws Exception {
	    String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
	    File arq = new File(path, "curso.csv");
	    ListaGenerica<Curso> lista = new ListaGenerica<>();

	    if (arq.exists() && arq.isFile()) {
	        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));

	        String linha;
	        while ((linha = buffer.readLine()) != null) {
	            String[] vetLinha = linha.split(";");
	            Curso c = new Curso();
	            c.setCodigoCurso(Integer.parseInt(vetLinha[0]));
	            c.setNomeCurso(vetLinha[1]);
	            c.setAreaCurso(vetLinha[2]);

	            if (c.getCodigoCurso() != cod) {
	                lista.addLast(c);
	            }
	        }

	        buffer.close();

	       
	        PrintWriter pw = new PrintWriter(new FileWriter(arq, false));
	        for (int i = 0; i < lista.size(); i++) {
	            pw.println(lista.get(i).toString());
	        }
	        pw.flush();
	        pw.close();
	    }
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

	@Override
	public void Buscar() throws IOException {
		// TODO Auto-generated method stub
		
	}
}

