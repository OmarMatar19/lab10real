import java.util.Random;

public class Friend implements Observer {
    private String name;
    private UI ui;
    private Random rand = new Random();

    public Friend(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        eren.attach(this);
    }

    @Override
    public void update(int erenEnergy) {
        if (rand.nextBoolean()) {
            ui.display(name + ": \"Eren, please be safe!\"");
        }
        if (erenEnergy < 20) {
            ui.display(name + ": \"Rage, rage against the dying of the light\"");
        }
    }
}
