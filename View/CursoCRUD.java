package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CursoController;

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
	
	private JTextField tfCodigoCursoCriar;
	private JTextField tfCodigoCursoAtualizar;
	private JTextField tfCodigoCursoLer;
	private JTextField tfCodigoCursoDeletar;
	
	private JTextField tfNomeCursoCriar;
	private JTextField tfNomeCursoAtualizar;
	private JTextField tfNomeCursoLer;
	private JTextField tfNomeCursoDeletar;
	
	private JTextField tfAreaCursoCriar;
	private JTextField tfAreaCursoAtualizar; 
	private JTextField tfAreaCursoLer;
	private JTextField tfAreaCursoDeletar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursoCRUD frame = new CursoCRUD();
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
		
		tfCodigoCursoCriar = new JTextField();
		tfCodigoCursoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoCursoCriar.setBounds(90, 12, 197, 20);
		tabCriarCurso.add(tfCodigoCursoCriar);
		tfCodigoCursoCriar.setColumns(10);
		
		JLabel lblNomeCurso = new JLabel("Nome");
		lblNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCurso.setBounds(21, 41, 79, 19);
		tabCriarCurso.add(lblNomeCurso);
		
		tfNomeCursoCriar = new JTextField();
		tfNomeCursoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeCursoCriar.setColumns(10);
		tfNomeCursoCriar.setBounds(90, 42, 197, 20);
		tabCriarCurso.add(tfNomeCursoCriar);
		
		JLabel lblAreaCurso = new JLabel("Area");
		lblAreaCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaCurso.setBounds(21, 70, 79, 19);
		tabCriarCurso.add(lblAreaCurso);
		
		tfAreaCursoCriar = new JTextField();
		tfAreaCursoCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaCursoCriar.setBounds(90, 71, 197, 20);
		tabCriarCurso.add(tfAreaCursoCriar);
		tfAreaCursoCriar.setColumns(10);
		
		
		JButton btnCriarCurso = new JButton("Criar");
		btnCriarCurso.setBounds(300, 166, 89, 23);
		tabCriarCurso.add(btnCriarCurso);
		btnCriarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
// Aba atualizar
		
		JPanel tabAtualizarCurso = new JPanel();
		tabbedPane.addTab("Atualizar", null, tabAtualizarCurso, "Atualizar Curso");
		tabAtualizarCurso.setLayout(null);
		
		
		lblCodigoCurso = new JLabel("Codigo");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setBounds(21, 11, 79, 19);
		tabAtualizarCurso.add(lblCodigoCurso);
		
		
		tfCodigoCursoAtualizar = new JTextField();
		tfCodigoCursoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoCursoAtualizar.setBounds(90, 12, 197, 20);
		tabAtualizarCurso.add(tfCodigoCursoAtualizar);
		tfCodigoCursoAtualizar.setColumns(10);
		
		tfNomeCursoAtualizar = new JTextField();
		tfNomeCursoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeCursoAtualizar.setColumns(10);
		tfNomeCursoAtualizar.setBounds(90, 182, 197, 20);
		tabAtualizarCurso.add(tfNomeCursoAtualizar);
		
		tfAreaCursoAtualizar = new JTextField();
		tfAreaCursoAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaCursoAtualizar.setBounds(90, 153, 197, 20);
		tabAtualizarCurso.add(tfAreaCursoAtualizar);
		tfAreaCursoAtualizar.setColumns(10);
		
		
		JButton btnAtualizarCurso = new JButton("Atualizar");
		btnAtualizarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizarCurso.setBounds(300, 181, 89, 23);
		tabAtualizarCurso.add(btnAtualizarCurso);
		btnAtualizarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setBounds(21, 11, 79, 19);
		
		JButton btnBuscarCurso = new JButton("Buscar");
		btnBuscarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCurso.setBounds(300, 11, 89, 23);
		tabAtualizarCurso.add(btnBuscarCurso);
		
		JTextArea taCursoLista = new JTextArea();
		taCursoLista.setBounds(21, 48, 267, 46);
		tabAtualizarCurso.add(taCursoLista);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(21, 154, 79, 19);
		tabAtualizarCurso.add(lblNome);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(21, 183, 79, 19);
		tabAtualizarCurso.add(lblArea);
		
// Aba Ler
		
		JPanel tabLerCurso = new JPanel();
		tabbedPane.addTab("Ler", null, tabLerCurso, "Ler Curso");
		tabLerCurso.setLayout(null);
		
		
		btnBuscarCurso = new JButton("Ler");
		btnBuscarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCurso.setBounds(338, 11, 73, 23);
		tabLerCurso.add(btnBuscarCurso);
				
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 12, 319, 191);
		tabLerCurso.add(textArea);	
		
		
// Aba Deletar
		
		JPanel tabDeletarCurso = new JPanel();
		tabbedPane.addTab("Deletar", null, tabDeletarCurso, "Deletar Curso");
		tabDeletarCurso.setLayout(null);
		
		
		lblCodigoCurso = new JLabel("Código");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabDeletarCurso.add(lblCodigoCurso);
		
		tfCodigoCursoDeletar = new JTextField();
		tfCodigoCursoDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoCursoDeletar.setBounds(90, 12, 197, 20);
		tabDeletarCurso.add(tfCodigoCursoDeletar);
		tfCodigoCursoDeletar.setColumns(10);
		
		JButton btnDeletarCurso = new JButton("Deletar");
		btnDeletarCurso.setBounds(161, 179, 89, 23);
		tabDeletarCurso.add(btnDeletarCurso);
		btnDeletarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setBounds(21, 11, 79, 19);
		
		btnBuscarCurso = new JButton("Buscar");
		btnBuscarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCurso.setBounds(300, 11, 89, 23);
		tabDeletarCurso.add(btnBuscarCurso);
		
		taCursoLista = new JTextArea();
		taCursoLista.setBounds(21, 48, 368, 120);
		tabDeletarCurso.add(taCursoLista);	
		
		CursoController cc = new CursoController(tfAreaCursoAtualizar, tfAreaCursoCriar, tfAreaCursoDeletar, tfAreaCursoLer, 
				tfCodigoCursoAtualizar, tfCodigoCursoCriar, tfCodigoCursoLer, tfCodigoCursoDeletar, 
				tfNomeCursoCriar, tfNomeCursoAtualizar, tfNomeCursoLer, tfNomeCursoDeletar);
		
		
		btnCriarCurso.addActionListener(cc);
		
		btnDeletarCurso.addActionListener(cc);

		btnBuscarCurso.addActionListener(cc);

		btnBuscarCurso.addActionListener(cc);
		
		btnBuscarCurso.addActionListener(cc);
		
		
	}
}