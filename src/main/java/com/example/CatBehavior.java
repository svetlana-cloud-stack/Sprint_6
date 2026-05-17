package com.example;

import java.util.List;

public interface CatBehavior {
    int getKittens();
    List<String> getFood(String animalKind) throws Exception;
}
