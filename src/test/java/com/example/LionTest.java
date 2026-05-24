package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {
    @Test
    public void getKittensReturnsOne() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Mockito.when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", feline);

        assertEquals(1, lion.getKittens());

        Mockito.verify(feline).getKittens();

    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Mockito.when(feline.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", feline);

        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                lion.getFood()
        );

        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void wrongSexThrowsException() {
        Feline feline = Mockito.mock(Feline.class);

        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", feline)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }
}
