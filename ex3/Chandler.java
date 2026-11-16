import java.util.Random;

public class Chandler implements Runnable {
    private Humor humor;
    private Random rand = new Random();
    private static final int JOKES_PER_DAY = 8;

    public Chandler() {
        // default technique
        humor = new SarcasmHumor();
        new Thread(this).start();
    }

    public void setHumor(Humor humor) {
        this.humor = humor;
    }

    public void performHumor() {
        humor.makeJoke();
    }

    // picks one of the three techniques at random
    private Humor randomHumor() {
        switch (rand.nextInt(3)) {
            case 0:
                return new SarcasmHumor();
            case 1:
                return new WitHumor();
            default:
                return new SelfDeprecationHumor();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < JOKES_PER_DAY; i++) {
                Thread.sleep(3000);
                setHumor(randomHumor());
                performHumor();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
