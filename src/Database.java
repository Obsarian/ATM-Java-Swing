import java.sql.*;

public class Database {
    private String url;
    private String username;
    private String password;
    private Connection con;

    Database(String url, String uname, String pwd) {
        this.url = url;
        this.username = uname;
        this.password = pwd;
    }

    public void connectToDb() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTED TO DATABASE!");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void disconnectFromDb() {
        try {
            con.close();
            System.out.println("DISCONNECTED FROM DATABASE!");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet runSelectQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void runQuery(String query) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public int getRowCount(ResultSet resultSet) {
        try {
            int rowCount = 0;
            while (resultSet.next()) {rowCount++;}
            return rowCount;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
