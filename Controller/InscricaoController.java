package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Interface.IProcura;
import model.Inscricao;
import model.Professor;
import model.Disciplina;

public class InscricaoController implements ActionListener, IProcura {
	
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
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void Criar() throws IOException {
		Inscricao inscricao = new Inscricao();
		Professor professor = new Professor();
		Disciplina disciplina = new Disciplina();
		
		professor.setCPFProfessor(Integer.parseInt(tfCPFInscricaoCriar.getText()));
		disciplina.setCodigoDisciplina(Integer.parseInt(tfCodDisciplinaInscricaoCriar.getText()));
		inscricao.setCodigoProcesso(Integer.parseInt(tfCodProcessoInscricaoCriar.getText()));
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(professor +";");
		buffer.append(disciplina +";");
		buffer.append(inscricao +";");

		CriarInscricao(buffer);
		tfCPFInscricaoCriar.setText("");
		tfCodDisciplinaInscricaoCriar.setText("");
		tfCodProcessoInscricaoCriar.setText("");
	}

	public void CriarInscricao(StringBuffer csvInscricao) throws IOException {
		
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
		pw.write(csvInscricao + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}
	
	private void BuscarDeletar() throws IOException{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Deletar() throws IOException, Exception {
		// TODO Auto-generated method stub

	}
	
	private void DeletarProfessor(Double CPF) throws Exception {
		
	}
	
	private void BuscarAtualizar() throws IOException{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Atualizar() throws IOException, Exception {
		// TODO Auto-generated method stub

	}
	
	private void AtualizarInscricao(String prof) throws Exception {
		
	}

	@Override
	public void Ler() throws IOException, Exception {
		// TODO Auto-generated method stub

	}
	
	private Inscricao buscaInscricao(Inscricao inscricao) throws IOException {
		
	}

	@Override
	public void Buscar() throws IOException {
		// TODO Auto-generated method stub

	}

}
