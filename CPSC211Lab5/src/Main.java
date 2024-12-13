
public class Main {

	public static void main(String[] args) {
		Main main = new Main ();
		main.go();

	}
	
	public void go() {
        View view = new View();
        Controller controller = new Controller(view);
        controller.start();
    }
	}


