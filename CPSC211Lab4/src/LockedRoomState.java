public class LockedRoomState extends State {

    public LockedRoomState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        if (model.getFlag(StateTypes.DOOR_UNLOCKED)) {
return "You escaped the dungeon! There is a reward for you waiting. It is a huge treasure chest!";
        } else {
            return "You are standing in front of a locked door.";
        }
    }

    @Override
    public String[] getMenuActions() {
        if (model.getFlag(StateTypes.DOOR_UNLOCKED)) {
            return new String[]{"Search the treasure chest", "Go back"};
        } else if (model.hasKey()) {
            return new String[]{"Use the key to unlock the door", "Go back"};
        } else {
            return new String[]{"Go back"};
        }
    }

    @Override
    public void handleAction(int action) {
        if (!model.getFlag(StateTypes.DOOR_UNLOCKED) && model.hasKey() && action == 1) {
            System.out.println("You unlocked the door with the key!");
            model.setFlag(StateTypes.DOOR_UNLOCKED, true);
        } else if (action == 2 || (model.getFlag(StateTypes.DOOR_UNLOCKED) && action == 1)) {
       
            System.out.println();
            System.out.println("The game will now restart.");
            System.out.println();
            model.changeState(new StartingRoomState(model));
            
        }
    

    if (model.hasKey()) {
        model.setFlag(StateTypes.GAME_COMPLETE, true);
        model.changeState(new EndGameState(model, true)); // Victory
    } else {
        model.changeState(new EndGameState(model, false)); // Failure
    }

}
}
