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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessorCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCPFProfessor;
	private JTextField tfNomeProfessor;
	private JTextField tfAreaProfessor;
	private JTextField textField;
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
		
		tfPontosProfessor = new JTextField();
		tfPontosProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPontosProfessor.setColumns(10);
		tfPontosProfessor.setBounds(90, 100, 197, 20);
		tabCriarProfessor.add(tfPontosProfessor);
		
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
		
		tfCPFProfessor = new JTextField();
		tfCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessor.setBounds(90, 12, 197, 20);
		tabAtualizarProfessor.add(tfCPFProfessor);
		tfCPFProfessor.setColumns(10);
		
		tfNomeProfessor = new JTextField();
		tfNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeProfessor.setColumns(10);
		tfNomeProfessor.setBounds(90, 124, 197, 20);
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
		
		// ===========================================================================
		
		JPanel tabLerProfessor = new JPanel();
		tabbedPane.addTab("Ler", null, tabLerProfessor, "Ler Professor");
		tabLerProfessor.setLayout(null);
		
		btnBuscarProfessor = new JButton("Ler");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProfessor.setBounds(338, 11, 73, 23);
		tabLerProfessor.add(btnBuscarProfessor);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 12, 319, 191);
		tabLerProfessor.add(textArea);
		
		// ===========================================================================
		
		JPanel tabDeletarProfessor = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarProfessor, "Deletar Professor");
		tabDeletarProfessor.setLayout(null);
		
		lblCPFProfessor = new JLabel("CPF");
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabDeletarProfessor.add(lblCPFProfessor);
		
		tfCPFProfessor = new JTextField();
		tfCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPFProfessor.setBounds(90, 12, 197, 20);
		tabDeletarProfessor.add(tfCPFProfessor);
		tfCPFProfessor.setColumns(10);
		
		JButton btnDeletarProfessor = new JButton("Deletar");
		btnDeletarProfessor.setBounds(161, 179, 89, 23);
		tabDeletarProfessor.add(btnDeletarProfessor);
		btnDeletarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPFProfessor.setBounds(21, 11, 79, 19);
		
		btnBuscarProfessor = new JButton("Buscar");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProfessor.setBounds(300, 11, 89, 23);
		tabDeletarProfessor.add(btnBuscarProfessor);
		
		taProfessorLista = new JTextArea();
		taProfessorLista.setBounds(21, 48, 368, 120);
		tabDeletarProfessor.add(taProfessorLista);
		
	}
}
