package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AlexTest {

    @Test
    public void getFriendsRetrunsFriendsList() throws Exception {
        CatBehavior feline = mock(CatBehavior.class);
        Alex alex = new Alex(feline);

        assertEquals(List.of("Marty", "Melman", "Gloria"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        CatBehavior feline = mock(CatBehavior.class);
        Alex alex = new Alex(feline);

        assertEquals("Central Park Zoo", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() throws Exception {
        CatBehavior feline = mock(CatBehavior.class);
        Alex alex = new Alex(feline);

        assertEquals(0, alex.getKittens());
    }

    @Test
    public void doesHaveManeReturnsTrue() throws Exception {
        CatBehavior feline = mock(CatBehavior.class);
        Alex alex = new Alex(feline);

        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        CatBehavior feline = mock(CatBehavior.class);
        Alex alex = new Alex(feline);

        Mockito.when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        assertEquals(List.of("Животные", "Птицы", "Рыба"), alex.getFood());

        verify(feline).getFood("Хищник");
    }
}
