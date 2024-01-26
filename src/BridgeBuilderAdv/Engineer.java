package BridgeBuilderAdv;

import java.util.Random;

/**
 * Represents an Engineer player in the game.
 */
public class Engineer {
    private char token;
    private boolean hardMode;

    /**
     * Constructs an Engineer player with the specified difficulty mode.
     *
     * @param hardMode {@code true} for hard mode, {@code false} for easy mode
     */
    public Engineer(boolean hardMode) {
        this.token = '0';
        this.hardMode = hardMode;
    }

    /**
     * Makes a move for the Engineer player on the specified game board.
     *
     * @param board           the game board
     * @param playerLastRow   the row index of the player's last move
     * @param playerLastCol   the column index of the player's last move
     */
    public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
        if (hardMode) {
            int row = playerLastRow;
            int col = playerLastCol + 1;

            while (row < board.getSize() && !board.isPositionEmpty(row, col)) {
                col++;
                if (col >= board.getSize()) {
                    col = 0;
                    row++;
                }
            }

            if (row < board.getSize()) {
                board.placeToken(row, col, token);
            }
        } else {
            Random random = new Random();
            int row, col;

            do {
                row = random.nextInt(board.getSize());
                col = random.nextInt(board.getSize());
            } while (!board.isPositionEmpty(row, col));

            board.placeToken(row, col, token);
        }
    }
}
