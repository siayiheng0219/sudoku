public class SudokuValidator {
    public static String validate(int[][] grid) {
        // Check rows
        for (int r = 0; r < 9; r++) {
            boolean[] seen = new boolean[10];
            for (int c = 0; c < 9; c++) {
                int val = grid[r][c];
                if (val != 0) {
                    if (seen[val]) return "Number " + val + " already exists in Row " + (char)('A'+r) + ".";
                    seen[val] = true;
                }
            }
        }
        // Check columns
        for (int c = 0; c < 9; c++) {
            boolean[] seen = new boolean[10];
            for (int r = 0; r < 9; r++) {
                int val = grid[r][c];
                if (val != 0) {
                    if (seen[val]) return "Number " + val + " already exists in Column " + (c+1) + ".";
                    seen[val] = true;
                }
            }
        }
        // Check subgrids
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] seen = new boolean[10];
                for (int r = boxRow*3; r < boxRow*3+3; r++) {
                    for (int c = boxCol*3; c < boxCol*3+3; c++) {
                        int val = grid[r][c];
                        if (val != 0) {
                            if (seen[val]) return "Number " + val + " already exists in the same 3×3 subgrid.";
                            seen[val] = true;
                        }
                    }
                }
            }
        }
        return "No rule violations detected.";
    }
}
