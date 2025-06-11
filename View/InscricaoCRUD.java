package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ProfessorController;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscricaoCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodProcessoAtualizar;
	private JLabel lblCodProcessoDeletar;

	/**
	 * Launch the application.
	 * 
	 */
	public InscricaoCRUD(TelaCrud tela) {
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorCRUD frame = new ProfessorCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Criando a tela.
	 */
	public InscricaoCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 416, 241);
		contentPane.add(tabbedPane);
		
// Aba Criar
		
		JPanel tabCriarProfessor = new JPanel();
		tabbedPane.addTab("Criar", null, tabCriarProfessor, "Criar Professor");
		tabCriarProfessor.setLayout(null);
		
		JLabel lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		tabCriarProfessor.add(lblCPFProfessor);
		
		JTextField tfCPFInscricaoCriar = new JTextField();
		tfCPFInscricaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFInscricaoCriar.setBounds(90, 12, 197, 20);
		tabCriarProfessor.add(tfCPFInscricaoCriar);
		tfCPFInscricaoCriar.setColumns(10);
		
		JLabel lblCodDisciplina = new JLabel("Cod Disciplina");
		lblCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodDisciplina.setBounds(21, 41, 157, 32);
		tabCriarProfessor.add(lblCodDisciplina);
		
		JTextField tfCodDisciplinaInscricaoCriar = new JTextField();
		tfCodDisciplinaInscricaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodDisciplinaInscricaoCriar.setColumns(10);
		tfCodDisciplinaInscricaoCriar.setBounds(154, 42, 133, 20);
		tabCriarProfessor.add(tfCodDisciplinaInscricaoCriar);
		
		JLabel lblCodProcesso = new JLabel("Cod Processo");
		lblCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcesso.setBounds(21, 70, 179, 19);
		tabCriarProfessor.add(lblCodProcesso);
		
		JTextField tfCodProcessoInscricaoCriar = new JTextField();
		tfCodProcessoInscricaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodProcessoInscricaoCriar.setBounds(154, 71, 133, 20);
		tabCriarProfessor.add(tfCodProcessoInscricaoCriar);
		tfCodProcessoInscricaoCriar.setColumns(10);
		
		JButton btnCriarInscricao = new JButton("Criar");
		btnCriarInscricao.setBounds(300, 166, 89, 23);
		tabCriarProfessor.add(btnCriarInscricao);
		btnCriarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		lblCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDisciplina.setBounds(21, 41, 79, 19);
		lblCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcesso.setBounds(21, 70, 79, 19);
		
// Aba atualizar
		
		JPanel tabAtualizarProfessor = new JPanel();
		tabbedPane.addTab("Atualizar", null, tabAtualizarProfessor, "Atualizar Professor");
		tabAtualizarProfessor.setLayout(null);
		
		lblCodProcessoAtualizar = new JLabel("CodProcesso");
		lblCodProcessoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoAtualizar.setBounds(21, 11, 79, 19);
		tabAtualizarProfessor.add(lblCodProcessoAtualizar);
		
		JTextField tfCodProcessoBuscarInscricaoAtualizar = new JTextField();
		tfCodProcessoBuscarInscricaoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodProcessoBuscarInscricaoAtualizar.setBounds(104, 12, 183, 20);
		tabAtualizarProfessor.add(tfCodProcessoBuscarInscricaoAtualizar);
		tfCodProcessoBuscarInscricaoAtualizar.setColumns(10);
		
		JTextField tfCPFInscricaoInscricaoAtualizar = new JTextField();
		tfCPFInscricaoInscricaoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFInscricaoInscricaoAtualizar.setColumns(10);
		tfCPFInscricaoInscricaoAtualizar.setBounds(90, 124, 197, 20);
		tabAtualizarProfessor.add(tfCPFInscricaoInscricaoAtualizar);
		
		JTextField tfCodDisciplinaInscricaoAtualizar = new JTextField();
		tfCodDisciplinaInscricaoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodDisciplinaInscricaoAtualizar.setBounds(90, 153, 197, 20);
		tabAtualizarProfessor.add(tfCodDisciplinaInscricaoAtualizar);
		tfCodDisciplinaInscricaoAtualizar.setColumns(10);
		
		JButton btnAtualizarInscricao = new JButton("Atualizar");
		btnAtualizarInscricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizarInscricao.setBounds(300, 181, 89, 23);
		tabAtualizarProfessor.add(btnAtualizarInscricao);
		btnAtualizarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoAtualizar.setBounds(21, 11, 79, 19);
		
		JButton btnBuscarATInscricao = new JButton("Buscar_AT");
		btnBuscarATInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarATInscricao.setBounds(300, 11, 89, 23);
		tabAtualizarProfessor.add(btnBuscarATInscricao);
		
		JTextArea taInscricaoListaAtualizar = new JTextArea();
		taInscricaoListaAtualizar.setBounds(21, 48, 267, 46);
		tabAtualizarProfessor.add(taInscricaoListaAtualizar);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(21, 124, 79, 19);
		tabAtualizarProfessor.add(lblCPF);
		
		JLabel lblCodDisciplinaAtualizar = new JLabel("CodDisciplina");
		lblCodDisciplinaAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDisciplinaAtualizar.setBounds(21, 153, 79, 19);
		tabAtualizarProfessor.add(lblCodDisciplinaAtualizar);
		
// Aba Ler
		
		JPanel tabLerProfessor = new JPanel();
		tabbedPane.addTab("Ler", null, tabLerProfessor, "Ler Professor");
		tabLerProfessor.setLayout(null);
		
		JButton btnLerInscricao = new JButton("Ler");
		btnLerInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerInscricao.setBounds(338, 11, 73, 23);
		tabLerProfessor.add(btnLerInscricao);
		
		JTextArea taInscricaoListaLer = new JTextArea();
		taInscricaoListaLer.setBounds(10, 12, 319, 191);
		tabLerProfessor.add(taInscricaoListaLer);
		
// Aba Deletar
		
		JPanel tabDeletarProfessor = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarProfessor, "Deletar Professor");
		tabDeletarProfessor.setLayout(null);
		
		lblCodProcessoDeletar = new JLabel("CodProcesso");
		lblCodProcessoDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabDeletarProfessor.add(lblCodProcessoDeletar);
		
		JTextField tfCodProcessoInscricaoBuscarDeletar = new JTextField();
		tfCodProcessoInscricaoBuscarDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodProcessoInscricaoBuscarDeletar.setBounds(103, 12, 184, 20);
		tabDeletarProfessor.add(tfCodProcessoInscricaoBuscarDeletar);
		tfCodProcessoInscricaoBuscarDeletar.setColumns(10);
		
		JButton btnDeletarInscricao = new JButton("Deletar");
		btnDeletarInscricao.setBounds(161, 179, 89, 23);
		tabDeletarProfessor.add(btnDeletarInscricao);
		btnDeletarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoDeletar.setBounds(21, 11, 79, 19);
		
		JButton btnBuscarDLInscricao = new JButton("Buscar_DL");
		btnBuscarDLInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDLInscricao.setBounds(300, 11, 89, 23);
		tabDeletarProfessor.add(btnBuscarDLInscricao);
		
		JTextArea taInscricaoListaDeletar = new JTextArea();
		taInscricaoListaDeletar.setBounds(21, 48, 368, 120);
		tabDeletarProfessor.add(taInscricaoListaDeletar);
		
		btnCriarInscricao.addActionListener(pCont);

		btnBuscarATInscricao.addActionListener(pCont);
		
		btnBuscarDLInscricao.addActionListener(pCont);

		btnDeletarInscricao.addActionListener(pCont);

		btnAtualizarInscricao.addActionListener(pCont);
		
		btnLerInscricao.addActionListener(pCont);
		
	}
}
