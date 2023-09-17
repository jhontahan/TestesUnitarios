package br.com.trabalho.engSoft.maven.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CampeonatoTest {
	@Test
    public void testAdicionarTime() {
        // Crie um campeonato
        Campeonato campeonato = new Campeonato();

        // Crie um time
        Estadio estadio = new Estadio(1, "Estádio A", "Endereço A");
        Time time = new Time(1, "Time A", estadio);

        // Tente adicionar o time ao campeonato (deve ser bem-sucedido)
        campeonato.adicionarTime(time);

        // Verifique se o time foi adicionado com sucesso ao campeonato
        assertTrue(campeonato.getTimes().contains(time));
    }

    @Test
    public void testAdicionarTimeExistente() {
        // Crie um campeonato
        Campeonato campeonato = new Campeonato();

        // Crie um estádio
        Estadio estadio = new Estadio(1, "Estádio B", "Endereço B");

        // Crie dois times com o mesmo nome e estádio
        Time time1 = new Time(1, "Time B", estadio);

        // Adicione o primeiro time ao campeonato (deve ser bem-sucedido)
        campeonato.adicionarTime(time1);

        // Tente adicionar o segundo time com o mesmo nome e estádio (deve lançar uma exceção)
        assertThrows(IllegalArgumentException.class, () -> {
            campeonato.adicionarTime(time1);
        });

    }
}
