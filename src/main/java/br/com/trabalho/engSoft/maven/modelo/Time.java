package br.com.trabalho.engSoft.maven.modelo;

import java.util.ArrayList;
import java.util.List;

public class Time {

	private Integer id;
	private String nome;
	private Estadio estadio;
	private List<Jogador> jogadores;
	
	public Time(Integer id, String nome, Estadio estadio) {
		this.id = id;
		this.nome = nome;
		this.estadio = estadio;
		this.jogadores = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estadio getEstadio() {
		return estadio;
	}
	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public double calcularAlturaMedia() {
        if (jogadores.isEmpty()) {
            return 0.0;
        }

        double somaAlturas = 0.0;
        for (Jogador jogador : jogadores) {
            somaAlturas += jogador.getAltura();
        }

        return somaAlturas / jogadores.size();
    }
	
	public void adicionarJogador(Jogador jogador) {
		if (jogador.getTime() != null) {
            throw new IllegalArgumentException("O jogador já pertence a outro time.");
        }
        jogadores.add(jogador);
        jogador.setTime(this);
    }
    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }
}
