
public class TelevisionOnState extends State {

    public TelevisionOnState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return "The television is on. It it showing modern news. You wonder why you are in a medieval dungeon in present-day. You are extremely thirsty. There is a bed, a television, and a bucket of water. There is a door to the north that seems to be cracked open.";
    }

    @Override
    public String[] getMenuActions() {
        return new String[]{"Go north", "Sleep in bed", "Turn off Television", "Drink Bucket of Water"};
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
        	model.changeState(new StartingRoomState(model));
        }
        
        if (action == 4) {
        	System.out.println("Why would you drink water from a bucket in a prison cell? You know exactly what that is used for! You have died.");
            System.out.println();
            model.changeState(new StartingRoomState(model));
        	model.changeState(new WaterDrankState(model));
        }
    }
}
