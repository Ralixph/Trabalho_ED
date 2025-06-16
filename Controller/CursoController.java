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
import modelFila.Fila;
import modeloLista.ListaGenerica;

public class CursoController implements ActionListener, IProcura {

	private JTextField tfCodigoCursoCriar;
	private JTextField tfNomeCursoCriar;
	private JTextField tfAreaCursoCriar;
	
	private JTextField tfCodigoCursoAtualizar;
	private JTextField tfNomeCursoAtualizar;
	private JTextField tfAreaCursoAtualizar;
	
	private JTextArea taCursoListaLer;
	
	private JTextArea taCursoListaDeletar;
	private JTextField tfCodigoCursoDeletar;
	
	private JTextArea taCursoListaAtualizar;
	

	public CursoController(JTextField tfAreaCursoAtualizar,JTextField tfAreaCursoCriar, 
			JTextField tfAreaCursoDeletar, JTextField tfAreaCursoLer, 
			
			JTextField tfCodigoCursoAtualizar,JTextField tfCodigoCursoCriar,
			JTextField tfCodigoCursoLer,JTextField tfCodigoCursoDeletar, 
			
			JTextField tfNomeCursoCriar, JTextField tfNomeCursoAtualizar, 
			JTextField tfNomeCursoLer, JTextField tfNomeCursoDeletar,
			
			JTextArea taCursoListaDeletar,
			JTextArea taCursoListaLer, JTextArea taCursoListaAtualizar){
		super();
		
		this.tfAreaCursoAtualizar = tfAreaCursoAtualizar;
		this.tfAreaCursoCriar = tfAreaCursoCriar;
		
		
		this.tfCodigoCursoCriar = tfCodigoCursoCriar;
		this.tfCodigoCursoDeletar = tfCodigoCursoDeletar;
		
		
		this.tfNomeCursoAtualizar = tfNomeCursoAtualizar;
		this.tfNomeCursoCriar = tfNomeCursoCriar;
		
		this.taCursoListaDeletar = taCursoListaDeletar;
		
		this.tfCodigoCursoAtualizar = tfCodigoCursoAtualizar;
		
		
		this.taCursoListaLer = taCursoListaLer;
		
		this.taCursoListaAtualizar = taCursoListaAtualizar;
		
		
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
			} catch (Exception e1) {e1.printStackTrace();}
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

// Aba Criar
	
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
	
// Aba Deletar
	
	@Override
	public void Deletar() throws Exception {
		
		int Codigo = Integer.parseInt(tfCodigoCursoDeletar.getText());

			DeletarCurso(Codigo);
			tfCodigoCursoDeletar.setText("");
			taCursoListaDeletar.setText("Curso deletado com Sucesso");
		
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
	
	public void BuscarDeletar() throws IOException {
		Curso curso = new Curso();
		curso.setCodigoCurso(Integer.parseInt(tfCodigoCursoDeletar.getText()));

		curso = buscaCurso(curso);
		if (curso.getNomeCurso() != null) {
			taCursoListaDeletar.setText("Codigo: " + curso.getCodigoCurso() + " - Nome: " + curso.getNomeCurso()
					+ "  - Area: " + curso.getAreaCurso());
		} else {
			taCursoListaDeletar.setText("Curso não encontrado");
		}
	}

// Aba Atualizar
	
	public void Atualizar() throws Exception {
		Curso curso = new Curso();
		curso.setCodigoCurso(Integer.parseInt(tfCodigoCursoAtualizar.getText()));
		curso.setNomeCurso(tfNomeCursoAtualizar.getText());
		curso.setAreaCurso(tfAreaCursoAtualizar.getText());

		AtualizarCurso(curso.toString());
		tfNomeCursoAtualizar.setText("");
		tfAreaCursoAtualizar.setText("");
		tfCodigoCursoAtualizar.setText("");
		taCursoListaAtualizar.setText("Atualização feita com Sucesso");
		
	}
	
	private void AtualizarCurso(String curs) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "curso.csv");
		ListaGenerica<Curso> lista = new ListaGenerica<>();

		String[] vetCurso = curs.split(";");
		int codigo = Integer.parseInt(vetCurso[0]);
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
				Curso curso = new Curso();

				if (verifica == 0 && (Integer.parseInt(vetLinha[0]) == codigo)) {
					verifica++;
					curso.setCodigoCurso(Integer.parseInt(vetCurso[0]));
					curso.setNomeCurso(vetCurso[1]);
					curso.setAreaCurso(vetCurso[2]);
				} else {
					curso.setCodigoCurso(Integer.parseInt(vetLinha[0]));
					curso.setNomeCurso(vetLinha[1]);
					curso.setAreaCurso(vetLinha[2]);
				}
				lista.addLast(curso);
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
			FileWriter fw1 = new FileWriter(arq, existe);
			PrintWriter pw1 = new PrintWriter(fw1);
			int tamanhoLista = lista.size();

			for (int i = 0; i < tamanhoLista; i++) {
				
				Curso curso = lista.get(i);
				pw1.write(curso.toString() + "\r\n");
				
			}
			pw1.flush();
			pw1.close();
			fw1.close();
		}
	}
	
	public void BuscarAtualizar() throws IOException {
		Curso curso = new Curso();
		curso.setCodigoCurso(Integer.parseInt(tfCodigoCursoAtualizar.getText()));

		curso = buscaCurso(curso);
		if (curso.getNomeCurso() != null) {
			taCursoListaAtualizar.setText("Codigo: " + curso.getCodigoCurso() + " - Nome: " + curso.getNomeCurso()
					+ "  - Area: " + curso.getAreaCurso());
		} else {
			taCursoListaAtualizar.setText("Curso não encontrado");
		}
	}

	@Override
	public void Ler() throws Exception {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoTemporaria";
		File arq = new File(path, "curso.csv");
		Fila<Curso> filaAuxiliar = new Fila<>();
		Fila<Curso> fila = new Fila<>();
		
		taCursoListaLer.setText("");
		
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				Curso curso = new Curso();
				curso.setCodigoCurso(Integer.parseInt(vetLinha[0]));
				curso.setNomeCurso(vetLinha[1]);
				curso.setAreaCurso(vetLinha[2]);
				filaAuxiliar.insert(curso);
				fila.insert(curso);
				linha = buffer.readLine();
			}
			int tamanhoFila = filaAuxiliar.size();

			for (int i = 0; i < tamanhoFila; i++) {
				Curso curso = new Curso();
				curso = filaAuxiliar.remove();
				taCursoListaLer.append(curso.toString() + "\n");
			}

			buffer.close();
			isr.close();
			fis.close();
		}
	}
}

