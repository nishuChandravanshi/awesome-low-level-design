import coffeevendingmachine.CoffeeVendingMachine;
import coffeevendingmachine.Latte;
import coffeevendingmachine.inventory.Ingredient;
import coffeevendingmachine.inventory.Item;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CoffeeVendingMachine coffeeVendingMachine = CoffeeVendingMachine.getVendingMachine();

        List<Ingredient> ingredientList = getIngredients();
        coffeeVendingMachine.addIngredients(ingredientList);


        coffeeVendingMachine.selectCoffee(new Latte());
        coffeeVendingMachine.makePayment(60);

    }

    private static List<Ingredient> getIngredients() {

        return Arrays.asList(new Ingredient(Item.SUGAR, 5.0),
                new Ingredient(Item.COFFEE_POWDER, 5.0)
                , new Ingredient(Item.WATER, 5.0),
                new Ingredient(Item.MILK, 5.0));
    }
}