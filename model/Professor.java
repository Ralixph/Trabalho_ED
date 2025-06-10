package model;

public class Professor {

	private double CPFProfessor;
	private String nomeProfessor;
	private String areaProfessor;
	private int pontosProfessor;
	
	public Professor(double cPFProfessor2, String nomeProfessor2, String areaProfessor2, int pontosProfessor2) {
		// TODO Auto-generated constructor stub
	}

	public double getCPFProfessor() {
		return CPFProfessor;
	}

	public void setCPFProfessor(double cPFProfessor) {
		CPFProfessor = cPFProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getAreaProfessor() {
		return areaProfessor;
	}

	public void setAreaProfessor(String areaProfessor) {
		this.areaProfessor = areaProfessor;
	}

	public int getPontosProfessor() {
		return pontosProfessor;
	}

	public void setPontosProfessor(int pontosProfessor) {
		this.pontosProfessor = pontosProfessor;
	}

	public Professor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return CPFProfessor + ";" + nomeProfessor + ";"
				+ areaProfessor + ";" + pontosProfessor;
	}
}
