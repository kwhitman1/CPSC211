import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTest {

    private Model model;

    @Test
    public void testBaseBoard() {
        
    	// Setup
    	model = new Model();
    	
        char expectedTopLeft = 'R';
        char expectedThirdRow = 'R';
        char expectedFourthRow = 'B';
        char expectedBottomRow = 'B';
        
        // Method Execution
        char actualTopLeft = model.peekTop(0, 0);
        char actualThirdRow = model.peekTop(2, 2);
        char actualFourthRow = model.peekTop(4, 0);
        char actualBottomRow = model.peekTop(6, 2);

        // Verification
        if (actualTopLeft != expectedTopLeft) {
            fail("Didn't get " + actualTopLeft);
        }
        if (actualThirdRow != expectedThirdRow) {
        	fail("Didn't get " + actualThirdRow);
        }
        if (actualFourthRow != expectedFourthRow) {
        	fail("Didn't get " + actualFourthRow);
        }
        if (actualBottomRow != expectedBottomRow) {
        	fail("Didn't get " + actualBottomRow);
        }
    }

    @Test
    public void testMovePieceValid() {
        
    	// Setup
    	model = new Model();
    	
        int startRow = 2, startCol = 0;
        int endRow = 3, endCol = 1;
        char expected = 'R';

        // Method Execution
        boolean moved = model.movePiece(startRow, startCol, endRow, endCol);
        char actual = model.peekTop(endRow, endCol);
        boolean isStartEmpty = model.peekTop(startRow, startCol) == null;

        // Verification
        if (!moved) {
            fail("Piece didn't move correctly.");
        }
        if (actual != expected) {
        	fail("Piece didn't move correctly.");
        }
        if (!isStartEmpty) {
        	fail("Piece didn't move correctly.");
        }
    }

    @Test
    public void testMovePieceInvalid() {
        
    	// Setup
    	model = new Model();
    	
        int startRow = 2, startCol = 0;
        int endRow = 7, endCol = 7;

        // Method Execution
        boolean moved = model.movePiece(startRow, startCol, endRow, endCol);
        char startPiece = model.peekTop(startRow, startCol);

        // Verification
        if (moved) {
            fail("No outOfBounds fail");
        }
        if (startPiece != 'R') {
            fail("Piece moved");
        }
    }

    @Test
    public void testCapture() {
        
    	// Setup
    	model = new Model();
    	
        model.movePiece(2, 0, 3, 1); // Move Red to (3, 1)
        model.movePiece(5, 2, 4, 1); // Move Black near Red
        int startRow = 3, startCol = 1;
        int endRow = 5, endCol = 3;
        String expected = "Top: R B :Bottom";

        // Method Execution
        boolean moved = model.movePiece(startRow, startCol, endRow, endCol);
        String actual = model.peek(endRow, endCol);
        boolean isStartEmpty = model.peekTop(startRow, startCol) == null;
        boolean isMiddleEmpty = model.peekTop(4, 2) == null;

        // Verification
        if (!moved) {
            fail("Red did not capture black.");
        }
        if (!actual.equals(expected)) {
            fail("No Stack.");
        }
        if (!isStartEmpty) {
            fail("Spot is not empty after capture.");
        }
        if (!isMiddleEmpty) {
            fail("4,2 is not empty after capture.");
        }
    }

    @Test
    public void testOutOfBounds() {
        
    	// Setup
    	model = new Model();
    	
        int invalidRow = -1, invalidCol = 0;

        // Method Execution
        boolean outOfBounds = model.outOfBounds(invalidRow, invalidCol);

        // Verification
        if (!outOfBounds) {
            fail("Did not go out of bounds.");
        }
    }

    @Test
    public void testPeekTopEmpty() {
        
    	// Setup
    	model = new Model();
    	
        int row = 3, col = 3;

        // Method Execution
        Character topPiece = model.peekTop(row, col);

        // Verification
        if (topPiece != null) {
            fail("Stack was not empty.");
        }
    }

    @Test
    public void testPeek() {
        
    	// Setup
    	model = new Model();
    	
        int row = 2, col = 0;
        String expected = "Top: R :Bottom";

        // Method Execution
        String actual = model.peek(row, col);

        // Verification
        if (!actual.equals(expected)) {
            fail("Incorrect stack info.");
        }
    }

    @Test
    public void testCheckForWinner() {
        
    	// Setup
    	model = new Model();
    	
        char red = 'R';
        char black = 'B';

        // Method Execution
        boolean redWon = model.checkForWinner(red);
        boolean blackWon = model.checkForWinner(black);

        // Verification
        if (redWon) {
            fail("Red should not have won.");
        }
        if (blackWon) {
            fail("Black should not have won.");
        }
    }

    @Test
    public void testCheckForWinnerPlayerWins() {
        
    	// Setup
    	model = new Model();
    	
        model.movePiece(5, 0, 6, 1); 
        model.movePiece(5, 2, 6, 3); 
        char black = 'B';
        char red = 'R';

        // Method Execution
        boolean blackWon = model.checkForWinner(black);
        boolean redWon = model.checkForWinner(red);

        // Verification
        if (!blackWon) {
            fail("Red is supposed to win.");
        }
        
        if (!redWon) {
            fail("Black is supposed to win.");
    }
}
}