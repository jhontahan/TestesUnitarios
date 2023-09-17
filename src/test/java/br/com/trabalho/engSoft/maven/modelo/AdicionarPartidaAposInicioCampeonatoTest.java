package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdicionarPartidaAposInicioCampeonatoTest {
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

        // Defina a data de início do campeonato para uma data futura
        LocalDate dataInicio = LocalDate.of(2023, 9, 1);
        campeonato.setDataInicio(dataInicio);

        // Crie uma partida com data posterior à data de início do campeonato
        LocalDate data1 = LocalDate.of(2023, 10, 1);
        partida1 = new Partida(timeA, timeB, estadio, data1);
    }

    @Test
    public void testAdicionarPartidaAposInicioCampeonato() {
        // Avance a data atual para depois do início do campeonato
        campeonato.setDataInicio(LocalDate.now().minusDays(1));

        // Tente adicionar a partida1 após o início do campeonato (deve lançar exceção)
        assertThrows(IllegalArgumentException.class, () -> {
        	campeonato.adicionarPartida(partida1);
        });
    }
}
