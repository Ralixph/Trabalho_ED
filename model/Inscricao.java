package model;

public class Inscricao {

	private int codigoProcesso;

	@Override
	public String toString() {
		return Integer.toString(codigoProcesso);
	}

	public int getCodigoProcesso() {
		return codigoProcesso;
	}

	public void setCodigoProcesso(int codigoProcesso) {
		this.codigoProcesso = codigoProcesso;
	}
	
	
	
}
