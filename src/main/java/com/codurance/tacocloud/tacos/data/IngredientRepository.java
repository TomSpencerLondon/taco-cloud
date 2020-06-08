package com.codurance.tacocloud.tacos.data;

import com.codurance.tacocloud.tacos.Ingredient;

public interface IngredientRepository {
  Iterable<Ingredient> findAll();

  Ingredient findOne(String id);

  Ingredient save(Ingredient ingredient);
}
