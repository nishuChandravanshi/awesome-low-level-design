package tictactoe;

import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public Game(Player player1, Player player2, Player currentPlayer) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
        this.board = new Board();
    }

    //todo discuss parallel thread access behaviour here
    public synchronized void play() {
        while (!board.isFull() && !board.hasWinner()) {
            int[] input = getInput(currentPlayer.getName() + " Enter comma separated input row column between 0-2");
            int row = input[0];
            int column = input[1];


            board.makeMove(row, column, currentPlayer.getSymbol());

            if (board.hasWinner()) {
                System.out.println("Game Over | Winner is " + currentPlayer.getName());
                return;
            }
            switchPlayer();
        }

        if (board.isFull()) {
            System.out.println("Game Over with a draw!!");
        }

    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private int[] getInput(String message) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(message);

            if (scanner.hasNext()) {
                String input = scanner.nextLine();
                System.out.println("Input " + input);
                String[] rowColStr = input.split(" ");

                int[] rcInt = new int[]{Integer.parseInt(rowColStr[0]), Integer.parseInt(rowColStr[1])};

                if (rcInt[0] < 0 || rcInt[0] > 2 || rcInt[1] < 0 || rcInt[1] > 2) {
                    System.out.println("Invalid input please enter between 0-2");
                } else {
                    return rcInt;
                }

            } else {
                scanner.next();
            }
        }
    }
}
