public class EndGameState extends State {

    private final boolean isVictory;

    public EndGameState(Model model, boolean isVictory) {
        super(model);
        this.isVictory = isVictory;
    }

    @Override
    public String getDescription() {
        if (isVictory) {
            return "Congratulations! You have escaped!";
        } else {
            return "Game Over. You have failed to escape.";
        }
    }

    @Override
    public String[] getMenuActions() {
        return new String[]{"Restart the game"};
    }

    @Override
    public void handleAction(int action) {
        if (action == 1) {
            // Restart the game by resetting the model and transitioning to the starting state
            model.changeState(new StartingRoomState(model));
        } 
    }
}
