
public abstract class State {
    protected Model model;

    public State(Model model) {
        this.model = model;
    }

    public abstract String getDescription();
    public abstract String[] getMenuActions();
    public abstract void handleAction(int action);
}
