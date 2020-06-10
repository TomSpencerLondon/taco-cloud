package com.codurance.tacocloud.tacos;

import com.codurance.tacocloud.tacos.Ingredient.Type;
import com.codurance.tacocloud.tacos.data.IngredientRepository;
import com.codurance.tacocloud.tacos.data.TacoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

  private final IngredientRepository ingredientRepo;
  private TacoRepository designRepo;

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
    this.ingredientRepo = ingredientRepo;
    this.designRepo = designRepo;
  }

  @GetMapping
  public String showDesignForm(Model model) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepo.findAll().forEach(i -> ingredients.add(i));

    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
    }
    model.addAttribute("design", new Taco());

    return "design";
  }

  @PostMapping
  public String processDesign(Taco design){
    log.info("Processing design: " + design);
    return "redirect:/orders/current";
  }


  private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients
        .stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
  }
}
