
public class SecretRoomState extends State {

    public SecretRoomState(Model model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return "Welcome to the secret room! There is nothing here for you but thanks for showing up.";
    }

    @Override
    public String[] getMenuActions() {
        return new String[]{"Go back"};
    }

    @Override
    public void handleAction(int action) {
        if (action == 1) {
            model.changeState(new CentralRoomState(model));
        } 
        
}
        
    }
