package BridgeBuilderAdv;

/**
 * Represents a player in the game.
 */
public class Player {
    private char token;
    private int score;

    /**
     * Constructs a player with the default token and score.
     */
    public Player() {
        this.token = '+';
        this.score = 0;
    }

    /**
     * Makes a move for the player on the specified game board.
     *
     * @param board the game board
     * @param row   the row index of the desired move
     * @param col   the column index of the desired move
     */
    public void makeMove(GameBoard board, int row, int col) {
        if (board.isPositionEmpty(row, col)) {
            board.placeToken(row, col, token);
        } else {
            System.out.println("Invalid move. The position is already occupied.");
        }
    }

    /**
     * Returns the token assigned to the player.
     *
     * @return the player's token
     */
    public char getToken() {
        return token;
    }

    /**
     * Returns the player's current score.
     *
     * @return the player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds the specified increment to the player's score.
     *
     * @param increment the score increment
     */
    public void addScore(int increment) {
        score += increment;
    }
}
