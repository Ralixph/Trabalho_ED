package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.InscricaoController;
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
		
		JPanel tabCriarInscricao = new JPanel();
		tabbedPane.addTab("Criar", null, tabCriarInscricao, "Criar Professor");
		tabCriarInscricao.setLayout(null);
		
		JLabel lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		tabCriarInscricao.add(lblCPFProfessor);
		
		JTextField tfCPFInscricaoCriar = new JTextField();
		tfCPFInscricaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFInscricaoCriar.setBounds(90, 12, 197, 20);
		tabCriarInscricao.add(tfCPFInscricaoCriar);
		tfCPFInscricaoCriar.setColumns(10);
		
		JLabel lblCodDisciplina = new JLabel("Cod Disciplina");
		lblCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodDisciplina.setBounds(21, 41, 157, 32);
		tabCriarInscricao.add(lblCodDisciplina);
		
		JTextField tfCodDisciplinaInscricaoCriar = new JTextField();
		tfCodDisciplinaInscricaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodDisciplinaInscricaoCriar.setColumns(10);
		tfCodDisciplinaInscricaoCriar.setBounds(154, 42, 133, 20);
		tabCriarInscricao.add(tfCodDisciplinaInscricaoCriar);
		
		JLabel lblCodProcesso = new JLabel("Cod Processo");
		lblCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcesso.setBounds(21, 70, 179, 19);
		tabCriarInscricao.add(lblCodProcesso);
		
		JTextField tfCodProcessoInscricaoCriar = new JTextField();
		tfCodProcessoInscricaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodProcessoInscricaoCriar.setBounds(154, 71, 133, 20);
		tabCriarInscricao.add(tfCodProcessoInscricaoCriar);
		tfCodProcessoInscricaoCriar.setColumns(10);
		
		JButton btnCriarInscricao = new JButton("Criar");
		btnCriarInscricao.setBounds(300, 166, 89, 23);
		tabCriarInscricao.add(btnCriarInscricao);
		btnCriarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		lblCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDisciplina.setBounds(21, 41, 79, 19);
		lblCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcesso.setBounds(21, 70, 79, 19);
		
// Aba atualizar
		
		JPanel tabAtualizarInscricao = new JPanel();
		tabbedPane.addTab("Atualizar", null, tabAtualizarInscricao, "Atualizar Professor");
		tabAtualizarInscricao.setLayout(null);
		
		lblCodProcessoAtualizar = new JLabel("CodProcesso");
		lblCodProcessoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoAtualizar.setBounds(21, 11, 79, 19);
		tabAtualizarInscricao.add(lblCodProcessoAtualizar);
		
		JTextField tfCodProcessoBuscarInscricaoAtualizar = new JTextField();
		tfCodProcessoBuscarInscricaoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodProcessoBuscarInscricaoAtualizar.setBounds(104, 12, 183, 20);
		tabAtualizarInscricao.add(tfCodProcessoBuscarInscricaoAtualizar);
		tfCodProcessoBuscarInscricaoAtualizar.setColumns(10);
		
		JTextField tfCPFInscricaoAtualizar = new JTextField();
		tfCPFInscricaoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFInscricaoAtualizar.setColumns(10);
		tfCPFInscricaoAtualizar.setBounds(90, 124, 197, 20);
		tabAtualizarInscricao.add(tfCPFInscricaoAtualizar);
		
		JTextField tfCodDisciplinaInscricaoAtualizar = new JTextField();
		tfCodDisciplinaInscricaoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodDisciplinaInscricaoAtualizar.setBounds(90, 153, 197, 20);
		tabAtualizarInscricao.add(tfCodDisciplinaInscricaoAtualizar);
		tfCodDisciplinaInscricaoAtualizar.setColumns(10);
		
		JButton btnAtualizarInscricao = new JButton("Atualizar");
		btnAtualizarInscricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizarInscricao.setBounds(300, 181, 89, 23);
		tabAtualizarInscricao.add(btnAtualizarInscricao);
		btnAtualizarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoAtualizar.setBounds(21, 11, 79, 19);
		
		JButton btnBuscarATInscricao = new JButton("Buscar_AT");
		btnBuscarATInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarATInscricao.setBounds(300, 11, 89, 23);
		tabAtualizarInscricao.add(btnBuscarATInscricao);
		
		JTextArea taInscricaoListaAtualizar = new JTextArea();
		taInscricaoListaAtualizar.setBounds(21, 48, 267, 46);
		tabAtualizarInscricao.add(taInscricaoListaAtualizar);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(21, 124, 79, 19);
		tabAtualizarInscricao.add(lblCPF);
		
		JLabel lblCodDisciplinaAtualizar = new JLabel("CodDisciplina");
		lblCodDisciplinaAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDisciplinaAtualizar.setBounds(21, 153, 79, 19);
		tabAtualizarInscricao.add(lblCodDisciplinaAtualizar);
		
// Aba Ler
		
		JPanel tabLerInscricao = new JPanel();
		tabbedPane.addTab("Ler", null, tabLerInscricao, "Ler Professor");
		tabLerInscricao.setLayout(null);
		
		JButton btnLerInscricao = new JButton("Ler");
		btnLerInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerInscricao.setBounds(338, 11, 73, 23);
		tabLerInscricao.add(btnLerInscricao);
		
		JTextArea taInscricaoListaLer = new JTextArea();
		taInscricaoListaLer.setBounds(10, 12, 319, 191);
		tabLerInscricao.add(taInscricaoListaLer);
		
// Aba Deletar
		
		JPanel tabDeletarInscricao = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarInscricao, "Deletar Professor");
		tabDeletarInscricao.setLayout(null);
		
		lblCodProcessoDeletar = new JLabel("CodProcesso");
		lblCodProcessoDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabDeletarInscricao.add(lblCodProcessoDeletar);
		
		JTextField tfCodProcessoInscricaoBuscarDeletar = new JTextField();
		tfCodProcessoInscricaoBuscarDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodProcessoInscricaoBuscarDeletar.setBounds(103, 12, 184, 20);
		tabDeletarInscricao.add(tfCodProcessoInscricaoBuscarDeletar);
		tfCodProcessoInscricaoBuscarDeletar.setColumns(10);
		
		JButton btnDeletarInscricao = new JButton("Deletar");
		btnDeletarInscricao.setBounds(161, 179, 89, 23);
		tabDeletarInscricao.add(btnDeletarInscricao);
		btnDeletarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoDeletar.setBounds(21, 11, 79, 19);
		
		JButton btnBuscarDLInscricao = new JButton("Buscar_DL");
		btnBuscarDLInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDLInscricao.setBounds(300, 11, 89, 23);
		tabDeletarInscricao.add(btnBuscarDLInscricao);
		
		JTextArea taInscricaoListaDeletar = new JTextArea();
		taInscricaoListaDeletar.setBounds(21, 48, 368, 120);
		tabDeletarInscricao.add(taInscricaoListaDeletar);
		
		InscricaoController iCont = new InscricaoController(tfCPFInscricaoCriar, tfCodDisciplinaInscricaoCriar,
				tfCodProcessoInscricaoCriar, tfCodProcessoBuscarInscricaoAtualizar,
				tfCPFInscricaoAtualizar, tfCodDisciplinaInscricaoAtualizar,
				taInscricaoListaAtualizar, taInscricaoListaLer,
				tfCodProcessoInscricaoBuscarDeletar, taInscricaoListaDeletar);
		
		btnCriarInscricao.addActionListener(iCont);

		btnBuscarATInscricao.addActionListener(iCont);
		
		btnBuscarDLInscricao.addActionListener(iCont);

		btnDeletarInscricao.addActionListener(iCont);

		btnAtualizarInscricao.addActionListener(iCont);
		
		btnLerInscricao.addActionListener(iCont);
		
	}
}
