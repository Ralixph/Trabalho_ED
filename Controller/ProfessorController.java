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

import Interface.IProcura;
import model.Cliente;
import model.Professor;


public class ProfessorController implements ActionListener, IProcura{
		
	@Override
	public void actionPerformed(ActionEvent e){
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
		
		double CPFProfessor = Double.parseDouble(JOptionPane.showInputDialog(""));
		String nomeProfessor = JOptionPane.showInputDialog("");
		String areaProfessor = JOptionPane.showInputDialog("");;
		int pontosProfessor = Integer.parseInt(JOptionPane.showInputDialog(""));;
		
		Professor professor = new Professor(CPFProfessor, nomeProfessor, areaProfessor, pontosProfessor);
		String csvProfessor = professor.toString();
		
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProfessor+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		}

	@Override
	public void Deletar() throws IOException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Atualizar() throws IOException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Ler() throws IOException{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "cliente.csv");
		
		if (arq.exists() && arq.isFile()) {
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader buffer = new BufferedReader(isr);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] vetLinha = linha.split(";");
					for(int i = 0; i < 4; i++) {
						
						vetLinha[i]
					}
						break;
					linha = buffer.readLine();
					//Professor professor = 
					//new Professor(CPFProfessor, nomeProfessor, areaProfessor, pontosProfessor);
				}	
				buffer.close();
				isr.close();
				fis.close();
			}
		return cliente;
		
	}

}
