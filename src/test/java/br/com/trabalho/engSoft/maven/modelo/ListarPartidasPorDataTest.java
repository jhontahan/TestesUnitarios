package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListarPartidasPorDataTest {
	private Campeonato campeonato;
    private Estadio estadio;
    private Time timeA;
    private Time timeB;
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

        // Crie três partidas com datas diferentes
        LocalDate data1 = LocalDate.of(2023, 10, 1);
        LocalDate data2 = LocalDate.of(2023, 10, 5);
        LocalDate data3 = LocalDate.of(2023, 10, 10);

        partida1 = new Partida(timeA, timeB, estadio, data1);
        partida2 = new Partida(timeB, timeA, estadio, data2);
        partida3 = new Partida(timeA, timeB, estadio, data3);

        // Adicione as partidas ao campeonato
        campeonato.adicionarPartida(partida1);
        campeonato.adicionarPartida(partida2);
        campeonato.adicionarPartida(partida3);
    }

    @Test
    public void testListarPartidasPorData() {
        // Liste as partidas da data 2023-10-05
        LocalDate dataFiltro = LocalDate.of(2023, 10, 5);
        List<Partida> partidasListadas = campeonato.filtrarPartidasPorData(dataFiltro);

        // Verifique se a lista contém apenas a partida2
        assertEquals(1, partidasListadas.size());
        assertTrue(partidasListadas.contains(partida2));
    }

    @Test
    public void testListarPartidasPorDataSemPartidas() {
        // Liste as partidas de uma data em que não existem partidas (2023-11-01)
        LocalDate dataFiltro = LocalDate.of(2023, 11, 1);
        List<Partida> partidasListadas = campeonato.filtrarPartidasPorData(dataFiltro);

        // Verifique se a lista está vazia
        assertTrue(partidasListadas.isEmpty());
    }
}
