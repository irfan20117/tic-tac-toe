import java.util.Scanner;

public class Main {
    static char[] board = new char[9];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter a slot number to place " + currentPlayer + " in:");
            Scanner scanner = new Scanner(System.in);
            int slot = scanner.nextInt() - 1;
            board[slot] = currentPlayer;

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(board[i]);
        }
        System.out.println();
    }

    static boolean checkWinner() {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}  // diagonals
        };

        for (int[] combination : winningCombinations) {
            if (board[combination[0]] == currentPlayer &&
                    board[combination[1]] == currentPlayer &&
                    board[combination[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    static boolean isBoardFull() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
}
