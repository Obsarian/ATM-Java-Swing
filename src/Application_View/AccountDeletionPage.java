package Application_View;

import javax.swing.*;
import java.awt.*;

public class AccountDeletionPage extends Window {
    private final JButton back;
    private final JButton delete;
    private final JTextField acc_no;
    private final JPasswordField pin;

    public AccountDeletionPage() {
        this.setLayout(null);

        back = new JButton("Back");
        back.setFont(new Font("Verdana", Font.PLAIN, 18));
        back.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(back);

        JLabel acc_no_lab = new JLabel("Account No.:", SwingConstants.RIGHT);
        acc_no_lab.setFont(super.default_font);
        acc_no_lab.setBounds(100, 150, 200, 30);
        this.add(acc_no_lab);

        acc_no = new JTextField();
        acc_no.setFont(super.default_font);
        acc_no.setBounds(400, 150, 250, 30);
        this.add(acc_no);

        JLabel pin_lab = new JLabel("PIN:", SwingConstants.RIGHT);
        pin_lab.setFont(super.default_font);
        pin_lab.setBounds(100, 250, 200, 30);
        this.add(pin_lab);

        pin = new JPasswordField();
        pin.setFont(super.default_font);
        pin.setBounds(400, 250, 250, 30);
        this.add(pin);

        delete = new JButton("DELETE ACCOUNT");
        delete.setFont(super.default_font);
        delete.setBounds(250, 330, 300, 40);
        this.add(delete);
    }

    public void load() {
        this.setVisible(true);
        acc_no.setText("");
        pin.setText("");
    }

    public String getAccountNo() {
        return acc_no.getText();
    }

    public String getPIN() {
        return new String(pin.getPassword());
    }

    public JButton getDeleteAccountButton() {
        return delete;
    }

    public JButton getBackButton() {
        return back;
    }
}
