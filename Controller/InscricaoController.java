package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
		disciplina.
		inscricao.setCodigoProcesso(Integer.parseInt(tfCPFInscricaoCriar.getText()));
		inscricao.setNomeProfessor(tfNomeProfessorCriar.getText());
		inscricao.setAreaProfessor(tfAreaProfessorCriar.getText());
		inscricao.setPontosProfessor(Integer.parseInt(tfPontosProfessorCriar.getText()));

		CriarProfessor(professor.toString());
		tfCPFProfessorCriar.setText("");
		tfNomeProfessorCriar.setText("");
		tfAreaProfessorCriar.setText("");
		tfPontosProfessorCriar.setText("");
	}

	public void CriarInscricao(String csvInscricao) throws IOException {
		
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
