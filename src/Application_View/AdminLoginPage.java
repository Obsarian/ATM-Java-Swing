package Application_View;

import javax.swing.*;
import java.awt.*;

public class AdminLoginPage extends Window {
    private JTextField uname_txt;
    private JPasswordField pwd_txt;
    private JButton login;
    private JButton back;

    public AdminLoginPage() {
        this.setLayout(null);

        back = new JButton("Back");
        back.setFont(new Font("Verdana", Font.PLAIN, 18));
        back.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(back);

        // Account Number Entry
        JLabel uname_label = new JLabel("Username:", SwingConstants.RIGHT);
        uname_label.setFont(super.default_font);
        uname_label.setBounds(100, 150, 200, 30);
        this.add(uname_label);

        uname_txt = new JTextField(16);
        uname_txt.setFont(super.default_font);
        uname_txt.setBounds(400, 150, 250, 30);
        this.add(uname_txt);

        // PIN Entry
        JLabel pwd_label = new JLabel("Password:", SwingConstants.RIGHT);
        pwd_label.setFont(super.default_font);
        pwd_label.setBounds(100, 250, 200, 30);
        this.add(pwd_label);

        pwd_txt = new JPasswordField();
        pwd_txt.setFont(super.default_font);
        pwd_txt.setBounds(400, 250, 250, 30);
        this.add(pwd_txt);

        // Login Button
        login = new JButton("LOGIN");
        login.setFont(super.default_font);
        login.setBounds(300, 330, 200, 40);
        this.add(login);
    }

    public void load() {
        this.setVisible(true);
        uname_txt.setText("");
        pwd_txt.setText("");
    }

    public String getUsername() {
        return uname_txt.getText();
    }

    public String getPassword() {
        return new String(pwd_txt.getPassword());
    }

    public JButton getLoginButton() {
        return login;
    }

    public JButton getBackButton() {
        return back;
    }
}
