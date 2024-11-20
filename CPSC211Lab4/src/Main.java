
public class Main {
    
	public static void main(String[] args) {
        Main main = new Main();
        main.go();
    }
	
	public void go() {
		Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
	}
}
