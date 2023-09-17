package br.com.trabalho.engSoft.maven.modelo;

public class Resultado {

	
	private Integer numGolsMandante;
	private Integer numGolsVisitante;
	
	public Resultado() {
	}
	
	public Resultado(Integer numGolsMandante, Integer numGolsVisitante) {
		this.numGolsMandante = numGolsMandante;
		this.numGolsVisitante = numGolsVisitante;
	}

	public Integer getNumGolsMandante() {
		return numGolsMandante;
	}
	public void setNumGolsMandante(Integer numGolsMandante) {
		this.numGolsMandante = numGolsMandante;
	}
	public Integer getNumGolsVisitante() {
		return numGolsVisitante;
	}
	public void setNumGolsVisitante(Integer numGolsVisitante) {
		this.numGolsVisitante = numGolsVisitante;
	}
	
	public Boolean jogoSaiuEmpatado() {
		return this.getNumGolsMandante().equals(this.getNumGolsVisitante());
	}
}
