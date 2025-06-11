package Interface;

import java.io.IOException;

import model.Professor;

public interface IProcura {

	public void Criar() throws IOException;
	public void Deletar() throws IOException;
	public void Atualizar() throws IOException, Exception;
	public void Ler() throws IOException, Exception;
	public void Buscar() throws IOException;
	
}
