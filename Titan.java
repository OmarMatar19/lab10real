import java.util.Random;

public class Titan implements Observer {
    private String name;
    private UI ui;
    private Random rand = new Random();

    public Titan(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        eren.attach(this);
    }

    @Override
    public void update(int erenEnergy) {
        if (rand.nextBoolean()) {
            ui.display(name + " attacks Eren!");
            if (erenEnergy > 40) {
                ui.display(name + ": \"Now we got problems, and I don't think we can solve 'em\"");
            }
        }
    }
}
