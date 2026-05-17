package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        CatBehavior feline = Mockito.mock(CatBehavior.class);

        Lion lion = new Lion(sex, feline);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void getKittensReturnsFelineKittens() throws Exception {
        CatBehavior feline = Mockito.mock(CatBehavior.class);

        Mockito.when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion(sex, feline);

        assertEquals(1, lion.getKittens());

        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        CatBehavior feline = Mockito.mock(CatBehavior.class);

        Mockito.when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(sex, feline);

        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                lion.getFood()
        );

        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void wrongSexThrowsException() {
        CatBehavior feline = Mockito.mock(CatBehavior.class);

        assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
    }
}
