
public class Main {

	public static void main(String[] args) {
		Main m = new Main ();
		m.go();

	}
	
	public void go ()
	{
		IsolaBoard board = new IsolaBoard();
		BoardView view = new BoardView(board);
		
		view.display();
	}

}
