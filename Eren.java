import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Eren implements Subject, Runnable {
    private int energy;
    private UI ui;
    private List<Observer> observers = new CopyOnWriteArrayList<>();
    private Random rand = new Random();

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
        new Thread(this).start();
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(energy);
        }
    }

    @Override
    public void run() {
        try {
            while (energy > 0) {
                // wait a random 5 to 10 seconds before the next transformation
                Thread.sleep((rand.nextInt(6) + 5) * 1000);

                ui.display("\n>>> Eren transforms into a Titan! (Energy: " + energy + ")");
                notifyObservers();

                // stays a titan for 10 seconds
                Thread.sleep(10000);

                energy -= 5;
                ui.display(">>> Eren turns back to human form. Energy left: " + energy);
            }
            ui.display("\nEren is out of energy and can't transform anymore.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
