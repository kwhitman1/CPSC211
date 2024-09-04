
public class BoardView {
	
	IsolaBoard board;

	public BoardView(IsolaBoard b) {
		
		board = b;
	}

	public void display() {
		
		drawLine1();
		drawLine2();
		
		
	}

}
