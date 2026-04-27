public class SudokuBoard {
    private final int[][] grid;
    private final boolean[][] fixed;
    private final int[][] solution;

    public SudokuBoard(int[][] puzzle, int[][] solution) {
        this.grid = puzzle;
        this.solution = solution;
        this.fixed = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                fixed[r][c] = puzzle[r][c] != 0;
            }
        }
    }

    public boolean placeNumber(int row, int col, int num) {
        if (fixed[row][col]) return false;
        if (num < 1 || num > 9) return false;
        grid[row][col] = num;
        return true;
    }

    public boolean clearCell(int row, int col) {
        if (fixed[row][col]) return false;
        grid[row][col] = 0;
        return true;
    }

    public boolean isComplete() {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (grid[r][c] == 0 || grid[r][c] != solution[r][c])
                    return false;
        return true;
    }

    public void printBoard() {
        System.out.println("    1 2 3 4 5 6 7 8 9");
        for (int r = 0; r < 9; r++) {
            char rowLabel = (char) ('A' + r);
            System.out.print("  " + rowLabel + " ");
            for (int c = 0; c < 9; c++) {
                System.out.print(grid[r][c] == 0 ? "_ " : grid[r][c] + " ");
            }
            System.out.println();
        }
    }

    public String getHint() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (grid[r][c] == 0) {
                    return "Hint: Cell " + (char)('A'+r) + (c+1) + " = " + solution[r][c];
                }
            }
        }
        return "No hints available.";
    }
}
