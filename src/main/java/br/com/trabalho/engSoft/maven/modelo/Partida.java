package br.com.trabalho.engSoft.maven.modelo;

import java.time.LocalDate;

public class Partida {
	private Integer id;
	private LocalDate data;
	private Time timeMandante;
	private Time timeVisitante;
	private Resultado resultado;
	private Estadio estadio;
	
	public Partida(Time timeMandante, Time timeVisitante, Estadio estadio, LocalDate data) {
        validarPartida(timeMandante, timeVisitante, estadio, data);

        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
        this.estadio = estadio;
        this.data = data;
        this.resultado = new Resultado();
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Time getTimeMandante() {
		return timeMandante;
	}
	public void setTimeMandante(Time timeMandante) {
		this.timeMandante = timeMandante;
	}
	public Time getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	private void validarPartida(Time timeMandante, Time timeVisitante, Estadio estadio, LocalDate data) {
        if (timeMandante == null || timeVisitante == null || estadio == null || data == null) {
            throw new IllegalArgumentException("Os times mandante e visitante, o estádio e a data são obrigatórios.");
        }
        if (timeMandante.equals(timeVisitante)) {
            throw new IllegalArgumentException("Os times mandante e visitante não podem ser iguais.");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data da partida deve ser no futuro.");
        }
    }
	
	public void definirResultado(int golsTimeMandante, int golsTimeVisitante) {
		if (golsTimeMandante < 0 || golsTimeVisitante < 0) {
            throw new IllegalArgumentException("Os gols não podem ser negativos.");
        }
        resultado.setNumGolsMandante(golsTimeMandante);
        resultado.setNumGolsVisitante(golsTimeVisitante);
    }
}
