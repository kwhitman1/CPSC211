import static org.junit.Assert.*;
import org.junit.Test;

public class MazeUnitTest {

    @Test
    public void testGetWidth() {
        // Set up
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        
        // Method execution
        int result = maze.getWidth();
        
        // Verification
        if (result != width) {
            fail("Incorrect Width");
        }
    }

    @Test
    public void testGetHeight() {
        // Set up
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        
        // Method execution
        int result = maze.getHeight();
        
        // Verification
        if (result != height) {
            fail("Incorrect Height");
        }
    }

    @Test
    public void testPath() {
        // Set up
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
                {'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
                
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;
        int endRow = 1;
        int endCol = 3;
        String expectedResult = "1,1-1,2-1,3";

        // Method execution
        String result = maze.solve(startRow, startCol, endRow, endCol);

        // Verification
        if (!expectedResult.equals(result)) {
            fail("Incorrect result");
        }
    }

    @Test
    public void testSolvePath2() {
        // Set up
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
        		{'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;
        int endRow = 3;
        int endCol = 3;

        // Method execution
        String result = maze.solve(startRow, startCol, endRow, endCol);

        // Verification
        if (result == null) {
            fail("No Path");
        }
    }

    @Test
    public void testImpossible() {
        // Set up
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
        		{'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;
        int endRow = 0;
        int endCol = 0;

        // Method execution
        String result = maze.solve(startRow, startCol, endRow, endCol);

        // Verification
        if (result != null) {
            fail("Got a path");
        }
    }

    @Test
    public void testReturnToStart() {
        // Set up
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
        		{'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;

        // Method execution
        String result = maze.solve(startRow, startCol, startRow, startCol);

        // Verification
        if (!result.equals("1,1")) {
            fail("Did not end up at 1,1");
        }
    }
}