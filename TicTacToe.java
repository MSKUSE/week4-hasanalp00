
public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
        boolean gameEnded = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        int[][] moves = {
            {0, 0}, {1, 1}, {0, 1}, {1, 2}, {0, 2}
        };

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];

            if (isValid(row, col) && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard(board);

                if (checkboard(board, row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        if (!gameEnded) {
            System.out.println("It's a tie!");
        }
    }

    public static boolean checkboard(char[][] board, int row, int col) {
        char currentPlayer = board[row][col];

        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true;
        }

        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            return true;
        }

        if (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}
