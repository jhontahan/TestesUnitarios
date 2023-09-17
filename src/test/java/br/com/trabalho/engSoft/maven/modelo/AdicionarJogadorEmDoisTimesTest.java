package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdicionarJogadorEmDoisTimesTest {
	private Time timeA;
    private Time timeB;
    private Jogador jogador1;
    private Jogador jogador2;

    @BeforeEach
    public void setUp() {
        // Configuração comum para os testes
        Estadio estadioA = new Estadio(1, "Estádio A", "Endereço A");
        Estadio estadioB = new Estadio(2, "Estádio B", "Endereço B");

        timeA = new Time(1, "Time A", estadioA);
        timeB = new Time(2, "Time B", estadioB);

        jogador1 = new Jogador(1, "Jogador 1", LocalDate.of(1990, 1, 1), "F", 1.70f);
        jogador2 = new Jogador(2, "Jogador 2", LocalDate.of(1990, 1, 1), "F", 1.70f);
    }

    @Test
    public void testAdicionarJogadorApenasUmTime() {
        // Adicione jogador1 ao timeA (deve ser bem-sucedido)
        timeA.adicionarJogador(jogador1);

        // Verifique se o jogador1 está na lista de jogadores do timeA
        assertTrue(timeA.getJogadores().contains(jogador1));

        // Verifique se o jogador1 pertence ao timeA
        assertEquals(timeA, jogador1.getTime());
    }

    @Test
    public void testAdicionarJogadorDoisTimes() {
        // Adicione jogador1 ao timeA (deve ser bem-sucedido)
        timeA.adicionarJogador(jogador1);

        // Tente adicionar jogador1 ao timeB (deve lançar uma exceção)
        assertThrows(IllegalArgumentException.class, () -> {
            timeB.adicionarJogador(jogador1);
        });

        // Verifique se o jogador1 ainda pertence ao timeA
        assertEquals(timeA, jogador1.getTime());
    }

    @Test
    public void testAdicionarJogadorDiferentesTimes() {
        // Adicione jogador1 ao timeA (deve ser bem-sucedido)
        timeA.adicionarJogador(jogador1);

        // Adicione jogador2 ao timeB (deve ser bem-sucedido)
        timeB.adicionarJogador(jogador2);

        // Verifique se jogador1 pertence ao timeA
        assertEquals(timeA, jogador1.getTime());

        // Verifique se jogador2 pertence ao timeB
        assertEquals(timeB, jogador2.getTime());
    }
}
