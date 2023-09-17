package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PartidaTest {
	@Test
    public void testCriarPartidaValida() {
        // Crie um estádio
        Estadio estadio = new Estadio(1, "Estádio X", "Endereço X");

        // Crie dois times
        Time timeMandante = new Time(1, "Time Mandante", estadio);
        Time timeVisitante = new Time(2, "Time Visitante", estadio);

        // Crie uma data válida (futura)
        LocalDate data = LocalDate.now().plusDays(7);

        // Tente criar uma partida com times mandante e visitante válidos, data válida e estádio válido
        Partida partida = new Partida(timeMandante, timeVisitante, estadio, data);

        // Verifique se a partida foi criada com sucesso
        assertNotNull(partida);
    }

    @Test
    public void testCriarPartidaComTimesIguais() {
        // Crie um estádio
        Estadio estadio = new Estadio(1, "Estádio Y", "Endereço Y");

        // Crie um único time
        Time time = new Time(1, "Time Único", estadio);

        // Crie uma data válida (futura)
        LocalDate data = LocalDate.now().plusDays(7);

        // Tente criar uma partida com times mandante e visitante iguais (inválidos)
        assertThrows(IllegalArgumentException.class, () -> {
            new Partida(time, time, estadio, data);
        });
    }

    @Test
    public void testCriarPartidaComDataPassada() {
        // Crie um estádio
        Estadio estadio = new Estadio(1, "Estádio Z", "Endereço Z");

        // Crie dois times
        Time timeMandante = new Time(1, "Time A", estadio);
        Time timeVisitante = new Time(2, "Time B", estadio);

        // Crie uma data no passado (inválida)
        LocalDate data = LocalDate.now().minusDays(1);

        // Tente criar uma partida com data no passado (inválida)
        assertThrows(IllegalArgumentException.class, () -> {
            new Partida(timeMandante, timeVisitante, estadio, data);
        });
    }
}
