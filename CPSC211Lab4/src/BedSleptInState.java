
public class BedSleptInState extends State {

    public BedSleptInState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
    	return "You are now well rested but you are still inside of a prison cell4. You are extremely thirsty. There is a bed, a television, and a bucket of water. There is a door to the north that seems to be cracked open.";
    }

    @Override
    public String[] getMenuActions() {
        return new String[]{"Go north", "Sleep in bed", "Turn on Television", "Drink Bucket of Water"};
    }

    @Override
    public void handleAction(int action) {
        if (action == 1) {
            model.changeState(new CentralRoomState(model));
        }
        if (action == 2) {
        	model.changeState(new BedSleptInState(model));
        	
        }
        if (action == 3) {
        	model.changeState(new TelevisionOnState(model));
        }
        
        if (action == 4) {
        	System.out.println("Why would you drink water from a bucket in a prison cell? You know exactly what that is used for! You have died.");
            System.out.println();
            model.changeState(new StartingRoomState(model));
        	model.changeState(new WaterDrankState(model));
        }
    }
}
