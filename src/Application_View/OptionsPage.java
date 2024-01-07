package Application_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Currency;

public class OptionsPage extends Window {
    private JLabel nme;
    private JLabel acc;
    private JLabel bal;

    private JButton logout;
    private JButton deposit;
    private JButton withdraw;

    public OptionsPage() {

        this.setLayout(null);

        // Account Details Display
        JPanel acc_det = new JPanel();
        nme = new JLabel();
        acc = new JLabel();
        nme.setFont(new Font("Verdana", Font.BOLD, 14));
        acc.setFont(new Font("Verdana", Font.BOLD, 14));
        acc_det.setLayout(new GridLayout(2,1));
        acc_det.setBounds(10, 10, 300, 50);
        acc_det.add(nme);
        acc_det.add(acc);
        this.add(acc_det);

        // Logout Button
        logout = new JButton("Logout");
        logout.setFont(new Font("Verdana", Font.PLAIN, 18));
        logout.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(logout);

        // Balance
        bal = new JLabel();
        bal.setFont(super.default_font);
        bal.setHorizontalAlignment(JLabel.CENTER);
        bal.setBounds(200, 150, 400, 100);
        this.add(bal);

        // Deposit Option
        deposit = new JButton("DEPOSIT");
        deposit.setFont(super.default_font);
        deposit.setBounds(150, 250, 250, 150);
        this.add(deposit);

        // Deposit Option
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(super.default_font);
        withdraw.setBounds(400, 250, 250, 150);
        this.add(withdraw);
    }

    public void load(String name, String acc_no, double balance) {
        nme.setText("Name: " + name);
        acc.setText("Account no.: " + acc_no);
        bal.setText("Balance: " + Currency.getInstance("INR").getSymbol() + " " + balance);

        this.setVisible(true);
    }

    public JButton getLogoutButton() {
        return logout;
    }

    public JButton getDepositButton() {
        return deposit;
    }

    public JButton getWithdrawButton() {
        return withdraw;
    }

    public void setBalance(double balance) {
        bal.setText("Balance: " + Currency.getInstance("INR").getSymbol() + " " + balance);
    }
}
