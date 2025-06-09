package model;

public class Disciplina {
	
	private int codigoDisciplina;
	private String nomeDisciplina;
	private String diaSemana;
	private String horasInicial;
	private int horasTotal;
	
	@Override
	public String toString() {
		return codigoDisciplina + ";" + nomeDisciplina +";" + diaSemana + ";" 
	+ horasInicial + ";" + horasTotal;
	}
	
	
}
