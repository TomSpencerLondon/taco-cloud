package com.codurance.tacocloud.tacos.data;

import com.codurance.tacocloud.tacos.Taco;

public interface TacoRepository {
  Taco save(Taco design);
}
