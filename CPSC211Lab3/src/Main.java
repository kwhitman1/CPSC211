
public class Main {

	public static void main(String[] args) {
		Main m = new Main ();
		m.go();

	}
	// method to read all classes
	public void go () {
		Model model = new Model();
		View view = new View(model);
		Controller1 controller = new Controller1(model, view);
		controller.startGame();
	}

}