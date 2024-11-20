public class FireplaceOnState extends State {

    public FireplaceOnState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return "What would you like to do? ";
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