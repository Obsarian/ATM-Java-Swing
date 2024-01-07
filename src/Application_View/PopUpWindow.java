package Application_View;

import javax.swing.*;
import java.awt.*;

public class PopUpWindow extends Window {
    public PopUpWindow(String msg) {
        this.setLayout(new BorderLayout());
        Font pop_up_font = new Font("Arial", Font.BOLD, 16);

        JLabel mes_lab = new JLabel(msg);
        mes_lab.setFont(pop_up_font);
        this.add(mes_lab, BorderLayout.NORTH);

        JButton ok = new JButton("OK");
        ok.setFont(pop_up_font);
        ok.addActionListener(e -> {
            this.unload();
            this.dispose();
        });
        this.add(ok, BorderLayout.SOUTH);

        this.pack();
        this.centralize();
        this.load();
    }
}
