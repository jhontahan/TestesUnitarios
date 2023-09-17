package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AlturaMediaJogadoresTest {
	@Test
    public void testCalcularAlturaMedia() {
        // Crie um time
        Estadio estadio = new Estadio(1, "Allianz Parque", "Parmera");
        Time time = new Time(1, "Palmeiras", estadio);

        // Crie jogadores com diferentes alturas
        Jogador jogador1 = new Jogador(1, "Jogador 1", LocalDate.of(1990, 1, 1), "M", 1.80f);
        Jogador jogador2 = new Jogador(2, "Jogador 2", LocalDate.of(1995, 2, 2), "F", 1.70f);
        Jogador jogador3 = new Jogador(3, "Jogador 3", LocalDate.of(1998, 3, 3), "F", 1.75f);

        // Adicione os jogadores ao time
        time.adicionarJogador(jogador1);
        time.adicionarJogador(jogador2);
        time.adicionarJogador(jogador3);

        // Calcule a altura média esperada (deve ser 1.75)
        double alturaMediaEsperada = 1.75;

        // Obtenha a altura média calculada pelo método calcularAlturaMedia
        double alturaMediaCalculada = time.calcularAlturaMedia();

        // Verifique se a altura média calculada é igual à altura média esperada
        assertEquals(alturaMediaEsperada, alturaMediaCalculada, 0.01); // Usamos uma margem de erro de 0.01 devido a possíveis arredondamentos
    }

    @Test
    public void testCalcularAlturaMediaSemJogadores() {
        // Crie um time sem jogadores
    	Estadio estadio = new Estadio(1, "Allianz Parque", "Parmera");
        Time time = new Time(1, "Palmeiras", estadio);

        // A altura média deve ser 0 quando não há jogadores
        double alturaMediaEsperada = 0.0;

        // Obtenha a altura média calculada pelo método calcularAlturaMedia
        double alturaMediaCalculada = time.calcularAlturaMedia();

        // Verifique se a altura média calculada é igual à altura média esperada
        assertEquals(alturaMediaEsperada, alturaMediaCalculada, 0.01);
    }
}
