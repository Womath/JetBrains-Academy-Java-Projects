package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        CoffeeMachineClass coffeeMachine = new CoffeeMachineClass();

        while (!coffeeMachine.exit) {
            coffeeMachine.action();
        }

        /*System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");*/
        /*int moneyInMachine = 550;
        int waterInMachine = 400;
        int milkInMachine = 540;
        int coffeeInMachine = 120;
        int cupsInMachine = 9;



        boolean exit = false;

        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String action = scanner.nextLine();


            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                    int coffeeToBuy;
                    if (scanner.hasNextInt()) {
                        coffeeToBuy = scanner.nextInt();
                    } else {
                        break;
                    }

                    boolean canMake = checkIfCanMake(coffeeToBuy, waterInMachine, milkInMachine, coffeeInMachine, cupsInMachine);

                    if (canMake) {
                        waterInMachine -= useWater(coffeeToBuy);
                        milkInMachine -= useMilk(coffeeToBuy);
                        coffeeInMachine -= useCoffee(coffeeToBuy);
                        cupsInMachine--;
                        moneyInMachine += payedForCoffee(coffeeToBuy);
                        break;
                    } else {
                        break;
                    }

                case "fill":
                    waterInMachine += fillWater();
                    milkInMachine += fillMilk();
                    coffeeInMachine += fillCoffee();
                    cupsInMachine += fillCups();
                    break;

                case "take":
                    System.out.println("I gave you $" + moneyInMachine);
                    moneyInMachine = 0;
                    break;

                case "remaining":
                    inventoryStatus(waterInMachine, milkInMachine, coffeeInMachine, cupsInMachine, moneyInMachine);
                    break;

                case "exit":
                    exit = true;
                    break;
            }
        }*/



        /*System.out.println("Write how many ml of water the coffee machine has:");
        waterInMachine = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkInMachine = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeInMachine = scanner.nextInt();*/

        /*System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();
        int waterPerServe = 200;
        int milkPerServe = 50;
        int coffeeBeansPerServe = 15;

        int waterCanMake = waterInMachine/waterPerServe;
        int milkCanMake = milkInMachine/milkPerServe;
        int coffeeCanMake = coffeeInMachine/coffeeBeansPerServe;

        int cupsCanMake;
        if (waterCanMake <= milkCanMake && waterCanMake <= coffeeCanMake) {
            cupsCanMake = waterCanMake;
        } else if (milkCanMake <= waterCanMake && milkCanMake < coffeeCanMake) {
            cupsCanMake = milkCanMake;
        } else {
            cupsCanMake = coffeeCanMake;
        }

        if (cupsCanMake == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsCanMake < cupsOfCoffee) {
            System.out.printf("No, I can make only %d cup(s) of coffee", cupsCanMake);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", cupsCanMake-cupsOfCoffee);
        }*/

        //System.out.printf("For %d cups of coffee you will need:", cupsOfCoffee);
        //System.out.printf("%n%d ml of water %n%d ml of milk %n%d g of coffee beans", waterPerServe*cupsOfCoffee, milkPerServe*cupsOfCoffee, coffeeBeansPerServe*cupsOfCoffee);
    }


   /* public static int fillWater () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        return scanner.nextInt();
    }

    public static int fillMilk () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of milk you want to add:");
        return scanner.nextInt();
    }

    public static int fillCoffee () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many grams of coffee beans you want to add:");
        return scanner.nextInt();
    }

    public static int fillCups () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many disposable cups of coffee you want to add");
        return scanner.nextInt();
    }

    public static int useWater (int coffeeType) {
        int usedWater = 0;
        switch (coffeeType) {
            case 1:
                usedWater = 250;
                break;
            case 2:
                usedWater = 350;
                break;
            case 3:
                usedWater = 200;
                break;
        }
        return usedWater;
    }

    public static int useMilk (int coffeeType) {
        int usedMilk = 0;
        switch (coffeeType) {
            case 1:
                break;
            case 2:
                usedMilk = 75;
                break;
            case 3:
                usedMilk = 100;
                break;
        }
        return usedMilk;
    }

    public static int useCoffee (int coffeeType) {
        int usedCoffee = 0;
        switch (coffeeType) {
            case 1:
                usedCoffee = 16;
                break;
            case 2:
                usedCoffee = 20;
                break;
            case 3:
                usedCoffee = 12;
                break;
        }
        return usedCoffee;
    }

    public static int payedForCoffee (int coffeeType) {
        int payedFor = 0;
        switch (coffeeType) {
            case 1:
                payedFor = 4;
                break;
            case 2:
                payedFor = 7;
                break;
            case 3:
                payedFor = 6;
                break;
        }
        return payedFor;
    }

    public static void inventoryStatus (int water, int milk, int coffee, int cups, int money){
        System.out.printf("The coffee machine has:%n%d ml of water%n%d ml of milk%n%d g of coffee beans%n%d disposable cups%n$%d of money%n",
                water, milk, coffee, cups, money);
    }

    public static boolean checkIfCanMake (int coffeeType, int water, int milk, int coffee, int cups) {
        boolean canMake = false;
        switch (coffeeType) {
            case 1:
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

            case 2:
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

            case 3:
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

    public String input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }*/

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


