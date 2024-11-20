public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        if (view.promptForLoad()) {
            model.loadGame();
        }
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            view.displayDescription(model.getCurrentStateSituation());
            String[] options = model.getCurrentMenu();
            view.displayMenu(options);

            int choice = view.getMenuChoice(options.length);
            if (choice == options.length + 1) { // Save game option
                model.saveGame();
                System.out.println("Game saved.");
            } else {
                model.processAction(choice);
                if (model.isGameComplete()) {
                    System.out.println("Congratulations! You've completed the game.");
                    break;
                }
            }
        }
    }
}

