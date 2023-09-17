package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefinirResultadoEmpateTest {
	private Campeonato campeonato;
    private Estadio estadio;
    private Time timeA;
    private Time timeB;
    private Partida partida1;

    @BeforeEach
    public void setUp() {
        // Configuração comum para os testes
        campeonato = new Campeonato();
        estadio = new Estadio(1, "Estádio X", "Endereço X");
        timeA = new Time(1, "Time A", estadio);
        timeB = new Time(2, "Time B", estadio);

        // Crie uma partida com resultado de empate (0 a 0)
        LocalDate data1 = LocalDate.of(2023, 10, 1);
        partida1 = new Partida(timeA, timeB, estadio, data1);
        partida1.definirResultado(0, 0);

        // Adicione a partida ao campeonato
        campeonato.adicionarPartida(partida1);

        // Adicione os times ao campeonato
        campeonato.adicionarTime(timeA);
        campeonato.adicionarTime(timeB);
    }

    @Test
    public void testDefinirResultadoEmpate() {
        // Calcule a classificação após o empate
        Map<Time, Integer> classificacao = campeonato.calcularClassificacao();

        // Verifique se a classificação dos times foi atualizada corretamente
        assertEquals(1, classificacao.get(timeA));
        assertEquals(1, classificacao.get(timeB));
    }
}
