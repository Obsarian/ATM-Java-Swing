import Application_View.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Random;

import java.sql.*;

public class Controller {
    private String name;
    private LocalDate dob;
    private String acc_no;
    private String pin;
    private double balance;

    private String uname;
    private String pwd;

    private final Database db;

    private final StartPage startPage;
    private final AdminLoginPage adminLoginPage;
    private final UserLoginPage userLoginPage;
    private final AccountCreationPage accountCreationPage;
    private final AccountDeletionPage accountDeletionPage;
    private final AdminPage adminPage;
    private final OptionsPage optionsPage;
    private final DepositPage depositPage;
    private final WithdrawPage withdrawPage;

    Controller() {
        name = "";
        dob = null;
        acc_no = "";
        pin = "";
        balance = 0.0;

        uname = "";
        pwd = "";

        db = new Database("jdbc:mysql://localhost:3307/atm", "root", "");
        db.connectToDb();

        startPage = new StartPage();
        adminLoginPage = new AdminLoginPage();
        userLoginPage = new UserLoginPage();
        accountCreationPage = new AccountCreationPage();
        accountDeletionPage = new AccountDeletionPage();
        adminPage = new AdminPage();
        optionsPage = new OptionsPage();
        depositPage = new DepositPage();
        withdrawPage = new WithdrawPage();

        createListeners();

        startPage.load();
    }

    private void createListeners() {
        // START PAGE
        startPage.getUserLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPage.unload();
                userLoginPage.load();
            }
        });
        startPage.getAdminLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPage.unload();
                adminLoginPage.load();
            }
        });
        startPage.getQuitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPage.unload();
                db.disconnectFromDb();
                System.exit(0);
            }
        });

        // ADMIN LOGIN PAGE
        adminLoginPage.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLoginPage.unload();
                startPage.load();
            }
        });
        adminLoginPage.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = db.runSelectQuery(String.format("SELECT * FROM admins WHERE `username`='%s' AND `password`='%s'", adminLoginPage.getUsername(), adminLoginPage.getPassword()));

                if(db.getRowCount(rs)==0) {
                    new PopUpWindow("NOT AN ADMIN!");
                }
                else {
                    uname = adminLoginPage.getUsername();
                    pwd = adminLoginPage.getPassword();
                    adminLoginPage.unload();
                    adminPage.load(uname);
                    try {
                        ResultSet rs2 = db.runSelectQuery("SELECT * FROM users");
                        StringBuilder resultSet = new StringBuilder();
                        resultSet.append("Name\tDOB\tAccount_No.\t\tPIN\tBalance\n");
                        resultSet.append("-------------------------------------------------------------------------------------------------------------------------\n");
                        while (rs2.next()) {
                            String n = rs2.getString("name");
                            String d = rs2.getDate("dob").toString();
                            String a = rs2.getString("account_no");
                            String p = rs2.getString("pin");
                            String b = String.valueOf(rs2.getDouble("balance"));
                            resultSet.append(n).append("\t").append(d).append("\t").append(a).append("\t").append(p).append("\t").append(b).append("\n");
                        }
                        adminPage.printTable(resultSet.toString());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        // ADMIN PAGE
        adminPage.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPage.unload();
                adminLoginPage.load();
            }
        });
        adminPage.getRefreshButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = db.runSelectQuery("SELECT * FROM users");
                    StringBuilder resultSet = new StringBuilder();
                    resultSet.append("Name\tDOB\tAccount_No.\t\tPIN\tBalance\n");
                    resultSet.append("-------------------------------------------------------------------------------------------------------------------------\n");
                    while (rs.next()) {
                        String n = rs.getString("name");
                        String d = rs.getDate("dob").toString();
                        String a = rs.getString("account_no");
                        String p = rs.getString("pin");
                        String b = String.valueOf(rs.getDouble("balance"));
                        resultSet.append(n).append("\t").append(d).append("\t").append(a).append("\t").append(p).append("\t").append(b).append("\n");
                    }
                    adminPage.printTable(resultSet.toString());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        adminPage.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLoginPage.unload();
                accountCreationPage.load(true);
            }
        });
        adminPage.getDeleteAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLoginPage.unload();
                accountDeletionPage.load();
            }
        });

        // USER LOGIN PAGE
        userLoginPage.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = db.runSelectQuery(String.format("SELECT * FROM users WHERE `account_no`=%s AND `pin`=%s", userLoginPage.getAccountNo(), userLoginPage.getPIN()));

                if(db.getRowCount(rs)==0) {
                    new PopUpWindow("Account doesn't exist!");
                }
                else {
                    acc_no = userLoginPage.getAccountNo();
                    pin = userLoginPage.getPIN();
                    try {
                        rs = db.runSelectQuery(String.format("SELECT `name`,`dob`,`balance` FROM users WHERE `account_no`=%s AND `pin`=%s", acc_no, pin));
                        rs.next();
                        name = rs.getString("name");
                        dob = rs.getDate("dob").toLocalDate();
                        balance = rs.getDouble("balance");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    userLoginPage.unload();
                    optionsPage.load(name, acc_no, balance);
                }
            }
        });
        userLoginPage.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLoginPage.unload();
                accountCreationPage.load(false);
            }
        });
        userLoginPage.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLoginPage.unload();
                startPage.load();
            }
        });

        // CREATE ACCOUNT PAGE
        accountCreationPage.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountCreationPage.unload();
                if(!accountCreationPage.getIsAdmin()) userLoginPage.load();
                else adminPage.load(uname);
            }
        });
        accountCreationPage.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = accountCreationPage.getUserName();
                acc_no = generateAccountNumber();
                dob = accountCreationPage.getDOB();
                pin = accountCreationPage.getPIN();
                balance = 100.0;

                db.runQuery(String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', '%f')", name, dob, acc_no, pin, balance));
                accountCreationPage.unload();
                if(!accountCreationPage.getIsAdmin()) optionsPage.load(name, acc_no, balance);
                else adminPage.load(uname);
                new PopUpWindow("Your Account no. is: " + acc_no + ". SAVE IT! After clicking 'OK' it will be GONE FOREVER!");
            }
        });

        // DELETE ACCOUNT PAGE
        accountDeletionPage.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountDeletionPage.unload();
                adminPage.load(uname);
            }
        });
        accountDeletionPage.getDeleteAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = accountDeletionPage.getAccountNo();
                String p = accountDeletionPage.getPIN();
                ResultSet rs = db.runSelectQuery(String.format("SELECT * FROM users WHERE `account_no`=%s AND `pin`=%s", a, p));

                if(db.getRowCount(rs)==0) {
                    new PopUpWindow("Account doesn't exist!");
                }
                else {
                    db.runQuery(String.format("DELETE FROM users WHERE `account_no`=%s AND `pin`=%s", a, p));
                    accountDeletionPage.unload();
                    adminPage.load(uname);
                    new PopUpWindow("Account has been DELETED successfully!");
                }
            }
        });

        // OPTIONS PAGE
        optionsPage.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = "";
                acc_no = "";
                dob = null;
                pin = "";
                balance = 0.0;

                optionsPage.unload();
                userLoginPage.load();
            }
        });
        optionsPage.getDepositButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsPage.unload();
                depositPage.load();
            }
        });
        optionsPage.getWithdrawButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsPage.unload();
                withdrawPage.load();
            }
        });

        // DEPOSIT PAGE
        depositPage.getCancelButton().addActionListener(e -> {
            depositPage.unload();
            optionsPage.load(name, acc_no, balance);
        });
        depositPage.getDepositAmountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = depositPage.getAmount();
                balance += amount;
                db.runQuery(String.format("UPDATE `users` SET `balance`=%f WHERE `account_no`=%s", balance, acc_no));
                depositPage.unload();
                optionsPage.load(name, acc_no, balance);
                new PopUpWindow("YAY! Amount has ben deposited successfully!");
            }
        });

        // WITHDRAW PAGE
        withdrawPage.getCancelButton().addActionListener(e -> {
            withdrawPage.unload();
            optionsPage.load(name, acc_no, balance);
        });
        withdrawPage.getWithdrawAmountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = withdrawPage.getAmount();
                if(amount > balance) {
                    new PopUpWindow("Amount higher than balance cannot be withdrawn! TRANSACTION CANCELLED!");
                }
                else {
                    balance -= amount;
                    db.runQuery(String.format("UPDATE `users` SET `balance`=%f WHERE `account_no`=%s", balance, acc_no));
                    withdrawPage.unload();
                    optionsPage.load(name, acc_no, balance);
                    new PopUpWindow("YAY! Amount has ben withdrawn successfully!");
                }
            }
        });
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        boolean flag = true;
        String p1 = "0000", p2 = "0000", p3 = "0000", p4 = "0000";

        while(flag) {
            p1 = String.valueOf(rand.nextInt(9000) + 1000);
            p2 = String.valueOf(rand.nextInt(9000) + 1000);
            p3 = String.valueOf(rand.nextInt(9000) + 1000);
            p4 = String.valueOf(rand.nextInt(9000) + 1000);
            ResultSet rs = db.runSelectQuery(String.format("SELECT `account_no` FROM users WHERE `account_no`=%s", p1 + p2 + p3 + p4));
            if(db.getRowCount(rs)==0) flag = false;
        }

        return p1+p2+p3+p4;
    }
}
