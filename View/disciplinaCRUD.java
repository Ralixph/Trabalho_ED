package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DisciplinaController;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class disciplinaCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigoDisciplinaCriar;
	private JTextField tfNomeDisciplinaCriar;
	private JTextField tfDiaDisciplinaCriar;
	private JTextField tfDuracaoDisciplinaCriar;
	private JTextField tfHoraDisciplinaCriar;
	private JTextField tfCodigoDisciplinaAtualizar;
	private JTextField tfNomeDisciplinaAtualizar;
	private JTextField tfDiaDisciplinaAtualizar;
	private JTextField tfDuracaoDisciplinaAtualizar;
	private JTextField tfHoraDisciplinaAtualizar;
	private JTextField tfCodigoDisciplinaDeletar;

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
		
		tfCodigoDisciplinaCriar = new JTextField();
		tfCodigoDisciplinaCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoDisciplinaCriar.setBounds(90, 12, 197, 20);
		TabCriarDisciplina.add(tfCodigoDisciplinaCriar);
		tfCodigoDisciplinaCriar.setColumns(10);
		
		JLabel lblNomeDisciplina = new JLabel("Nome");
		lblNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDisciplina.setBounds(21, 41, 79, 19);
		TabCriarDisciplina.add(lblNomeDisciplina);
		
		tfNomeDisciplinaCriar = new JTextField();
		tfNomeDisciplinaCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeDisciplinaCriar.setColumns(10);
		tfNomeDisciplinaCriar.setBounds(90, 42, 197, 20);
		TabCriarDisciplina.add(tfNomeDisciplinaCriar);
		
		JLabel lblDiaDisciplina = new JLabel("Dia");
		lblDiaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDisciplina.setBounds(21, 71, 79, 19);
		TabCriarDisciplina.add(lblDiaDisciplina);
		
		tfDiaDisciplinaCriar = new JTextField();
		tfDiaDisciplinaCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDiaDisciplinaCriar.setColumns(10);
		tfDiaDisciplinaCriar.setBounds(90, 72, 197, 20);
		TabCriarDisciplina.add(tfDiaDisciplinaCriar);
		
		JLabel lblDuraçãoDisciplina = new JLabel("Duração");
		lblDuraçãoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuraçãoDisciplina.setBounds(21, 101, 79, 19);
		TabCriarDisciplina.add(lblDuraçãoDisciplina);
		
		tfDuracaoDisciplinaCriar = new JTextField();
		tfDuracaoDisciplinaCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDuracaoDisciplinaCriar.setColumns(10);
		tfDuracaoDisciplinaCriar.setBounds(90, 101, 197, 20);
		TabCriarDisciplina.add(tfDuracaoDisciplinaCriar);
		
		JLabel lblHoraDisciplina = new JLabel("Hora");
		lblHoraDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraDisciplina.setBounds(21, 131, 79, 19);
		TabCriarDisciplina.add(lblHoraDisciplina);
		
		tfHoraDisciplinaCriar = new JTextField();
		tfHoraDisciplinaCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfHoraDisciplinaCriar.setColumns(10);
		tfHoraDisciplinaCriar.setBounds(90, 131, 197, 20);
		TabCriarDisciplina.add(tfHoraDisciplinaCriar);
		
		JButton btnCriarDisciplina = new JButton("Criar");
		btnCriarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarDisciplina.setBounds(300, 166, 89, 23);
		TabCriarDisciplina.add(btnCriarDisciplina);
		
		JPanel TabAtualizarDisciplina = new JPanel();
		tabbedPane.addTab("Atualizar", null, TabAtualizarDisciplina, "Atualizar Disciplina");
		TabAtualizarDisciplina.setLayout(null);
		
		JLabel lblcodigo = new JLabel("código");
		lblcodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcodigo.setBounds(21, 11, 79, 19);
		TabAtualizarDisciplina.add(lblcodigo);
		
		tfCodigoDisciplinaAtualizar = new JTextField();
		tfCodigoDisciplinaAtualizar.setBounds(90, 12, 197, 20);
		TabAtualizarDisciplina.add(tfCodigoDisciplinaAtualizar);
		tfCodigoDisciplinaAtualizar.setColumns(10);
		
		JButton btnBuscarDisciplinaAtualizar = new JButton("Buscar_AT");
		btnBuscarDisciplinaAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDisciplinaAtualizar.setBounds(300, 11, 89, 23);
		TabAtualizarDisciplina.add(btnBuscarDisciplinaAtualizar);
		
		JTextArea taDisciplinaAtualizar = new JTextArea();
		taDisciplinaAtualizar.setBounds(21, 39, 266, 34);
		TabAtualizarDisciplina.add(taDisciplinaAtualizar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(21, 84, 79, 19);
		TabAtualizarDisciplina.add(lblNome);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDia.setBounds(21, 114, 79, 19);
		TabAtualizarDisciplina.add(lblDia);
		
		JLabel lblDuracao = new JLabel("Duração");
		lblDuracao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracao.setBounds(21, 144, 79, 19);
		TabAtualizarDisciplina.add(lblDuracao);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora.setBounds(21, 174, 79, 19);
		TabAtualizarDisciplina.add(lblHora);
		
		tfNomeDisciplinaAtualizar = new JTextField();
		tfNomeDisciplinaAtualizar.setColumns(10);
		tfNomeDisciplinaAtualizar.setBounds(90, 85, 197, 20);
		TabAtualizarDisciplina.add(tfNomeDisciplinaAtualizar);
		
		tfDiaDisciplinaAtualizar = new JTextField();
		tfDiaDisciplinaAtualizar.setColumns(10);
		tfDiaDisciplinaAtualizar.setBounds(90, 115, 197, 20);
		TabAtualizarDisciplina.add(tfDiaDisciplinaAtualizar);
		
		tfDuracaoDisciplinaAtualizar = new JTextField();
		tfDuracaoDisciplinaAtualizar.setColumns(10);
		tfDuracaoDisciplinaAtualizar.setBounds(90, 145, 197, 20);
		TabAtualizarDisciplina.add(tfDuracaoDisciplinaAtualizar);
		
		tfHoraDisciplinaAtualizar = new JTextField();
		tfHoraDisciplinaAtualizar.setColumns(10);
		tfHoraDisciplinaAtualizar.setBounds(90, 175, 197, 20);
		TabAtualizarDisciplina.add(tfHoraDisciplinaAtualizar);
		
		JButton btnAtualizarDisciplina = new JButton("Atualizar");
		btnAtualizarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarDisciplina.setBounds(300, 174, 89, 23);
		TabAtualizarDisciplina.add(btnAtualizarDisciplina);
		
		JPanel TabLerDisciplina = new JPanel();
		tabbedPane.addTab("Ler", null, TabLerDisciplina, "Ler Disciplina");
		TabLerDisciplina.setLayout(null);
		
		JTextArea taDisciplinaLer = new JTextArea();
		taDisciplinaLer.setBounds(10, 12, 319, 191);
		TabLerDisciplina.add(taDisciplinaLer);
		
		JButton btnLerDisciplina = new JButton("Ler");
		btnLerDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerDisciplina.setBounds(338, 11, 73, 23);
		TabLerDisciplina.add(btnLerDisciplina);
		
		JPanel TabDeletarDisciplina = new JPanel();
		tabbedPane.addTab("Deletar", null, TabDeletarDisciplina, "Deletar");
		TabDeletarDisciplina.setLayout(null);
		
		JLabel lblCodigoDisciplina = new JLabel("Código");
		lblCodigoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDisciplina.setBounds(21, 11, 79, 19);
		TabDeletarDisciplina.add(lblCodigoDisciplina);
		
		tfCodigoDisciplinaDeletar = new JTextField();
		tfCodigoDisciplinaDeletar.setBounds(90, 12, 197, 20);
		TabDeletarDisciplina.add(tfCodigoDisciplinaDeletar);
		tfCodigoDisciplinaDeletar.setColumns(10);
		
		JButton btnBuscarDisciplinaDeletar = new JButton("Buscar_DL");
		btnBuscarDisciplinaDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDisciplinaDeletar.setBounds(300, 11, 89, 23);
		TabDeletarDisciplina.add(btnBuscarDisciplinaDeletar);
		
		JTextArea taDisciplinaDeletar = new JTextArea();
		taDisciplinaDeletar.setBounds(21, 48, 368, 120);
		TabDeletarDisciplina.add(taDisciplinaDeletar);
		
		JButton btnDeletarDisciplina = new JButton("Deletar");
		btnDeletarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarDisciplina.setBounds(161, 179, 89, 23);
		TabDeletarDisciplina.add(btnDeletarDisciplina);
		
		DisciplinaController dCont = new DisciplinaController(tfCodigoDisciplinaCriar, tfNomeDisciplinaCriar, tfDuracaoDisciplinaCriar, tfHoraDisciplinaCriar, tfDiaDisciplinaCriar,
				tfCodigoDisciplinaAtualizar, tfNomeDisciplinaAtualizar, tfDuracaoDisciplinaAtualizar, tfHoraDisciplinaAtualizar, tfDiaDisciplinaAtualizar,
				taDisciplinaAtualizar, taDisciplinaLer,
				tfCodigoDisciplinaDeletar, taDisciplinaDeletar
			);
			
			btnCriarDisciplina.addActionListener(dCont);

			btnBuscarDisciplinaAtualizar.addActionListener(dCont);
			
			btnAtualizarDisciplina.addActionListener(dCont);

			btnLerDisciplina.addActionListener(dCont);

			btnBuscarDisciplinaDeletar.addActionListener(dCont);
			
			btnDeletarDisciplina.addActionListener(dCont);
	}
}
