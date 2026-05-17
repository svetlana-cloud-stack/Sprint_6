package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsCorrectList() throws Exception {

        Feline feline = new Feline();

        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                feline.eatMeat()
        );
    }

    @Test
    public void getFamilyReturnsCorrectFamily() {

        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParameter() {

        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParameter() {

        Feline feline = new Feline();

        assertEquals(5, feline.getKittens(5));
    }
}
