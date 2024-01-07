package Application_View;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class AccountCreationPage extends Window {
    private boolean isAdmin;
    private JTextField name_txt;
    private DatePicker dob_pick;
    private JPasswordField pin_txt;
    private JButton create_acc;
    private JButton back;

    public AccountCreationPage() {
        this.isAdmin = false;

        this.setLayout(null);

        back = new JButton("Back");
        back.setFont(new Font("Verdana", Font.PLAIN, 18));
        back.setBounds(this.getWidth()-145, 10, 120, 40);
        this.add(back);

        // Name Entry
        JLabel name_label = new JLabel("Name:", SwingConstants.RIGHT);
        name_label.setFont(super.default_font);
        name_label.setBounds(100, 150, 200, 30);
        this.add(name_label);

        name_txt = new JTextField();
        name_txt.setFont(super.default_font);
        name_txt.setBounds(400, 150, 250, 30);
        this.add(name_txt);

        // DOB Entry
        JLabel dob_label = new JLabel("DOB:", SwingConstants.RIGHT);
        dob_label.setFont(super.default_font);
        dob_label.setBounds(100, 200, 200, 30);
        this.add(dob_label);

        dob_pick = new DatePicker();
        dob_pick.setFont(super.default_font);
        dob_pick.setBounds(400, 200, 250, 30);
        this.add(dob_pick);

        // PIN Entry
        JLabel pin_label = new JLabel("PIN:", SwingConstants.RIGHT);
        pin_label.setFont(super.default_font);
        pin_label.setBounds(100, 250, 200, 30);
        this.add(pin_label);

        pin_txt = new JPasswordField();
        pin_txt.setFont(super.default_font);
        pin_txt.setBounds(400, 250, 250, 30);
        this.add(pin_txt);

        // Account Creation Button
        create_acc = new JButton("CREATE AN ACCOUNT");
        create_acc.setFont(super.default_font);
        create_acc.setBounds(200, 320, 400, 40);
        this.add(create_acc);
    }

    public void load(boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.setVisible(true);
        name_txt.setText("");
        dob_pick.setDateToToday();
        pin_txt.setText("");
    }

    public JButton getBackButton() {
        return back;
    }

    public JButton getCreateAccountButton() {
        return create_acc;
    }

    public String getUserName() {
        return name_txt.getText();
    }

    public LocalDate getDOB() {
        return dob_pick.getDate();
    }
    public String getPIN() {
        return new String(pin_txt.getPassword());
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}
