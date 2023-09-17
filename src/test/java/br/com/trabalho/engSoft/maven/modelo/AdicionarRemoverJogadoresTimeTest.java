package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdicionarRemoverJogadoresTimeTest {
	private Time time;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogador3;

    @BeforeEach
    public void setUp() {
        // Configuração comum para os testes
        Estadio estadio = new Estadio(1, "Estádio A", "Endereço A");
        time = new Time(1, "Time A", estadio);

        // Crie jogadores
        jogador1 = new Jogador(2, "Jogador 1", LocalDate.of(1990, 1, 1), "F", 1.70f);
        jogador2 = new Jogador(2, "Jogador 2", LocalDate.of(1990, 1, 1), "F", 1.70f);
        jogador3 = new Jogador(2, "Jogador 3", LocalDate.of(1990, 1, 1), "F", 1.70f);
    }

    @Test
    public void testAdicionarJogador() {
        // Adicione jogador1 ao time
        time.adicionarJogador(jogador1);

        // Verifique se jogador1 está na lista de jogadores do time
        assertTrue(time.getJogadores().contains(jogador1));
    }

    @Test
    public void testRemoverJogador() {
        // Adicione jogador1 e jogador2 ao time
        time.adicionarJogador(jogador1);
        time.adicionarJogador(jogador2);

        // Remova jogador1 do time
        time.removerJogador(jogador1);

        // Verifique se jogador1 não está mais na lista de jogadores do time
        assertFalse(time.getJogadores().contains(jogador1));

        // Verifique se jogador2 ainda está na lista de jogadores do time
        assertTrue(time.getJogadores().contains(jogador2));
    }

    @Test
    public void testAdicionarRemoverVariosJogadores() {
        // Adicione jogador1, jogador2 e jogador3 ao time
        time.adicionarJogador(jogador1);
        time.adicionarJogador(jogador2);
        time.adicionarJogador(jogador3);

        // Remova jogador2 do time
        time.removerJogador(jogador2);

        // Verifique se jogador2 não está mais na lista de jogadores do time
        assertFalse(time.getJogadores().contains(jogador2));

        // Verifique se jogador1 e jogador3 ainda estão na lista de jogadores do time
        assertTrue(time.getJogadores().contains(jogador1));
        assertTrue(time.getJogadores().contains(jogador3));
    }
}
