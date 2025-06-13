package model;

public class Disciplina {
	
	private int codigoDisciplina;
	private String nomeDisciplina;
	private String diaSemana;
	private String horasInicial;
	private String horasTotal;
	
	@Override
	public String toString() {
		return codigoDisciplina + "; " + nomeDisciplina +"; " + diaSemana + "; " 
	+ horasInicial + ";" + horasTotal;
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

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorasInicial() {
		return horasInicial;
	}

	public void setHorasInicial(String horasInicial) {
		this.horasInicial = horasInicial;
	}

	public String getHorasTotal() {
		return horasTotal;
	}

	public void setHorasTotal(String horasTotal) {
		this.horasTotal = horasTotal;
	}
	
	
}
