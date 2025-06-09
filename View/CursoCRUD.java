package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CursoCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCPFProfessor;
	private JTextField tfNomeProfessor;
	private JTextField tfAreaProfessor;
	private JTextField textField;
	private JTextField textField_1;

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
	public CursoCRUD() {
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
		
		JPanel tabCriarCurso = new JPanel();
		tabbedPane.addTab("Criar", null, tabCriarCurso, "Criar Curso");
		tabCriarCurso.setLayout(null);
		
		JLabel lblCodigoCurso = new JLabel("Codigo");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setBounds(21, 11, 79, 19);
		tabCriarCurso.add(lblCodigoCurso);
		
		tfCPFProfessor = new JTextField();
		tfCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessor.setBounds(90, 12, 197, 20);
		tabCriarCurso.add(tfCPFProfessor);
		tfCPFProfessor.setColumns(10);
		
		JLabel lblNomeProfessor = new JLabel("Nome");
		lblNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProfessor.setBounds(21, 41, 79, 19);
		tabCriarCurso.add(lblNomeProfessor);
		
		tfNomeProfessor = new JTextField();
		tfNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeProfessor.setColumns(10);
		tfNomeProfessor.setBounds(90, 42, 197, 20);
		tabCriarCurso.add(tfNomeProfessor);
		
		JLabel lblAreaProfessor = new JLabel("Area");
		lblAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaProfessor.setBounds(21, 70, 79, 19);
		tabCriarCurso.add(lblAreaProfessor);
		
		tfAreaProfessor = new JTextField();
		tfAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaProfessor.setBounds(90, 71, 197, 20);
		tabCriarCurso.add(tfAreaProfessor);
		tfAreaProfessor.setColumns(10);
		
		
		JButton btnCriarCurso = new JButton("Criar");
		btnCriarCurso.setBounds(300, 166, 89, 23);
		tabCriarCurso.add(btnCriarCurso);
		btnCriarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
// Aba atualizar
		
		JPanel tabAtualizarProfessor = new JPanel();
		tabbedPane.addTab("Atualizar", null, tabAtualizarProfessor, "Atualizar Professor");
		tabAtualizarProfessor.setLayout(null);
		
		lblCPFProfessor = new JLabel("Codigo");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		tabAtualizarProfessor.add(lblCPFProfessor);
		
		tfCPFProfessor = new JTextField();
		tfCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessor.setBounds(90, 12, 197, 20);
		tabAtualizarProfessor.add(tfCPFProfessor);
		tfCPFProfessor.setColumns(10);
		
		tfNomeProfessor = new JTextField();
		tfNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeProfessor.setColumns(10);
		tfNomeProfessor.setBounds(90, 182, 197, 20);
		tabAtualizarProfessor.add(tfNomeProfessor);
		
		tfAreaProfessor = new JTextField();
		tfAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaProfessor.setBounds(90, 153, 197, 20);
		tabAtualizarProfessor.add(tfAreaProfessor);
		tfAreaProfessor.setColumns(10);
		
		tfPontosProfessor = new JTextField();
		tfPontosProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPontosProfessor.setColumns(10);
		tfPontosProfessor.setBounds(90, 182, 197, 20);
		tabAtualizarProfessor.add(tfPontosProfessor);
		
		JButton btnAtualizarProfessor = new JButton("Atualizar");
		btnAtualizarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizarProfessor.setBounds(300, 181, 89, 23);
		tabAtualizarProfessor.add(btnAtualizarProfessor);
		btnAtualizarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		
		JButton btnBuscarProfessor = new JButton("Buscar");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProfessor.setBounds(300, 11, 89, 23);
		tabAtualizarProfessor.add(btnBuscarProfessor);
		
		JTextArea taProfessorLista = new JTextArea();
		taProfessorLista.setBounds(21, 48, 267, 46);
		tabAtualizarProfessor.add(taProfessorLista);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(21, 154, 79, 19);
		tabAtualizarProfessor.add(lblNome);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(21, 183, 79, 19);
		tabAtualizarProfessor.add(lblArea);
		
		
// Aba Deletar
		
		JPanel tabDeletarProfessor = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarProfessor, "Deletar Professor");
		tabDeletarProfessor.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 20, 96, 19);
		tabDeletarProfessor.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCPFProfessor_1 = new JLabel("Codigo");
		lblCPFProfessor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor_1.setBounds(56, 20, 79, 19);
		tabDeletarProfessor.add(lblCPFProfessor_1);
		
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