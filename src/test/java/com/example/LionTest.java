package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {
    @Test
    public void getKittensReturnsOne() throws Exception {
        Predator predator = Mockito.mock(Predator.class);

        Lion lion = new Lion("Самец", predator);

        assertEquals(1, lion.getKittens());

    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Predator predator = Mockito.mock(Predator.class);

        Mockito.when(predator.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predator);

        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                lion.getFood()
        );

        Mockito.verify(predator).eatMeat();
    }

    @Test
    public void wrongSexThrowsException() {
        Predator predator = Mockito.mock(Predator.class);

        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", predator)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }
}
