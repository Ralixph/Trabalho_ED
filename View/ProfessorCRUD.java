package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProfessorCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCPFProfessor;
	private JTextField tfNomeProfessor;
	private JTextField tfAreaProfessor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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
	public ProfessorCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 416, 241);
		contentPane.add(tabbedPane);
		
		JPanel tabCriarProfessor = new JPanel();
		tabbedPane.addTab("Criar", null, tabCriarProfessor, "Criar Professor");
		tabCriarProfessor.setLayout(null);
		
		JLabel lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		tabCriarProfessor.add(lblCPFProfessor);
		
		tfCPFProfessor = new JTextField();
		tfCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessor.setBounds(90, 12, 197, 20);
		tabCriarProfessor.add(tfCPFProfessor);
		tfCPFProfessor.setColumns(10);
		
		JLabel lblNomeProfessor = new JLabel("Nome");
		lblNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProfessor.setBounds(21, 41, 79, 19);
		tabCriarProfessor.add(lblNomeProfessor);
		
		tfNomeProfessor = new JTextField();
		tfNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeProfessor.setColumns(10);
		tfNomeProfessor.setBounds(90, 42, 197, 20);
		tabCriarProfessor.add(tfNomeProfessor);
		
		JLabel lblAreaProfessor = new JLabel("Area");
		lblAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaProfessor.setBounds(21, 70, 79, 19);
		tabCriarProfessor.add(lblAreaProfessor);
		
		tfAreaProfessor = new JTextField();
		tfAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaProfessor.setBounds(90, 71, 197, 20);
		tabCriarProfessor.add(tfAreaProfessor);
		tfAreaProfessor.setColumns(10);
		
		JLabel lblPontosProfessor = new JLabel("Pontos");
		lblPontosProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontosProfessor.setBounds(21, 99, 79, 19);
		tabCriarProfessor.add(lblPontosProfessor);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(90, 100, 197, 20);
		tabCriarProfessor.add(textField);
		
		JButton btnCriarProfessor = new JButton("Criar");
		btnCriarProfessor.setBounds(300, 166, 89, 23);
		tabCriarProfessor.add(btnCriarProfessor);
		btnCriarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel tabDeletarProfessor = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarProfessor, "Deletar Professor");
		tabDeletarProfessor.setLayout(null);
		
		JButton btnCriarCurso = new JButton("Criar");
		btnCriarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarCurso.setBounds(36, 43, 89, 23);
		tabDeletarProfessor.add(btnCriarCurso);
		
		JButton btnDeletarCurso = new JButton("Deletar");
		btnDeletarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarCurso.setBounds(252, 45, 89, 23);
		tabDeletarProfessor.add(btnDeletarCurso);
		
		JButton btnAtualizarCurso = new JButton("Atualizar");
		btnAtualizarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarCurso.setBounds(36, 116, 89, 23);
		tabDeletarProfessor.add(btnAtualizarCurso);
		
		JButton btnLerCurso = new JButton("Ler");
		btnLerCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerCurso.setBounds(252, 118, 89, 23);
		tabDeletarProfessor.add(btnLerCurso);
		
		JPanel tabAtualizarProfessor = new JPanel();
		tabbedPane.addTab("Atualizar", null, tabAtualizarProfessor, "Atualizar Professor");
		tabAtualizarProfessor.setLayout(null);
		
		JButton btnCriarInscricao = new JButton("Criar");
		btnCriarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarInscricao.setBounds(36, 43, 89, 23);
		tabAtualizarProfessor.add(btnCriarInscricao);
		
		JButton btnDeletarInscricao = new JButton("Deletar");
		btnDeletarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarInscricao.setBounds(252, 45, 89, 23);
		tabAtualizarProfessor.add(btnDeletarInscricao);
		
		JButton btnAtualizarInscricao = new JButton("Atualizar");
		btnAtualizarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarInscricao.setBounds(36, 116, 89, 23);
		tabAtualizarProfessor.add(btnAtualizarInscricao);
		
		JButton btnLerInscricao = new JButton("Ler");
		btnLerInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerInscricao.setBounds(252, 118, 89, 23);
		tabAtualizarProfessor.add(btnLerInscricao);
		
		JPanel tabLerProfessor = new JPanel();
		tabbedPane.addTab("Ler", null, tabLerProfessor, "Ler Professor");
		tabLerProfessor.setLayout(null);
		
		JButton btnCriarDisciplina = new JButton("Criar");
		btnCriarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarDisciplina.setBounds(36, 43, 89, 23);
		tabLerProfessor.add(btnCriarDisciplina);
		
		JButton btnDeletarDisciplina = new JButton("Deletar");
		btnDeletarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarDisciplina.setBounds(252, 45, 89, 23);
		tabLerProfessor.add(btnDeletarDisciplina);
		
		JButton btnAtualizarDisciplina = new JButton("Atualizar");
		btnAtualizarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarDisciplina.setBounds(36, 116, 89, 23);
		tabLerProfessor.add(btnAtualizarDisciplina);
		
		JButton btnLerDisciplina = new JButton("Ler");
		btnLerDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerDisciplina.setBounds(252, 118, 89, 23);
		tabLerProfessor.add(btnLerDisciplina);
		
		
	}
}
