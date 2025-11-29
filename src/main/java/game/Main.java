package game;
import window.CardPanel;
import window.Window;



public class Main {
    static void main() {
        Window window = new Window();
        window.frame.add(new CardPanel());
        window.display();
    }
}
