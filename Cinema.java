package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();
        int purchasedTickets = 0;
        int maxSeats = rows * seatsPerRow;

        int income = 0;
        int totalIncome = 0;

        if(rows * seatsPerRow > 60) {
            totalIncome = rows / 2 * seatsPerRow * 10 + (rows - rows / 2) * seatsPerRow * 8;
        } else {
            totalIncome = rows * seatsPerRow * 10;
        }
        boolean exit = false;

        char seats[][] = new char[seatsPerRow][rows];

        for(int i = 0; i < seatsPerRow; i++) {
            for(int j = 0; j < rows; j++) {
                seats[i][j] = 'S';
            }
        }

        while(!exit) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println("Cinema:");
                    System.out.print(" ");
                    for(int i = 0; i < seatsPerRow; i++) {
                        System.out.print(" " + (i + 1));
                    }
                    System.out.println();

                    for(int i = 0; i < rows; i++) {
                        System.out.print((i+1));
                        for(int j = 0; j < seatsPerRow; j++) {
                            System.out.print(" " + seats[j][i]);
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    boolean inputIsCorrect = false;
                    while(!inputIsCorrect){
                        System.out.println("Enter a row number:");
                        int orderRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int orderSeat = scanner.nextInt();

                        if(orderRow > rows || orderSeat > seatsPerRow) {
                            System.out.println("Wrong input!");
                        } else if(seats[orderSeat-1][orderRow-1] == 'B') {
                            System.out.println("That ticket has already been purchased!");
                        } else {
                            inputIsCorrect = true;
                            seats[orderSeat-1][orderRow-1] = 'B';
                            int ticketPrice = 10;

                            if(rows * seatsPerRow > 60) {
                                if (orderRow > rows / 2) {
                                    ticketPrice = 8;
                                }
                            }
                            System.out.println("Ticket price: $" + ticketPrice);
                            purchasedTickets++;
                            income += ticketPrice;
                        }
                    }
                    break;
                case 3:
                    float bookedPercentage = (float)purchasedTickets / (float)maxSeats * 100;
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    System.out.printf("Percentage: %.2f", bookedPercentage);
                    System.out.println("%");
                    System.out.println("Current income: $" + income);
                    System.out.println("Total income: $" + totalIncome);
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }



        /*if(rows * seatsPerRow > 60) {
            totalIncome = rows / 2 * seatsPerRow * 10 + (rows - rows / 2) * seatsPerRow * 8;
        } else {
            totalIncome = rows * seatsPerRow * 10;
        }
        System.out.println("Total income:");
        System.out.println("$" + income);*/
    }

}