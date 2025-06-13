package model;

public class Disciplina {
	
	private int codigoDisciplina;
	private String nomeDisciplina;
	private String diaDisciplina;
	private String duracaoDisciplina;
	private String horaDisciplina;
	
	@Override
	public String toString() {
		return codigoDisciplina + "; " + nomeDisciplina +"; " + diaDisciplina + "; " 
	+ horaDisciplina + ";" + horaDisciplina;
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

	public void setDiaDisciplina(String diaSemana) {
		this.diaDisciplina = diaSemana;
	}

	public String getDuracaoDisclina() {
		return duracaoDisciplina;
	}

	public void setDuracaoDisciplina(String horasInicial) {
		this.duracaoDisciplina = horasInicial;
	}

	public String getHoraDisciplina() {
		return horaDisciplina;
	}

	public void setHoraDisciplina(String horasTotal) {
		this.horaDisciplina = horasTotal;
	}
	
	
}
