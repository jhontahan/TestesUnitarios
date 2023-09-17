package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VerificarEstadioPartidaTest {
	private Campeonato campeonato;
    private Estadio estadioA;
    private Estadio estadioB;
    private Time timeA;
    private Time timeB;
    private Partida partida1;
    private Partida partida2;

    @BeforeEach
    public void setUp() {
        // Configuração comum para os testes
        campeonato = new Campeonato();
        estadioA = new Estadio(1, "Estádio A", "Endereço A");
        estadioB = new Estadio(2, "Estádio B", "Endereço B");
        timeA = new Time(1, "Time A", estadioA);
        timeB = new Time(2, "Time B", estadioB);

        // Crie duas partidas com estádios diferentes
        partida1 = new Partida(timeA, timeB, estadioA, LocalDate.now().plusDays(7));
        partida2 = new Partida(timeB, timeA, estadioB, LocalDate.now().plusDays(14));

        // Adicione as partidas ao campeonato
        campeonato.adicionarPartida(partida1);
        campeonato.adicionarPartida(partida2);
    }

    @Test
    public void testVerificarEstadioPartida() {
        // Verifique se o estádio da partida1 corresponde ao estádio-sede do time mandante (Estádio A)
        assertTrue(campeonato.verificarEstadioPartida(partida1));

        // Verifique se o estádio da partida2 corresponde ao estádio-sede do time visitante (Estádio B)
        assertTrue(campeonato.verificarEstadioPartida(partida2));
    }

    @Test
    public void testVerificarEstadioPartidaIncorrespondente() {
        // Crie uma partida com estádio que não corresponde ao estádio-sede de nenhum time
        Partida partida3 = new Partida(timeA, timeB, new Estadio(1, "Estádio C", "Endereço C"), LocalDate.now().plusDays(21));

        // Verifique se o estádio da partida3 não corresponde ao estádio-sede de nenhum time
        assertFalse(campeonato.verificarEstadioPartida(partida3));
    }
}
