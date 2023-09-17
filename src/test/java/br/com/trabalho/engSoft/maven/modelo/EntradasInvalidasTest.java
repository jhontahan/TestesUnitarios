package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EntradasInvalidasTest {
	@Test
    public void testDataNascimentoFutura() {
        // Tentar criar um jogador com data de nascimento no futuro deve lançar uma exceção
        LocalDate dataNascimento = LocalDate.now().plusYears(1); // Data de nascimento no próximo ano
        assertThrows(IllegalArgumentException.class, () -> {
        	new Jogador(1, "João", dataNascimento, "M", 1.75f);
        });
    }

    @Test
    public void testAlturaNegativa() {
        // Tentar criar um jogador com altura negativa deve lançar uma exceção
        assertThrows(IllegalArgumentException.class, () -> {
        	new Jogador(1, "João", LocalDate.of(1990, 1, 1), "M", -1.75f);
        });
    }
}
