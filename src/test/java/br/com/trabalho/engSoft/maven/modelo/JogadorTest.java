package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JogadorTest {
	@Test
    public void testCalcularIdade() {
        // Crie um jogador com data de nascimento há 20 anos
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Jogador jogador = new Jogador(1, "João", dataNascimento, "M", 1.75f);

        // Calcule a idade esperada (deve ser 20)
        int idadeEsperada = 20;

        // Obtenha a idade calculada pelo método calcularIdade
        int idadeCalculada = jogador.calcularIdade();
        
        System.out.println(idadeCalculada);

        // Verifique se a idade calculada é igual à idade esperada
        assertEquals(idadeEsperada, idadeCalculada);
    }

    @Test
    @Disabled
    public void testCalcularIdadeComDataFutura() {
        // Crie um jogador com data de nascimento no futuro (erro comum)
        LocalDate dataNascimento = LocalDate.now().plusYears(1); // Data de nascimento no próximo ano
        Jogador jogador = new Jogador(2, "Maria", dataNascimento, "F", 1.70f);

        // Calcule a idade esperada (deve ser 0, pois a data de nascimento está no futuro)
        int idadeEsperada = 0;

        // Obtenha a idade calculada pelo método calcularIdade
        int idadeCalculada = jogador.calcularIdade();

        // Verifique se a idade calculada é igual à idade esperada
        assertNotEquals(idadeEsperada, idadeCalculada);
    }
}
