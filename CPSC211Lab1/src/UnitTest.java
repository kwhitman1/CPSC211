import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {


    

    @Test
    public void getWidth() {
    	
    	// Setup
    	IsolaBoard b = new IsolaBoard();
    	
        // Method Execution
    	int w = b.getWidth();

        // Verification
        if (w >= 7) {
        	fail("Width can't be longer than 7");
        }
        if (w <= 7) {
        	fail("Width can't be shorter than 7");
        }
            
        
    }

    @Test
    public void getHeight() {
    	
    	// Setup
    	IsolaBoard b = new IsolaBoard();
    	
        // Method Execution
    	int h = b.getHeight();
        
        // Verification
        if (h >= 7) {
        	fail("Height can't be longer than 7");
        }
        if (h <= 7) {
        	fail("Height can't be shorter than 7");
        }
    }

    @Test
    public void testGet() {
    	
    	// Setup
    	IsolaBoard b = new IsolaBoard();
    	
        // Method Execution
        b.movePlayer(BoardSpace.Player1, new BoardPosition(0, 4));

        // Verification
        if (b.get(0, 4) != BoardSpace.Player1) {
        	fail("Expected return, got " + b.get(0, 4));
        }
        if (b.get(0, 2) != BoardSpace.Player2) {
        	fail("Expected return, got " + b.get(0, 2));
        }
        if (b.get(0, 2) != BoardSpace.Available) {
        	fail("Expected return, got " + b.get(0, 2));
        }
        if (b.get(1, 1) != BoardSpace.Missing) {
        	fail("Expected return, got " + b.get(1, 1));
        }
    }

    @Test
    public void testFindPosition() {
    	
    	// Setup
    	IsolaBoard b = new IsolaBoard();
    	
        // Method Execution
    	BoardPosition p = b.findPosition(BoardSpace.Player1);

        // Verification
    	if (p.getRow() != 0|| p.getColumn() != 3) {
    		fail("Did not get first row");
    	}
    }

    @Test
    public void testMovePlayer() {
    	
    	// Setup
    	IsolaBoard b = new IsolaBoard();
    	
        // Method Execution
        b.movePlayer(BoardSpace.Player1, new BoardPosition(1,2));
        b.movePlayer(BoardSpace.Player2, new BoardPosition(2,4));
        
        // Verification
        if (b.get(1, 2) != BoardSpace.Player1) {
        	fail("Incorrect Input");
        }
        if (b.get(2, 4) != BoardSpace.Player2) {
        	fail("Incorrect Input");
        }
    }

    @Test
    public void testCheckWinner() {
    	
    	// Setup
    	IsolaBoard b = new IsolaBoard();
    	
    	// Method Execution
    	BoardView v = new BoardView(b);
        
        // Verification
    	if (b.checkWinner()!= BoardSpace.Available) {
    		fail("Should not be a winner when BoardSpace is Available");
    	}
        
    }
}
