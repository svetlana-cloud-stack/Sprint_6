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
        Predator predator = mock(Predator.class);
        Alex alex = new Alex(predator);

        assertEquals(List.of("Marty", "Melman", "Gloria"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        Predator predator = mock(Predator.class);
        Alex alex = new Alex(predator);

        assertEquals("Central Park Zoo", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() throws Exception {
        Predator predator = mock(Predator.class);
        Alex alex = new Alex(predator);

        assertEquals(0, alex.getKittens());
    }

    @Test
    public void doesHaveManeReturnsTrue() throws Exception {
        Predator predator = mock(Predator.class);
        Alex alex = new Alex(predator);

        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Predator predator = mock(Predator.class);
        Alex alex = new Alex(predator);

        Mockito.when(predator.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                alex.getFood()
        );

        verify(predator).eatMeat();
    }
}
