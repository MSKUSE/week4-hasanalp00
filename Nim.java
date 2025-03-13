public class Nim {

    public static void main(String[] args) {
        int[] piles = {3, 5, 7};
        int currentPlayer = 1;
        int[][] moves = {
            {0, 2}, {1, 3}, {2, 1}, {0, 1}, {1, 2}, {2, 1}
        };

        for (int[] move : moves) {
            int pile = move[0];
            int stones = move[1];

            if (isGameOver(piles)) {
                break;
            }

            printPiles(piles);

            if (isValidMove(piles, pile, stones)) {
                piles[pile] -= stones;
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        System.out.println("Player " + currentPlayer + " wins!");
    }

    public static void printPiles(int[] piles) {
        for (int i = 0; i < piles.length; i++) {
            System.out.print("Pile " + i + ": ");
            for (int j = 0; j < piles[i]; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static boolean isGameOver(int[] piles) {
        for (int pile : piles) {
            if (pile > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidMove(int[] piles, int pile, int stones) {
        return pile >= 0 && pile < piles.length && stones > 0 && stones <= piles[pile];
    }
}