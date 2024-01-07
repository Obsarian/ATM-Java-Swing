package Application_View;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    protected Font default_font;

    Window() {
        default_font = new Font("Verdana", Font.PLAIN, 24);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("ATM");
        this.centralize();
    }

    public void centralize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    public void load() {
        this.centralize();
        this.setVisible(true);
    }

    public void unload() {
        this.setVisible(false);
    }
}
