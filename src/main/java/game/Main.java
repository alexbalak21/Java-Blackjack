package game;
import window.CardPanel;
import window.ImagePanel;
import window.Window;

import javax.swing.*;

public class Main {
    static void main() {
        Window window = new Window();
        window.frame.add(new CardPanel());
        window.display();
    }
}
