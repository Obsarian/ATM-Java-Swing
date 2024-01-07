package Application_View;

import Application_View.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WithdrawPage extends Window {
    private JTextField amt;
    private JButton deduct_amt;
    private JButton cancel;

    public WithdrawPage() {
        this.setLayout(null);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Verdana", Font.PLAIN, 18));
        cancel.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(cancel);

        JLabel lab = new JLabel("Enter amount to withdraw");
        lab.setFont(super.default_font);
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setBounds(100, 200, 600, 100);
        this.add(lab);

        amt = new JTextField(24);
        amt.setFont(super.default_font);
        amt.setHorizontalAlignment(JTextField.CENTER);
        amt.setBounds(250, 320, 300, 50);
        this.add(amt);

        deduct_amt = new JButton("WITHDRAW");
        deduct_amt.setFont(super.default_font);
        deduct_amt.setBounds(275, 400, 250, 40);
        this.add(deduct_amt);
    }

    public JButton getCancelButton() {
        return cancel;
    }

    public double getAmount() {
        return Double.parseDouble(amt.getText());
    }
    public JButton getWithdrawAmountButton() {
        return deduct_amt;
    }
}
