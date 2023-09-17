package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultadoPartidaTest {
	private Partida partida;

    @BeforeEach
    public void setUp() {
        // Configuração comum para os testes
        Estadio estadio = new Estadio(1, "Estádio X", "Endereço X");
        Time timeA = new Time(1, "Time A", estadio);
        Time timeB = new Time(2, "Time B", estadio);
        LocalDate data = LocalDate.now().plusDays(7);

        partida = new Partida(timeA, timeB, estadio, data);
    }

    @Test
    public void testDefinirResultadoValido() {
        // Defina um resultado válido para a partida
        partida.definirResultado(2, 1);

        // Verifique se o resultado foi definido com sucesso
        assertEquals(2, partida.getResultado().getNumGolsMandante());
        assertEquals(1, partida.getResultado().getNumGolsVisitante());
    }

    @Test
    public void testDefinirResultadoNegativoTimeMandante() {
        // Tente definir um resultado com gols negativos para o time mandante (deve lançar uma exceção)
        assertThrows(IllegalArgumentException.class, () -> {
            partida.definirResultado(-1, 0);
        });
    }

    @Test
    public void testDefinirResultadoNegativoTimeVisitante() {
        // Tente definir um resultado com gols negativos para o time visitante (deve lançar uma exceção)
        assertThrows(IllegalArgumentException.class, () -> {
            partida.definirResultado(0, -1);
        });
    }

    @Test
    public void testDefinirResultadoNegativoAmbosTimes() {
        // Tente definir um resultado com gols negativos para ambos os times (deve lançar uma exceção)
        assertThrows(IllegalArgumentException.class, () -> {
            partida.definirResultado(-1, -1);
        });
    }
}
