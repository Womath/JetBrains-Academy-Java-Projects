package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String enterCells = scanner.nextLine();

        char[][] cells = new char[3][3];
        int counter = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                cells[i][j] = 95;
                counter++;
            }
        }


        int chOne;
        int chTwo;
        String ch;


            //System.out.println("Enter cells: " + enterCells);
            System.out.println("---------");
            System.out.println("| " + cells[0][0] + " " + cells[0][1] + " " + cells[0][2] + " |");
            System.out.println("| " + cells[1][0] + " " + cells[1][1] + " " + cells[1][2] + " |");
            System.out.println("| " + cells[2][0] + " " + cells[2][1] + " " + cells[2][2] + " |");
            System.out.println("---------");
        int countX = 0;
        int countO = 0;
        int countSpace = 9;
        boolean isOWin = false;
        boolean isXWin = false;

    while (!isOWin && !isXWin) {


        boolean inputIsCorrect = false;

        while (!inputIsCorrect) {
            if (scanner.hasNextInt()) {
                chOne = scanner.nextInt();
                chTwo = scanner.nextInt();
                ch = chOne + " " + chTwo;
                System.out.println("Enter the coordinates: " + ch);
                if ((chOne > 0 && chOne < 4) && (chTwo > 0 && chTwo < 4)) {
                    if (cells[chOne - 1][chTwo - 1] == 88 || cells[chOne - 1][chTwo - 1] == 79) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        inputIsCorrect = true;
                        if (countX < countO || countX == countO) {
                            cells[chOne - 1][chTwo - 1] = 'X';
                            countX++;
                            countSpace--;
                        } else {
                            cells[chOne - 1][chTwo - 1] = 'O';
                            countO++;
                            countSpace--;
                        }
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                ch = scanner.nextLine();
                System.out.println("Enter the coordinates: " + ch);
                System.out.println("You should enter numbers!");
            }
        }


        //System.out.println("Enter cells: " + enterCells);
        System.out.println("---------");
        System.out.println("| " + cells[0][0] + " " + cells[0][1] + " " + cells[0][2] + " |");
        System.out.println("| " + cells[1][0] + " " + cells[1][1] + " " + cells[1][2] + " |");
        System.out.println("| " + cells[2][0] + " " + cells[2][1] + " " + cells[2][2] + " |");
        System.out.println("---------");






        /*int countX = 0;
        int countO = 0;
        int countSpace = 9;
        for (int i = 0; i < 9; i++){
            if (enterCells.charAt(i) == 'X'){
                countX++;
            }else if (enterCells.charAt(i) == 'O'){
                countO++;
            }else if (enterCells.charAt(i) == '_'){
                countSpace++;
            }
        }*/


        int checkRow;
        for (int i = 0; i < 3; i++) {
            checkRow = 0;
            for (int j = 0; j < 3; j++) {
                checkRow += cells[i][j];
                if (checkRow == 264) {
                    isXWin = true;
                    break;
                } else if (checkRow == 237) {
                    isOWin = true;
                    break;
                }
            }

        }


        int checkCollumn;
        if (!isOWin && !isXWin) {
            for (int i = 0; i < 3; i++) {
                checkCollumn = 0;
                for (int j = 0; j < 3; j++) {
                    checkCollumn += cells[j][i];
                    if (checkCollumn == 264) {
                        isXWin = true;
                        break;
                    } else if (checkCollumn == 237) {
                        isOWin = true;
                        break;
                    }
                }

            }
        }


        int checkDiagonal = 0;
        if (!isOWin && !isXWin) {
            for (int i = 0; i < 3; i++) {
                checkDiagonal += cells[i][i];
                if (checkDiagonal == 264) {
                    isXWin = true;
                    break;
                } else if (checkDiagonal == 237) {
                    isOWin = true;
                    break;
                }
            }
        }


        int checkOtherDiagonal = 0;
        if (!isOWin && !isXWin) {
            for (int i = 0; i < 3; i++) {
                checkOtherDiagonal += cells[i][2 - i];
                if (checkOtherDiagonal == 264) {
                    isXWin = true;
                    break;
                } else if (checkOtherDiagonal == 237) {
                    isOWin = true;
                    break;
                }

            }
        }


        if (Math.abs(countX - countO) > 1 || ((isOWin) && (isXWin))) {
            System.out.println("Impossible");
            break;
        } else if ((!isOWin && !isXWin) && countSpace > 0) {
            System.out.print("");
        } else if ((!isOWin && !isXWin) && countSpace == 0) {
            System.out.println("Draw");
            break;
        } else if (isOWin) {
            System.out.println("O wins");
        } else if (isXWin) {
            System.out.println("X wins");
        }


    }

    }




}
