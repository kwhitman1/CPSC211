public class DeskSearchedState extends State {

    

    public DeskSearchedState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return "A mutant rat jumped out and ate your face. You have died.";
    }

    @Override
    public String[] getMenuActions() {
    	return new String[]{"Restart Game"};
    }

    @Override
    public void handleAction(int action) {
        if (action == 1) {
        model.changeState(new StartingRoomState(model));
        }
    }
}