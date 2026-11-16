// Shared printer for every character. synchronized so lines from
// different threads never get mixed together.
public class UI {
    public synchronized void display(String msg) {
        System.out.println(msg);
    }
}
