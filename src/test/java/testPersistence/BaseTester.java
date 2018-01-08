package testPersistence;

import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTester {
    @Before
    public void setUp() {

        String url = "jdbc:mysql://localhost:3306/internship?characterEncoding=utf8&useSSL=false";
        String user = "root";
        String pass = "admin";

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            String sql = "TRUNCATE `internship`.`student`;";
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
