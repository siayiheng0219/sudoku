import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuValidatorTest {
    @Test
    void testRowViolation() {
        int[][] grid = new int[9][9];
        grid[0][0] = 5;
        grid[0][1] = 5;
        String result = SudokuValidator.validate(grid);
        assertTrue(result.contains("Row A"));
    }

    @Test
    void testValidBoard() {
        int[][] grid = new int[9][9];
        grid[0][0] = 1;
        grid[1][1] = 2;
        String result = SudokuValidator.validate(grid);
        assertEquals("No rule violations detected.", result);
    }
}
