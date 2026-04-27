import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuGenerator generator = new SudokuGenerator();
        int[][] puzzle = generator.generatePuzzle();
        int[][] solution = generator.getSolution();
        SudokuBoard board = new SudokuBoard(puzzle, solution);

        System.out.println("Welcome to Sudoku!\n");
        System.out.println("Here is your puzzle:");
        board.printBoard();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter command (e.g., A3 4, C5 clear, hint, check, quit):");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) break;
            if (input.equalsIgnoreCase("hint")) {
                System.out.println(board.getHint());
            } else if (input.equalsIgnoreCase("check")) {
                System.out.println(SudokuValidator.validate(board.getGrid()));
            } else {
                try {
                    char rowChar = input.charAt(0);
                    int row = rowChar - 'A';
                    int col = Character.getNumericValue(input.charAt(1)) - 1;
                    if (input.toLowerCase().contains("clear")) {
                        if (!board.clearCell(row, col)) System.out.println("Invalid move. Cell is pre-filled.");
                        else System.out.println("Cell cleared.");
                    } else {
                        int num = Character.getNumericValue(input.charAt(3));
                        if (!board.placeNumber(row, col, num)) System.out.println("Invalid move.");
                        else System.out.println("Move accepted.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid command format.");
                }
            }
            board.printBoard();
            if (board.isComplete()) {
                System.out.println("You have successfully completed the Sudoku puzzle!");
                break;
            }
        }
        sc.close();
    }
}
