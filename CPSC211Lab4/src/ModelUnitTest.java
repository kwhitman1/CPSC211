import org.junit.*;

import static org.junit.Assert.*;

public class ModelUnitTest {


    

    @Test
    public void testInitialState() {
        // Set up
        Model model = new Model();

        // Method execution
        String initialState = model.getCurrentStateSituation();

        // Verification
        if (!"StartingRoomState".equals(initialState)) {
            fail("Expected 'StartingRoomState' as the initial state, but got '" + initialState + "' instead.");
        }
    }


    @Test
    public void testStateChange() {
        // Set up
        Model model = new Model();
        State centralRoom = new CentralRoomState(model);

        // Method execution
        model.changeState(centralRoom);
        String currentState = model.getCurrentStateSituation();

        // Verification
        if (!"CentralRoomState".equals(currentState)) {
            fail("Expected 'CentralRoomState', but got '" + currentState + "' instead.");
        }
    }


    @Test
    public void testSetAndGetFlags() {
        // Set up
        Model model = new Model();
        StateTypes testFlag = StateTypes.HAS_KEY;

        // Method execution
        model.setFlag(testFlag, true);
        boolean flagValueAfterSet = model.getFlag(testFlag);
        model.setFlag(testFlag, false);
        boolean flagValueAfterUnset = model.getFlag(testFlag);

        // Verification
        if (!flagValueAfterSet) {
            fail("Expected flag " + testFlag + " to be true after setting it, but got false.");
        }
        if (flagValueAfterUnset) {
            fail("Expected flag " + testFlag + " to be false after unsetting it, but got true.");
        }
    }


    @Test
    public void testSaveAndLoadGame() {
        // Set up
        Model model = new Model();
        State lockedRoom = new LockedRoomState(model);
        model.changeState(lockedRoom);
        model.setFlag(StateTypes.HAS_KEY, true);
        model.saveGame();

        // Method execution
        Model loadedModel = new Model();
        loadedModel.loadGame();
        String loadedState = loadedModel.getCurrentStateSituation();
        boolean hasKey = loadedModel.getFlag(StateTypes.HAS_KEY);

        // Verification
        if (!"LockedRoomState".equals(loadedState)) {
            fail("Expected 'LockedRoomState' after loading, but got '" + loadedState + "' instead.");
        }
        if (!hasKey) {
            fail("Expected HAS_KEY flag to be true after loading, but it was false.");
        }
    }


    @Test
    public void testRestartGame() {
        // Set up
        Model model = new Model();
        State lockedRoom = new LockedRoomState(model);
        model.changeState(lockedRoom);
        model.setFlag(StateTypes.HAS_KEY, true);

        // Method execution
        model.restartGame();
        String currentStateAfterRestart = model.getCurrentStateSituation();
        boolean hasKeyFlagAfterRestart = model.getFlag(StateTypes.HAS_KEY);

        // Verification
        if (!"StartingRoomState".equals(currentStateAfterRestart)) {
            fail("Expected state to reset to 'StartingRoomState' after restart, but got '" + currentStateAfterRestart + "'.");
        }
        if (hasKeyFlagAfterRestart) {
            fail("Expected HAS_KEY flag to be false after restart, but it was true.");
        }
    }


    @Test
    public void testGameCompletion() {
        // Set up
        Model model = new Model();

        // Method execution
        boolean initialCompletionStatus = model.isGameComplete();
        model.setFlag(StateTypes.GAME_COMPLETE, true);
        boolean updatedCompletionStatus = model.isGameComplete();

        // Verification
        if (initialCompletionStatus) {
            fail("Expected game completion status to be false initially, but got true.");
        }
        if (!updatedCompletionStatus) {
            fail("Expected game completion status to be true after setting GAME_COMPLETE flag, but got false.");
        }
    }

}
