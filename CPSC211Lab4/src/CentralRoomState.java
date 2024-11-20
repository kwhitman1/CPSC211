
public class CentralRoomState extends State {

    public CentralRoomState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return "You realize you are in a medieval dungeon. In this next room, there is an electric fireplace. A door leads south, a door leads west, a door leads north, and a door leads east";
    }

    @Override
    public String[] getMenuActions() {
        return new String[]{"Turn on the fireplace.", "Go south", "Go west", "Go east", "Go north"};
    }

    @Override
    public void handleAction(int action) {
        if (action == 1) {
            System.out.println("A fuse explodes on the fireplace. The impact to your body was fatal. You have died.");
            System.out.println();
            System.out.println("The game has restarted.");
            System.out.println();
            model.changeState(new StartingRoomState(model));
        } 
        else if (action == 2) {
            model.changeState(new StartingRoomState(model));
        }
        else if (action == 3) {
        	if (model.hasKey()) {
        		model.changeState(new LockedRoomState(model));
        	}
        	else {
        		System.out.println("You are standing in front of a locked door. This might be the way out!");
        		}
        }
        else if (action == 4) {
        	model.changeState(new StudyRoomState(model));

}
        else if (action == 5) {
        	model.changeState(new SecretRoomState(model));
        }
    }
}
