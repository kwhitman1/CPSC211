

public class Main {

	// static main to run go method
	public static void main(String[] args) {
		Main m = new Main ();
		m.go();
		
		
		

	}
	
	// go method to run all of the classes for the Isola Game
	public void go ()
	{
		GameController c = new GameController();
		c.start();
		IsolaBoard board = new IsolaBoard();
		BoardView view = new BoardView(board);
		ReplayController r = new ReplayController();
		r.replay();
		
		
		view.display();
	}

}
