package Application_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DepositPage extends Window {
    private JTextField amt;
    private JButton add_amt;
    private JButton cancel;

    public DepositPage() {
        this.setLayout(null);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Verdana", Font.PLAIN, 18));
        cancel.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(cancel);

        JLabel lab = new JLabel("Enter amount to deposit");
        lab.setFont(super.default_font);
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setBounds(100, 200, 600, 100);
        this.add(lab);

        amt = new JTextField(24);
        amt.setFont(super.default_font);
        amt.setHorizontalAlignment(JTextField.CENTER);
        amt.setBounds(250, 320, 300, 50);
        this.add(amt);

        add_amt = new JButton("ADD");
        add_amt.setFont(super.default_font);
        add_amt.setBounds(275, 400, 250, 40);
        this.add(add_amt);
    }

    public JButton getCancelButton() {
        return cancel;
    }

    public double getAmount() {
        return Double.parseDouble(amt.getText());
    }
    public JButton getDepositAmountButton() {
        return add_amt;
    }
}
