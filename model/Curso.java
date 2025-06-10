package model;

public class Curso {
	
	private int codigoCurso;
	private String nomeCurso;
	private String areaCurso;


	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getAreaCurso() {
		return areaCurso;
	}

	public void setAreaCurso(String areaCurso) {
		this.areaCurso = areaCurso;
	}
	
	@Override
	public String toString() {
		return codigoCurso + "; " + nomeCurso + "; " + areaCurso;
	}
	
}
