// scanner import to allow user input
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;


// Initializing the controller variables
public class GameController {
    private IsolaBoard b;
    private BoardView v;   
    private Scanner scnr;  
    private PrintWriter writer;

    // Calls in other methods
    public GameController() {
        b = new IsolaBoard(); 
        v = new BoardView(b); 
        scnr = new Scanner(System.in); 
    }

    // starts the game and gives Player 1 the first move
    public void start() {
        boolean run = true;
        try {
        writer = new PrintWriter (new File ("game.dat"));
        }
        catch (Exception ex) {
        	return;
        }
        BoardSpace activePlayer = BoardSpace.Player1; 

        // Displays which player's turn, move options, and the board itself
        while (run) {
          
            System.out.println(activePlayer + " Turn.");
            System.out.println();
            System.out.println("Choose a Cardinal Direction To Move: N, NE, E, SE, S, SW, W, or NW.");
            System.out.println();
            v.display();
            String cardinal = scnr.nextLine();
            BoardPosition currentPosition = b.findPosition(activePlayer);
            BoardPosition nextPosition = getNextPosition(currentPosition, cardinal);

       
            if (nextPosition != null) {
                b.movePlayer(activePlayer, nextPosition);
                writer.println(cardinal);
                
                BoardSpace winner = b.checkWinner();
                if (winner != BoardSpace.Available) {
                    v.display();
                    System.out.println("Player " + (winner == BoardSpace.Player1 ? "1" : "2") + " wins!");
                    run = false; 
                } else {
                    
                    activePlayer = (activePlayer == BoardSpace.Player1) ? BoardSpace.Player2 : BoardSpace.Player1;
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        scnr.close();
        writer.close();
    }

    
   // Code to show what each move does
    private BoardPosition getNextPosition(BoardPosition currentPosition, String cardinal) {
        int row = currentPosition.getRow();
        int col = currentPosition.getColumn();

        if (cardinal.equals("N")) {
        	row = row - 1;
        }
        else if (cardinal.equals("NE")) {
        	row = row - 1;
        	col = col + 1;
        }
        else if (cardinal.equals("E")) {
        	col = col + 1;
        }
        else if (cardinal.equals("SE")) {
        	row = row + 1;
        	col = col + 1;
        }
        else if (cardinal.equals("S")) {
        	row = row + 1;
        }
        else if (cardinal.equals("SW")) {
        	row = row + 1;
        	col = col - 1;
        }
        else if (cardinal.equals("W")) {
        	col = col - 1;
        }
        else if (cardinal.equals("NW")) {
        	row = row - 1;
        	col = col - 1;
        }
        else {
        	return null;
        }

        
        return (row >= 0 && row < b.getHeight() && col >= 0 && col < b.getWidth())
                ? new BoardPosition(row, col) : null;
    }

   

		
	}
		
		
	
	
	

	

