package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class TelaCrud extends JFrame {

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
		
		JPanel tabProfessor = new JPanel();
		tabbedPane.addTab("Professor", null, tabProfessor, "Professor");
		tabProfessor.setLayout(null);
		
		JButton btnCriarProfessor = new JButton("Criar");
		btnCriarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarProfessor.setBounds(36, 43, 89, 23);
		tabProfessor.add(btnCriarProfessor);
		
		JButton btnDeletarProfessor = new JButton("Deletar");
		btnDeletarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarProfessor.setBounds(252, 45, 89, 23);
		tabProfessor.add(btnDeletarProfessor);
		
		JButton btnAtualizarProfessor = new JButton("Atualizar");
		btnAtualizarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarProfessor.setBounds(36, 116, 89, 23);
		tabProfessor.add(btnAtualizarProfessor);
		
		JButton btnLerProfessor = new JButton("Ler");
		btnLerProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerProfessor.setBounds(252, 118, 89, 23);
		tabProfessor.add(btnLerProfessor);
		
		JPanel tabCurso = new JPanel();
		tabbedPane.addTab("Curso", null, tabCurso, "Curso");
		tabCurso.setLayout(null);
		
		JButton btnCriarCurso = new JButton("Criar");
		btnCriarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarCurso.setBounds(36, 43, 89, 23);
		tabCurso.add(btnCriarCurso);
		
		JButton btnDeletarCurso = new JButton("Deletar");
		btnDeletarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarCurso.setBounds(252, 45, 89, 23);
		tabCurso.add(btnDeletarCurso);
		
		JButton btnAtualizarCurso = new JButton("Atualizar");
		btnAtualizarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarCurso.setBounds(36, 116, 89, 23);
		tabCurso.add(btnAtualizarCurso);
		
		JButton btnLerCurso = new JButton("Ler");
		btnLerCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerCurso.setBounds(252, 118, 89, 23);
		tabCurso.add(btnLerCurso);
		
		JPanel tabInscricao = new JPanel();
		tabbedPane.addTab("Inscricao", null, tabInscricao, "Inscricao");
		tabInscricao.setLayout(null);
		
		JButton btnCriarInscricao = new JButton("Criar");
		btnCriarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarInscricao.setBounds(36, 43, 89, 23);
		tabInscricao.add(btnCriarInscricao);
		
		JButton btnDeletarInscricao = new JButton("Deletar");
		btnDeletarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarInscricao.setBounds(252, 45, 89, 23);
		tabInscricao.add(btnDeletarInscricao);
		
		JButton btnAtualizarInscricao = new JButton("Atualizar");
		btnAtualizarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarInscricao.setBounds(36, 116, 89, 23);
		tabInscricao.add(btnAtualizarInscricao);
		
		JButton btnLerInscricao = new JButton("Ler");
		btnLerInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerInscricao.setBounds(252, 118, 89, 23);
		tabInscricao.add(btnLerInscricao);
		
		JPanel tabDisciplina = new JPanel();
		tabbedPane.addTab("New tab", null, tabDisciplina, null);
		tabDisciplina.setLayout(null);
		
		JButton btnCriarDisciplina = new JButton("Criar");
		btnCriarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarDisciplina.setBounds(36, 43, 89, 23);
		tabDisciplina.add(btnCriarDisciplina);
		
		JButton btnDeletarDisciplina = new JButton("Deletar");
		btnDeletarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarDisciplina.setBounds(252, 45, 89, 23);
		tabDisciplina.add(btnDeletarDisciplina);
		
		JButton btnAtualizarDisciplina = new JButton("Atualizar");
		btnAtualizarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarDisciplina.setBounds(36, 116, 89, 23);
		tabDisciplina.add(btnAtualizarDisciplina);
		
		JButton btnLerDisciplina = new JButton("Ler");
		btnLerDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLerDisciplina.setBounds(252, 118, 89, 23);
		tabDisciplina.add(btnLerDisciplina);
	}
}
