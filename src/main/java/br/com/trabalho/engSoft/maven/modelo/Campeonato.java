package br.com.trabalho.engSoft.maven.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Campeonato {
	
	private Integer id;
	private Integer ano;
	private String nome;
	private List<Partida> partidas;
	private List<Time> times;
	private LocalDate dataInicio;
	
	public Campeonato(Integer id, Integer ano, String nome) {
		this.id = id;
		this.ano = ano;
		this.nome = nome;
        dataInicio = LocalDate.now();

	}

	public Campeonato() {
		this.times = new ArrayList<>();
        this.partidas = new ArrayList<>();
        dataInicio = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void adicionarTime(Time time) {
        if (times.contains(time)) {
            throw new IllegalArgumentException("O time já está no campeonato.");
        }
        times.add(time);
    }

    public void adicionarPartida(Partida partida) {
    	if (partida.getData().isAfter(this.dataInicio)) {
            throw new IllegalArgumentException("Não é possível adicionar partidas após o início do campeonato.");
        }
        partidas.add(partida);
    }
    
    public List<Partida> filtrarPartidasPorData(LocalDate data) {
        return partidas.stream()
                .filter(partida -> partida.getData().isEqual(data))
                .collect(Collectors.toList());
    }

    public List<Partida> filtrarPartidasPorEstadio(Estadio estadio) {
        return partidas.stream()
                .filter(partida -> partida.getEstadio().equals(estadio))
                .collect(Collectors.toList());
    }

    public List<Partida> filtrarPartidasPorTimeMandante(Time time) {
        return partidas.stream()
                .filter(partida -> partida.getTimeMandante().equals(time))
                .collect(Collectors.toList());
    }
    
    public boolean verificarEstadioPartida(Partida partida) {
        Estadio estadioMandante = partida.getTimeMandante().getEstadio();
        Estadio estadioVisitante = partida.getTimeVisitante().getEstadio();
        Estadio estadioPartida = partida.getEstadio();

        return estadioPartida.equals(estadioMandante) || estadioPartida.equals(estadioVisitante);
    }
    
    public Map<Time, Integer> calcularClassificacao() {
        Map<Time, Integer> classificacao = new HashMap<>();

        for (Time time : times) {
            classificacao.put(time, 0);
        }

        for (Partida partida : partidas) {
            int golsMandante = partida.getResultado().getNumGolsMandante();
            int golsVisitante = partida.getResultado().getNumGolsVisitante();

            if (golsMandante > golsVisitante) {
                classificacao.put(partida.getTimeMandante(), classificacao.get(partida.getTimeMandante()) + 3);
            } else if (golsMandante < golsVisitante) {
                classificacao.put(partida.getTimeVisitante(), classificacao.get(partida.getTimeVisitante()) + 3);
            } else {
                classificacao.put(partida.getTimeMandante(), classificacao.get(partida.getTimeMandante()) + 1);
                classificacao.put(partida.getTimeVisitante(), classificacao.get(partida.getTimeVisitante()) + 1);
            }
        }

        return classificacao;
    }


}
