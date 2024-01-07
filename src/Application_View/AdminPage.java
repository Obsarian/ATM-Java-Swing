package Application_View;

import javax.swing.*;
import java.awt.*;

public class AdminPage extends Window {
    private JButton logout;
    private JLabel unme;
    private JTextArea users;
    private JButton refresh;
    private JButton delete_acc;
    private JButton create_acc;

    public AdminPage() {
        this.setLayout(null);

        logout = new JButton("Logout");
        logout.setFont(new Font("Verdana", Font.PLAIN, 18));
        logout.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(logout);

        unme = new JLabel();
        unme.setFont(new Font("Verdana", Font.BOLD, 14));
        unme.setBounds(10, 10, 300, 25);
        this.add(unme);

        refresh = new JButton("Refresh");
        refresh.setFont(new Font("Verdana", Font.PLAIN, 16));
        refresh.setBounds(110,100,180,50);
        this.add(refresh);

        create_acc = new JButton("Create Acc.");
        create_acc.setFont(new Font("Verdana", Font.PLAIN, 16));
        create_acc.setBounds(310,100,180,50);
        this.add(create_acc);

        delete_acc = new JButton("Delete Acc.");
        delete_acc.setFont(new Font("Verdana", Font.PLAIN, 16));
        delete_acc.setBounds(510,100,180,50);
        this.add(delete_acc);

        users = new JTextArea();
        users.setFont(new Font("Arial", Font.PLAIN, 15));
        users.setBounds(100, 180, 600, 200);
        users.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(users);
        this.add(users);
    }

    public void load(String uname) {
        unme.setText("Username: " + uname);
        this.setVisible(true);
    }

    public JButton getLogoutButton() {
        return logout;
    }

    public JButton getRefreshButton() {
        return refresh;
    }
    public JButton getCreateAccountButton() {
        return create_acc;
    }
    public JButton getDeleteAccountButton() {
        return delete_acc;
    }

    public void printTable(String table) {
        users.setText(table);
    }
}
