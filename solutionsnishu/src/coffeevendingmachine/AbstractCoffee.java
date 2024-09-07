package coffeevendingmachine;

import coffeevendingmachine.inventory.Ingredient;

import java.util.List;
import java.util.Objects;

public abstract class AbstractCoffee {
    CoffeeType type;

    public abstract void prepareCoffee(List<Ingredient> ingredientList);

    @Override
    public  boolean equals(Object obj) {
        AbstractCoffee that = (AbstractCoffee) obj;
        return  this.type.equals(that.type);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }
}
