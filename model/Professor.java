package model;

public class Professor {

	private double CPFProfessor;
	private String nomeProfessor;
	private String areaProfessor;
	private int pontosProfessor;
	
	public Professor(double cPFProfessor2, String nomeProfessor2, String areaProfessor2, int pontosProfessor2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return CPFProfessor + ";" + nomeProfessor + ";"
				+ areaProfessor + ";" + pontosProfessor;
	}
}
