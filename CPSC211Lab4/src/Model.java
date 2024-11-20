import java.io.*;
import java.util.*;

public class Model {
    private State currentState;
    private List<State> states;
    private Map<StateTypes, Boolean> flags;
    private String saveFileName = "game_save.txt";

    public Model() {
        flags = new HashMap<>();
        initializeStates();
        currentState = states.get(0); // Start in the first state
    }

    private void initializeStates() {
        states = new ArrayList<>();
        states.add(new StartingRoomState(this));
        states.add(new CentralRoomState(this));
        states.add(new StudyRoomState(this));
        states.add(new LockedRoomState(this));
        states.add(new BedSleptInState(this));
        states.add(new DeskSearchedState(this));
        states.add(new FireplaceOnState(this));
        states.add(new TelevisionOnState(this));
        states.add(new WaterDrankState(this));
        states.add(new SecretRoomState(this));
        
        
        // Add more states as needed, following this pattern
    }

    public String getCurrentStateSituation() {
        return currentState.getDescription();
    }

    public String[] getCurrentMenu() {
        return currentState.getMenuActions();
    }

    public void processAction(int action) {
        currentState.handleAction(action);
    }

    public void saveGame() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(saveFileName))) {
            writer.println(currentState.getClass().getSimpleName());
            flags.forEach((flag, value) -> writer.println(flag + ":" + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try (BufferedReader reader = new BufferedReader(new FileReader(saveFileName))) {
            String stateName = reader.readLine();
            currentState = states.stream()
                .filter(state -> state.getClass().getSimpleName().equals(stateName))
                .findFirst()
                .orElse(states.get(0)); // Default to the first state if not found
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                flags.put(StateTypes.valueOf(parts[0]), Boolean.parseBoolean(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFlag(StateTypes flag, boolean value) {
        flags.put(flag, value);
    }
    
    public boolean hasKey() {
    	return getFlag(StateTypes.HAS_KEY);
    }
    
    public void findKey() {
    	setFlag(StateTypes.HAS_KEY, true);
    }

    public boolean getFlag(StateTypes flag) {
        return flags.getOrDefault(flag, false);
    }

    public void changeState(State newState) {
        currentState = newState;
    }

    public boolean isGameComplete() {
        return getFlag(StateTypes.GAME_COMPLETE);
        
    
    }
    public void restartGame() {
    	flags.clear();
    	initializeStates();
    	currentState = states.get(0);
    }
}

