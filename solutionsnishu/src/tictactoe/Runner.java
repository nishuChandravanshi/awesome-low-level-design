package tictactoe;

public class Runner {

    /*
        Game game = new Game();
        - Player1
        - Player2
        - status (active, inactive)
        - board
        - makeMove(i, j);
        - private isGameOver();
        - displayBoard();

        Player
        - id
        - name
        - symbol (x, o)
     */
    public static void main(String[] args) {
        Player player1 = new Player("nishu", 'x');
        Player player2 = new Player("rushi", 'o');
        Game game = new Game(player1, player2, player1);

        game.play();
    }
}

