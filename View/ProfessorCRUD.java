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

public class ProfessorCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCPFProfessor;
	private JTextField tfNomeProfessor;
	private JTextField tfAreaProfessor;
	private JTextField tfPontosProfessor;

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
		
// Aba Criar
		
		JPanel tabCriarProfessor = new JPanel();
		tabbedPane.addTab("Criar", null, tabCriarProfessor, "Criar Professor");
		tabCriarProfessor.setLayout(null);
		
		JLabel lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		tabCriarProfessor.add(lblCPFProfessor);
		
		JTextField tfCPFProfessorCriar = new JTextField();
		tfCPFProfessorCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessorCriar.setBounds(90, 12, 197, 20);
		tabCriarProfessor.add(tfCPFProfessorCriar);
		tfCPFProfessorCriar.setColumns(10);
		
		JLabel lblNomeProfessor = new JLabel("Nome");
		lblNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProfessor.setBounds(21, 41, 79, 19);
		tabCriarProfessor.add(lblNomeProfessor);
		
		JTextField tfNomeProfessorCriar = new JTextField();
		tfNomeProfessorCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeProfessorCriar.setColumns(10);
		tfNomeProfessorCriar.setBounds(90, 42, 197, 20);
		tabCriarProfessor.add(tfNomeProfessorCriar);
		
		JLabel lblAreaProfessor = new JLabel("Area");
		lblAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaProfessor.setBounds(21, 70, 79, 19);
		tabCriarProfessor.add(lblAreaProfessor);
		
		JTextField tfAreaProfessorCriar = new JTextField();
		tfAreaProfessorCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaProfessorCriar.setBounds(90, 71, 197, 20);
		tabCriarProfessor.add(tfAreaProfessorCriar);
		tfAreaProfessorCriar.setColumns(10);
		
		JLabel lblPontosProfessor = new JLabel("Pontos");
		lblPontosProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontosProfessor.setBounds(21, 99, 79, 19);
		tabCriarProfessor.add(lblPontosProfessor);
		
		JTextField tfPontosProfessorCriar = new JTextField();
		tfPontosProfessorCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPontosProfessorCriar.setColumns(10);
		tfPontosProfessorCriar.setBounds(90, 100, 197, 20);
		tabCriarProfessor.add(tfPontosProfessorCriar);
		
		JButton btnCriarProfessor = new JButton("Criar");
		btnCriarProfessor.setBounds(300, 166, 89, 23);
		tabCriarProfessor.add(btnCriarProfessor);
		btnCriarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		lblNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProfessor.setBounds(21, 41, 79, 19);
		lblAreaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaProfessor.setBounds(21, 70, 79, 19);
		lblPontosProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontosProfessor.setBounds(21, 99, 79, 19);
		
// Aba atualizar
		
		JPanel tabAtualizarProfessor = new JPanel();
		tabbedPane.addTab("Atualizar", null, tabAtualizarProfessor, "Atualizar Professor");
		tabAtualizarProfessor.setLayout(null);
		
		lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		tabAtualizarProfessor.add(lblCPFProfessor);
		
		JTextField tfCPFProfessorBuscarAtualizar = new JTextField();
		tfCPFProfessorBuscarAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessorBuscarAtualizar.setBounds(90, 12, 197, 20);
		tabAtualizarProfessor.add(tfCPFProfessorBuscarAtualizar);
		tfCPFProfessorBuscarAtualizar.setColumns(10);
		
		JTextField tfNomeProfessorAtualizar = new JTextField();
		tfNomeProfessorAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeProfessorAtualizar.setColumns(10);
		tfNomeProfessorAtualizar.setBounds(90, 124, 197, 20);
		tabAtualizarProfessor.add(tfNomeProfessorAtualizar);
		
		JTextField tfAreaProfessorAtualizar = new JTextField();
		tfAreaProfessorAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaProfessorAtualizar.setBounds(90, 153, 197, 20);
		tabAtualizarProfessor.add(tfAreaProfessorAtualizar);
		tfAreaProfessorAtualizar.setColumns(10);
		
		JTextField tfPontosProfessorAtualizar = new JTextField();
		tfPontosProfessorAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPontosProfessorAtualizar.setColumns(10);
		tfPontosProfessorAtualizar.setBounds(90, 182, 197, 20);
		tabAtualizarProfessor.add(tfPontosProfessorAtualizar);
		
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
		
		JButton btnBuscarProfessor = new JButton("Buscar_AT");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProfessor.setBounds(300, 11, 89, 23);
		tabAtualizarProfessor.add(btnBuscarProfessor);
		
		JTextArea taProfessorListaAtualizar = new JTextArea();
		taProfessorListaAtualizar.setBounds(21, 48, 267, 46);
		tabAtualizarProfessor.add(taProfessorListaAtualizar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(21, 124, 79, 19);
		tabAtualizarProfessor.add(lblNome);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(21, 153, 79, 19);
		tabAtualizarProfessor.add(lblArea);
		
		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontos.setBounds(21, 183, 79, 19);
		tabAtualizarProfessor.add(lblPontos);
		
// Aba Ler
		
		JPanel tabLerProfessor = new JPanel();
		tabbedPane.addTab("Ler", null, tabLerProfessor, "Ler Professor");
		tabLerProfessor.setLayout(null);
		
		JButton btnLerProfessor = new JButton("Ler");
		btnLerProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerProfessor.setBounds(338, 11, 73, 23);
		tabLerProfessor.add(btnLerProfessor);
		
		JTextArea taProfessorListaLer = new JTextArea();
		taProfessorListaLer.setBounds(10, 12, 319, 191);
		tabLerProfessor.add(taProfessorListaLer);
		
// Aba Deletar
		
		JPanel tabDeletarProfessor = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarProfessor, "Deletar Professor");
		tabDeletarProfessor.setLayout(null);
		
		lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabDeletarProfessor.add(lblCPFProfessor);
		
		JTextField tfCPFProfessorBuscarDeletar = new JTextField();
		tfCPFProfessorBuscarDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessorBuscarDeletar.setBounds(90, 12, 197, 20);
		tabDeletarProfessor.add(tfCPFProfessorBuscarDeletar);
		tfCPFProfessorBuscarDeletar.setColumns(10);
		
		JButton btnDeletarProfessor = new JButton("Deletar");
		btnDeletarProfessor.setBounds(161, 179, 89, 23);
		tabDeletarProfessor.add(btnDeletarProfessor);
		btnDeletarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		
		btnBuscarProfessor = new JButton("Buscar_DL");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProfessor.setBounds(300, 11, 89, 23);
		tabDeletarProfessor.add(btnBuscarProfessor);
		
		JTextArea taProfessorListaDeletar = new JTextArea();
		taProfessorListaDeletar.setBounds(21, 48, 368, 120);
		tabDeletarProfessor.add(taProfessorListaDeletar);
		
		ProfessorController pCont = new ProfessorController(
			tfCPFProfessorCriar, tfNomeProfessorCriar, tfAreaProfessorCriar, tfPontosProfessorCriar, 
			tfCPFProfessorBuscarAtualizar, tfNomeProfessorAtualizar, tfAreaProfessorAtualizar, tfPontosProfessorAtualizar, taProfessorListaAtualizar, 
			tfCPFProfessorBuscarDeletar,
			taProfessorListaDeletar, taProfessorListaLer
		);
		
		btnCriarProfessor.addActionListener(pCont);

		btnBuscarProfessor.addActionListener(pCont);

		btnDeletarProfessor.addActionListener(pCont);

		btnAtualizarProfessor.addActionListener(pCont);
		
		btnLerProfessor.addActionListener(pCont);
		
	}
}
