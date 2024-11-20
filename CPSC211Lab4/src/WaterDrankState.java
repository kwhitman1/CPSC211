public class WaterDrankState extends State {

    public WaterDrankState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
    	return "You can save or restart.";
    }

    @Override
    public String[] getMenuActions() {
        return new String[]{"Restart Game."};
    }

    @Override
    public void handleAction(int action) {
    	System.out.println("Restarting Game.");
    	model.changeState(new StartingRoomState(model));
    	
    }
}