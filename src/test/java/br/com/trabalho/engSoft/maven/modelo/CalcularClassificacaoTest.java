package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcularClassificacaoTest {
	private Campeonato campeonato;
    private Estadio estadio;
    private Time timeA;
    private Time timeB;
    private Time timeC;
    private Partida partida1;
    private Partida partida2;
    private Partida partida3;

    @BeforeEach
    public void setUp() {
        // Configuração comum para os testes
        campeonato = new Campeonato();
        estadio = new Estadio(1, "Estádio X", "Endereço X");
        timeA = new Time(1, "Time A", estadio);
        timeB = new Time(2, "Time B", estadio);
        timeC = new Time(3, "Time C", estadio);

        // Crie três partidas com resultados diferentes
        LocalDate data1 = LocalDate.of(2023, 10, 1);
        LocalDate data2 = LocalDate.of(2023, 10, 5);
        LocalDate data3 = LocalDate.of(2023, 10, 10);

        partida1 = new Partida(timeA, timeB, estadio, data1);
        partida1.definirResultado(2, 1);

        partida2 = new Partida(timeB, timeC, estadio, data2);
        partida2.definirResultado(2, 2);

        partida3 = new Partida(timeA, timeC, estadio, data3);
        partida3.definirResultado(2, 1);

        // Adicione as partidas ao campeonato
        campeonato.adicionarPartida(partida1);
        campeonato.adicionarPartida(partida2);
        campeonato.adicionarPartida(partida3);

        // Adicione os times ao campeonato
        campeonato.adicionarTime(timeA);
        campeonato.adicionarTime(timeB);
        campeonato.adicionarTime(timeC);
    }

    @Test
    public void testCalcularClassificacao() {
        // Calcule a classificação
        Map<Time, Integer> classificacao = campeonato.calcularClassificacao();

        // Verifique se a classificação está correta com base nos resultados das partidas
        assertEquals(6, classificacao.get(timeA));
        assertEquals(1, classificacao.get(timeB));
        assertEquals(1, classificacao.get(timeC));
    }
}
