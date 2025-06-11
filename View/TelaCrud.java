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

public class TelaCrud extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCrud frame = new TelaCrud();
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
	public TelaCrud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 416, 241);
		contentPane.add(tabbedPane);
		
		JPanel tabConcurso = new JPanel();
		tabbedPane.addTab("Concurso", null, tabConcurso, "Professor");
		tabConcurso.setLayout(null);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessor.setBounds(40, 43, 138, 23);
		tabConcurso.add(btnProfessor);
		
		JButton btnCurso = new JButton("Curso");
		btnCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCurso.setBounds(223, 43, 138, 23);
		tabConcurso.add(btnCurso);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDisciplina.setBounds(40, 116, 138, 23);
		tabConcurso.add(btnDisciplina);
		
		JButton btnInscricao = new JButton("Inscricao");
		btnInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInscricao.setBounds(223, 116, 138, 23);
		tabConcurso.add(btnInscricao);
		
	// Adicionando os ActionListeners:
		
		
			btnProfessor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ProfessorCRUD().setVisible(true);
				}
			});

			btnCurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CursoCRUD().setVisible(true);
				}
			});

			btnDisciplina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DisciplinaCRUD().setVisible(true);
				}
			});

			btnInscricao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InscricaoCRUD().setVisible(true);
				}
			});
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
