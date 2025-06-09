package model;

public class Curso {
	
	private int codigoCurso;
	private String nomeCurso;
	private String areaCurso;

	@Override
	public String toString() {
		return codigoCurso + ";" + nomeCurso + ";" + areaCurso;
	}
}
