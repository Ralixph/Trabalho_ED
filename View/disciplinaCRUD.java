package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class disciplinaCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigoDisciplina;
	private JTextField tfNomeDisciplina;
	private JTextField tfDiaDisciplina;
	private JTextField tfHoraDisciplina;
	private JTextField tfDuracaoDisciplina;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disciplinaCRUD frame = new disciplinaCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public disciplinaCRUD() {
		setTitle("CRUDdisciplina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 416, 241);
		contentPane.add(tabbedPane);
		
		JPanel TabCriarDisciplina = new JPanel();
		tabbedPane.addTab("Criar", null, TabCriarDisciplina, "Criar Disciplina");
		TabCriarDisciplina.setLayout(null);
		
		JLabel lblCodigodisciplina = new JLabel("Código");
		lblCodigodisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigodisciplina.setBounds(21, 11, 79, 19);
		TabCriarDisciplina.add(lblCodigodisciplina);
		
		tfCodigoDisciplina = new JTextField();
		tfCodigoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoDisciplina.setBounds(90, 12, 197, 20);
		TabCriarDisciplina.add(tfCodigoDisciplina);
		tfCodigoDisciplina.setColumns(10);
		
		JLabel lblNomeDisciplina = new JLabel("Nome");
		lblNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDisciplina.setBounds(21, 41, 79, 19);
		TabCriarDisciplina.add(lblNomeDisciplina);
		
		tfNomeDisciplina = new JTextField();
		tfNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeDisciplina.setColumns(10);
		tfNomeDisciplina.setBounds(90, 42, 197, 20);
		TabCriarDisciplina.add(tfNomeDisciplina);
		
		JLabel lblDiaDisciplina = new JLabel("Dia");
		lblDiaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDisciplina.setBounds(21, 71, 79, 19);
		TabCriarDisciplina.add(lblDiaDisciplina);
		
		tfDiaDisciplina = new JTextField();
		tfDiaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDiaDisciplina.setColumns(10);
		tfDiaDisciplina.setBounds(90, 72, 197, 20);
		TabCriarDisciplina.add(tfDiaDisciplina);
		
		JLabel lblHoraDisciplina = new JLabel("Hora");
		lblHoraDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraDisciplina.setBounds(21, 101, 79, 19);
		TabCriarDisciplina.add(lblHoraDisciplina);
		
		tfHoraDisciplina = new JTextField();
		tfHoraDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfHoraDisciplina.setColumns(10);
		tfHoraDisciplina.setBounds(90, 101, 197, 20);
		TabCriarDisciplina.add(tfHoraDisciplina);
		
		JLabel lblDuracaoDisciplina = new JLabel("Duração");
		lblDuracaoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracaoDisciplina.setBounds(21, 131, 79, 19);
		TabCriarDisciplina.add(lblDuracaoDisciplina);
		
		tfDuracaoDisciplina = new JTextField();
		tfDuracaoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDuracaoDisciplina.setColumns(10);
		tfDuracaoDisciplina.setBounds(90, 131, 197, 20);
		TabCriarDisciplina.add(tfDuracaoDisciplina);
		
		JPanel TabAtualizarDisciplina = new JPanel();
		tabbedPane.addTab("Atualizar", null, TabAtualizarDisciplina, "Atualizar Disciplina");
		TabAtualizarDisciplina.setLayout(null);
		
		JLabel lblcodigo = new JLabel("código");
		lblcodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcodigo.setBounds(21, 11, 79, 19);
		TabAtualizarDisciplina.add(lblcodigo);
		
		textField = new JTextField();
		textField.setBounds(90, 12, 197, 20);
		TabAtualizarDisciplina.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(300, 11, 89, 23);
		TabAtualizarDisciplina.add(btnBuscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 39, 266, 34);
		TabAtualizarDisciplina.add(textArea);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(21, 84, 79, 19);
		TabAtualizarDisciplina.add(lblNome);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDia.setBounds(21, 114, 79, 19);
		TabAtualizarDisciplina.add(lblDia);
		
		JLabel lblcodigo_3 = new JLabel("Hora");
		lblcodigo_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcodigo_3.setBounds(21, 144, 79, 19);
		TabAtualizarDisciplina.add(lblcodigo_3);
		
		JLabel lblDuração = new JLabel("Duração");
		lblDuração.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuração.setBounds(21, 174, 79, 19);
		TabAtualizarDisciplina.add(lblDuração);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 85, 197, 20);
		TabAtualizarDisciplina.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 115, 197, 20);
		TabAtualizarDisciplina.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 145, 197, 20);
		TabAtualizarDisciplina.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 175, 197, 20);
		TabAtualizarDisciplina.add(textField_4);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setBounds(300, 174, 89, 23);
		TabAtualizarDisciplina.add(btnAtualizar);
		
		JPanel TabLerDisciplina = new JPanel();
		tabbedPane.addTab("Ler", null, TabLerDisciplina, "Ler Disciplina");
		TabLerDisciplina.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 12, 319, 191);
		TabLerDisciplina.add(textArea_1);
		
		JButton btnBuscarProfessor = new JButton("Ler");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProfessor.setBounds(338, 11, 73, 23);
		TabLerDisciplina.add(btnBuscarProfessor);
		
		JPanel TabDeletarDisciplina = new JPanel();
		tabbedPane.addTab("Deletar", null, TabDeletarDisciplina, "Deletar");
		TabDeletarDisciplina.setLayout(null);
		
		JLabel lblCodigoDisciplina = new JLabel("Código");
		lblCodigoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDisciplina.setBounds(21, 11, 79, 19);
		TabDeletarDisciplina.add(lblCodigoDisciplina);
		
		textField_5 = new JTextField();
		textField_5.setBounds(90, 12, 197, 20);
		TabDeletarDisciplina.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnBuscarDisciplina = new JButton("Buscar");
		btnBuscarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDisciplina.setBounds(300, 11, 89, 23);
		TabDeletarDisciplina.add(btnBuscarDisciplina);
		
		JTextArea taProfessorLista = new JTextArea();
		taProfessorLista.setBounds(21, 48, 368, 120);
		TabDeletarDisciplina.add(taProfessorLista);
		
		JButton btnDeletarDisciplina = new JButton("Deletar");
		btnDeletarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarDisciplina.setBounds(161, 179, 89, 23);
		TabDeletarDisciplina.add(btnDeletarDisciplina);
	}
}
