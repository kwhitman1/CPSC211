public class StudyRoomState extends State {

    private boolean keyFound = false; // Tracks if the key has already been collected

    public StudyRoomState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return "You are in what seems to have been an old medieval study room. There is a desk and one book left on the bookshelf.";
    }

    @Override
    public String[] getMenuActions() {
        if (!keyFound) {
            return new String[]{"Search the desk","Search the book", "Go back"};
        } else {
            return new String[]{"Go back"};
        }
    }

    @Override
    public void handleAction(int action) {
    	if (!keyFound && action == 1) {
    		model.changeState(new DeskSearchedState(model));
    	}
    	else if (!keyFound && action == 2) {
            model.findKey(); // Update model to reflect key acquisition
            keyFound = true;
            System.out.println("You found a key! Could be useful...");
    	}
        else if (action == 2 || (keyFound)) {
            // Go back to another state (e.g., StartingRoomState)
            model.changeState(new CentralRoomState(model));
        }
    }
}
