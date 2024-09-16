
// Displays the board to the user
public class BoardView {
	
	IsolaBoard board;

	// Brings in IsolaBoard code
	public BoardView(IsolaBoard b) {
		
		board = b;
	}

	// displays the board
	public void display() {
		
		drawBoard();
		
		
	}
	
	// class to draw the board with for loops 
	private void drawBoard() {
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				
				BoardSpace s = board.get(row, col);
				if (s == BoardSpace.Available) {
					System.out.print("-");
				}
				else if (s == BoardSpace.Player1) {
					System.out.print("1");
				}
				else if (s == BoardSpace.Player2) {
					System.out.print("2");
				}
				else if (s == BoardSpace.Missing) {
					System.out.print(" ");
				}
				else {
					System.out.print("ER");
				}
			}
			System.out.println();
		}
	}
	
	

}
