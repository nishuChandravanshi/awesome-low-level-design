package coffeevendingmachine;

import coffeevendingmachine.inventory.Ingredient;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CoffeeVendingMachine {

    private static CoffeeVendingMachine vendingMachineInstance;
    private Set<AbstractCoffee> availableCoffees = new HashSet<>();   //todo disc availableCoffee handling wrt to ingredient or how should this be intialized?
    private AbstractCoffee selectedCoffee;      //todo remove selectedCoffee after its dispensed. handle concurrency
    private List<Ingredient> ingredients;   //handle concurrent, update ingredients after every use.

    private MachineStatus status;

    public static synchronized CoffeeVendingMachine getVendingMachine() {
        if (vendingMachineInstance == null) {
            vendingMachineInstance = new CoffeeVendingMachine();
        }

        return vendingMachineInstance;
    }

    private CoffeeVendingMachine() {

    }


    public void addIngredients(List<Ingredient> ingredients) {
        if (this.ingredients == null || this.ingredients.isEmpty()) {
            this.ingredients = new ArrayList<>();
            this.ingredients.addAll(ingredients);
            updateAvailableCoffee();
            return;
        }
        for (Ingredient ingredient : ingredients) {
            this.ingredients.forEach(availableIng -> {
                if (availableIng.getItem() == ingredient.getItem()) {
                    availableIng.setQuantity(availableIng.getQuantity() + ingredient.getQuantity());
                } else {
                    this.ingredients.add(ingredient);
                }
            });
        }
        updateAvailableCoffee();

    }

    private void updateAvailableCoffee() {
        //if ingredients contains sufficient quantity add corresponding available coffees.. | todo
        availableCoffees.add(new Latte());
    }

    public void displayMenu() {
        if (availableCoffees != null && !availableCoffees.isEmpty()) {
            System.out.println(availableCoffees);
        } else {
            System.out.println("Coffee not available at the moment!");
        }
    }

    public void selectCoffee(AbstractCoffee coffee) {
        if (availableCoffees.contains(coffee)) {
            System.out.println("Selecting from available coffees " + availableCoffees);
            this.selectedCoffee = coffee;
        } else {
            System.out.println("Selected coffee not available! ");
        }
    }


//    public void addCoffee(AbstractCoffee coffee) {
//        availableCoffees.add(coffee);
//    }


    public double makePayment(double paidAmount) {
        if (selectedCoffee == null) {
            throw new RuntimeException("Please select coffee first from menu before making payment");

        }
        if (paidAmount >= selectedCoffee.type.price) {
            System.out.println("Payment done.. ");
            double toReturn = paidAmount - selectedCoffee.type.price;

            selectedCoffee.prepareCoffee(ingredients);  //todo check if this can be separated from makePayment
            dispense();

            return toReturn;
        } else {
            throw new RuntimeException("Paid amount is not sufficient.. Price for selected coffee is " + selectedCoffee.type.price);
        }
    }

    public void dispense() {
        System.out.println("Dispense " + selectedCoffee);
    }


}
