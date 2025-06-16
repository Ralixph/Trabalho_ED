package View;

import javax.swing.*;
import java.awt.*;

public class ErroTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea taErros;

    public ErroTela() {
        setTitle("Erros Encontrados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        taErros = new JTextArea();
        taErros.setEditable(false);
        taErros.setLineWrap(true);
        taErros.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(taErros);
        add(scroll, BorderLayout.CENTER);
    }
    
    public void mostrarErros(String mensagem) {
        taErros.setText(mensagem);
        setVisible(true);
        toFront();
    }
}