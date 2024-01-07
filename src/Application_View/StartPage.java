package Application_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StartPage extends Window {
    private JButton user_login;
    private JButton admin_login;
    private JButton quit;

    public StartPage() {
        this.setLayout(null);

        // Welcome Title
        JLabel welcome_title = new JLabel("WELCOME TO ATM");
        welcome_title.setFont(super.default_font);
        welcome_title.setHorizontalAlignment(JLabel.CENTER);
        welcome_title.setBounds(100, 100, 600, 100);
        this.add(welcome_title);

        // User Login
        user_login = new JButton("USER LOGIN");
        user_login.setFont(super.default_font);
        user_login.setBounds(100, 250, 280, 170);
        this.add(user_login);

        // Admin Login
        admin_login = new JButton("ADMIN LOGIN");
        admin_login.setFont(super.default_font);
        admin_login.setBounds(420, 250, 280, 170);
        this.add(admin_login);

        // Quit Button
        quit = new JButton("QUIT");
        quit.setFont(super.default_font);
        quit.setBounds(325, 450, 150, 50);
        this.add(quit);
    }

    public JButton getUserLoginButton() {
        return user_login;
    }
    public JButton getAdminLoginButton() {
        return admin_login;
    }
    public JButton getQuitButton() {
        return quit;
    }
}
