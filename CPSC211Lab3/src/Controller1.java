
public class Controller1 {
    private Model model;
    private View view;
    private Controller2 red;
    private Controller2 black;

    // Constructor
    public Controller1(Model model, View view) {
        this.model = model;
        this.view = view;
        this.red = new Controller2('R', model, view);
        this.black = new Controller2('B', model, view);
    }

    
    // Method to start the game
    public void startGame() {
        boolean gameIsRunning = true;

        while (gameIsRunning) {
            view.drawBoard();
            boolean yesPeek = true;
       while (yesPeek) {
        if (view.askForPeek()) {
        	int[] peekCoordinates = view.askForPeekCoordinates();
            int row = peekCoordinates[0];
            int col = peekCoordinates[1];
            model.peek(row, col);
            view.drawStack(row, col);
        }
        else {
        	yesPeek = false;
        }
       }
            
         
            while (!black.move()) {
                
            }
            
         
            if (model.checkForWinner('B')) {
                System.out.println("Black wins!");
                break;
            }

            view.drawBoard();

           
            while (!red.move()) {
               
            }

           
            if (model.checkForWinner('R')) {
                System.out.println("Red wins!");
                break;
            }
        }

        view.close();
    }
}


