package model;

public class Disciplina {
	
	private int codigoDisciplina;
	private String nomeDisciplina;
	private String diaDisciplina;
	private String duracaoDisciplina;
	private String horaDisciplina;
	
	@Override
	public String toString() {
		return codigoDisciplina + ";" + nomeDisciplina +";" + diaDisciplina + ";" 
	+ duracaoDisciplina + ";" + horaDisciplina;
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getDiaDisciplina() {
		return diaDisciplina;
	}

	public void setDiaDisciplina(String diaDisciplina) {
	    this.diaDisciplina = diaDisciplina;
	}

	public String getDuracaoDisciplina() {
		return duracaoDisciplina;
	}

	public void setDuracaoDisciplina(String duracaoDisciplina) {
	    this.duracaoDisciplina = duracaoDisciplina;
	}

	public String getHoraDisciplina() {
		return horaDisciplina;
	}

	public void setHoraDisciplina(String horaDisciplina) {
	    this.horaDisciplina = horaDisciplina;
	}
	
	
}
