package Interface;

import java.io.IOException;

import model.Professor;

public interface ICRUD {

	public void Criar() throws IOException;
	public void Deletar() throws IOException, Exception;
	public void Atualizar() throws IOException, Exception;
	public void Ler() throws IOException, Exception;
}
