package coffeevendingmachine;


public enum CoffeeType {
    CAPPUCCINO(60),
    LATTE(50),
    ESPRESSO(40);

    public final double price;

    CoffeeType(double price) {
        this.price = price;
    }

}
