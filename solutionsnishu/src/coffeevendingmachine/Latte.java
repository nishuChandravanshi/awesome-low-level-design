package coffeevendingmachine;

import coffeevendingmachine.inventory.Ingredient;

import java.util.List;

public class Latte extends AbstractCoffee {

    public Latte() {
        this.type = CoffeeType.LATTE;
    }


    @Override
    public void prepareCoffee(List<Ingredient> ingredientList) {

    }
}
