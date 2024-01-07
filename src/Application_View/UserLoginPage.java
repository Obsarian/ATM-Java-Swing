package Application_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserLoginPage extends Window {
    private JTextField acc_no_txt;
    private JPasswordField pin_txt;
    private JButton login;
    private JButton create_acc;
    private JButton back;

    public UserLoginPage() {
        this.setLayout(null);

        back = new JButton("Back");
        back.setFont(new Font("Verdana", Font.PLAIN, 18));
        back.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(back);

        // Account Number Entry
        JLabel acc_no_label = new JLabel("Account No.:", SwingConstants.RIGHT);
        acc_no_label.setFont(super.default_font);
        acc_no_label.setBounds(100, 150, 200, 30);
        this.add(acc_no_label);

        acc_no_txt = new JTextField(16);
        acc_no_txt.setFont(super.default_font);
        acc_no_txt.setBounds(400, 150, 250, 30);
        this.add(acc_no_txt);

        // PIN Entry
        JLabel pin_label = new JLabel("PIN:", SwingConstants.RIGHT);
        pin_label.setFont(super.default_font);
        pin_label.setBounds(100, 250, 200, 30);
        this.add(pin_label);

        pin_txt = new JPasswordField();
        pin_txt.setFont(super.default_font);
        pin_txt.setBounds(400, 250, 250, 30);
        this.add(pin_txt);

        // Login Button
        login = new JButton("LOGIN");
        login.setFont(super.default_font);
        login.setBounds(300, 330, 200, 40);
        this.add(login);

        // Account Creation Button
        create_acc = new JButton("CREATE AN ACCOUNT");
        create_acc.setFont(super.default_font);
        create_acc.setBounds(200, 420, 400, 40);
        this.add(create_acc);
    }

    public void load() {
        this.setVisible(true);
        acc_no_txt.setText("");
        pin_txt.setText("");
    }

    public String getAccountNo() {
        return acc_no_txt.getText();
    }

    public String getPIN() {
        return new String(pin_txt.getPassword());
    }

    public JButton getLoginButton() {
        return login;
    }

    public JButton getCreateAccountButton() {
        return create_acc;
    }

    public JButton getBackButton() {
        return back;
    }
}
