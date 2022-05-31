package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        CoffeeMachineClass coffeeMachine = new CoffeeMachineClass();

        while (!coffeeMachine.exit) {
            coffeeMachine.action();
        }
    }
}

class CoffeeMachineClass {

    int moneyInMachine = 550;
    int waterInMachine = 400;
    int milkInMachine = 540;
    int coffeeInMachine = 120;
    int cupsInMachine = 9;
    boolean exit = false;

    enum Action {
        BUY, FILL, TAKE, REMAINING, EXIT
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String coffeeToBuy = input();
        boolean canMake = checkIfCanMake(coffeeToBuy, this.waterInMachine, this.milkInMachine, this.coffeeInMachine, this.cupsInMachine);
        if (canMake) {
            switch(coffeeToBuy) {
                case "1":
                    espresso();
                    break;
                case "2":
                    latte();
                    break;
                case "3":
                    cappuccino();
                    break;
                default:
                    break;
            }
        }

    }

    public void espresso() {
        this.waterInMachine -= 250;
        this.coffeeInMachine -= 16;
        this.cupsInMachine -= 1;
        this.moneyInMachine += 4;
    }

    public void latte() {
        this.waterInMachine -= 350;
        this.milkInMachine -= 75;
        this.coffeeInMachine -= 20;
        this.cupsInMachine -= 1;
        this.moneyInMachine += 7;
    }

    public void cappuccino() {
        this.waterInMachine -= 200;
        this.milkInMachine -= 100;
        this.coffeeInMachine -= 12;
        this.cupsInMachine -= 1;
        this.moneyInMachine += 6;
    }

    public boolean checkIfCanMake (String coffeeType, int water, int milk, int coffee, int cups) {
        boolean canMake = false;
        switch (coffeeType) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 0 ) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffee < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    canMake = true;
                }
                break;

            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75 ) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffee < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    canMake = true;
                }
                break;

            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100 ) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffee < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    canMake = true;
                }
                break;
        }
        return canMake;
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        this.waterInMachine += Integer.parseInt(input());
        System.out.println("Write how many ml of milk you want to add:");
        this.milkInMachine += Integer.parseInt(input());
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeInMachine += Integer.parseInt(input());
        System.out.println("Write how many disposable cups of coffee you want to add");
        this.cupsInMachine += Integer.parseInt(input());
    }

    public void take() {
        System.out.println("I gave you $" + this.moneyInMachine);
        this.moneyInMachine = 0;
    }

    public void remaining() {
        System.out.printf("The coffee machine has:%n%d ml of water%n%d ml of milk%n%d g of coffee beans%n%d disposable cups%n$%d of money%n",
                this.waterInMachine, this.milkInMachine, this.coffeeInMachine, this.cupsInMachine, this.moneyInMachine);
    }

    public void exit() {
        this.exit = true;
    }

    public void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit)");
        switch(input()) {
            case "buy":
                buy();
                break;

            case "fill":
                fill();
                break;

            case "take":
                take();
                break;

            case "remaining":
                remaining();
                break;

            case "exit":
                exit();
                break;
        }
    }
}


