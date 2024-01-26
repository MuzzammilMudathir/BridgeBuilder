package BridgeBuilderAdv;

import java.util.Arrays;


/**
The GameBoard class represents the game board for the Bridge Builder game.
This class is designed to handle the game board's state, token placement, and win/tie checks.
Our approach towards designing the code involved creating a 2D array to represent the board,
where each element represents a cell on the board. We implemented methods to place tokens,
check if a position is empty, and display the board.
Whuke developing the code, one challenge we faced was validating the position inputs to prevent out-of-bounds errors.
We handled this by checking if the row and column values are within the valid range.
To test the solution, we conducted comprehensive unit tests to cover different scenarios. We tested token placement,
empty position checks, win conditions, tie conditions, and board display functionality.
Overall, the GameBoard class provides the necessary functionality to manage the game board
and perform essential operations for the Bridge Builder game.
*/


/**
 * Represents the game board where the game will be played.
 */
public class GameBoard {
    private char[][] board;
    private int size;

    /**
     * Constructs a game board of the specified size.
     *
     * @param size the size of the game board
     */
    public GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    /**
     * Places the specified token at the given row and column on the game board.
     *
     * @param row   the row index
     * @param col   the column index
     * @param token the token to place on the game board
     */
    public void placeToken(int row, int col, char token) {
        board[row][col] = token;
    }

    /**
     * Checks whether the specified position on the board is empty.
     *
     * @param row the row index
     * @param col the column index
     * @return {@code true} if the position is empty, {@code false} otherwise
     */
    public boolean isPositionEmpty(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false; // Invalid position, considered not empty
        }
        return board[row][col] == '.';
    }

    /**
     * Returns the size of the game board.
     *
     * @return the size of the game board
     */
    public int getSize() {
        return size;
    }

    /**
     * Displays the game board on the console, including row and column numbers.
     */
    public void displayBoard() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks whether the player has won the game in any direction (left-to-right, bottom-to-top, or diagonally).
     * Returns 1 for left-to-right win, 2 for bottom-to-top win, 3 for diagonal win, and 0 for no win.
     *
     * @param player the player to check for win
     * @return the win direction code (1 for left-to-right, 2 for bottom-to-top, 3 for diagonal, 0 for no win)
     */
    public int checkForWinDirection(Player player) {
        char token = player.getToken();

        // Check left-to-right win
        for (int row = 0; row < size; row++) {
            boolean win = true;
            for (int col = 0; col < size; col++) {
                if (board[row][col] != token) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return 1; // Left-to-right win
            }
        }

        // Check bottom-to-top win
        for (int col = 0; col < size; col++) {
            boolean win = true;
            for (int row = 0; row < size; row++) {
                if (board[row][col] != token) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return 2; // Bottom-to-top win
            }
        }

        // Check diagonal win (top-left to bottom-right)
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != token) {
                win = false;
                break;
            }
        }
        if (win) {
            return 3; // Diagonal win
        }

        return 0; // No win
    }

    /**
     * Checks whether the game is a tie (i.e., the board is full).
     *
     * @return {@code true} if the game is a tie, {@code false} otherwise
     */
    public boolean checkForTie() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '.') {
                    return false; // Board is not full, game is not a tie
                }
            }
        }
        return true; // Board is full, game is a tie
    }
}

