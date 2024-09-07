package tictactoe;

public class Board {
    private char[][] grid;
    private int moveCount = 0;
    private static final char EMPTY = '#';

    public Board() {
        initializeGrid();
    }

    private void initializeGrid() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }

    //either we can throw exception or can ask the user to make a valid move again.
    //this can be handled in game class play method itself, if makeMove throws error, then handle it accordingly to get new Input or terminate as per requirement.
    public synchronized void makeMove(int i, int j, char symbol) {
        if (this.isFull() || this.hasWinner()) {
            System.out.println("Cannot make new move as game is ended!");
            throw new RuntimeException("Game Over");

        }
        if (i > 2 || j > 2 || i < 0 || j < 0) {
            System.out.println("Make a valid move in range 0-2");
            throw new RuntimeException("Make a valid move in range 0-2");
        }

        if (grid[i][j] != '#') {
            System.out.println("Selected move is not available");
            throw new RuntimeException("Selected move is not available, pls make other move");
        }

        grid[i][j] = symbol;
        moveCount++;
    }

    public boolean isFull() {
        return moveCount == 9;
    }

    /*
        0 1 2
    0
    1
    2
     */
    public boolean hasWinner() {
        //rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != EMPTY && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                return true;
            }
        }

        //columns
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] != EMPTY && grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i]) {
                return true;
            }
        }

        //left diagonal
        if (grid[0][0] != EMPTY && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            return true;
        }

        //right diagonal
        if (grid[0][2] != EMPTY && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
            return true;
        }

        return false;

    }


}
