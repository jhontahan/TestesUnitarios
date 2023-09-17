package br.com.trabalho.engSoft.maven.modelo;

import java.time.LocalDate;
import java.time.Period;

public class Jogador {

	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private String genero;
	private float altura;
	private Time time;
	
	public Jogador(Integer id, String nome, LocalDate dataNascimento, String genero, float altura) {
		if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento no futuro não é permitida.");
        }
        if (altura < 0) {
            throw new IllegalArgumentException("Altura não pode ser negativa.");
        }
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.altura = altura;
		//this.time = time;
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        return periodo.getYears();
    }
}
