import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2ServerModeExample {

    // PRE CONDITION:
    // STEP #1: Start H2 Server
    // java -jar h2-2.2.224.jar
    // STEP #2: Access H2 Web console
    // http://localhost:8082
    // STEP #3: Login with below JDBC URL and credentials and keep it running
    // JDBC URL: jdbc:h2:~/h2/test
    // Username: sa
    // Password:
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/h2/test";
        String username = "sa";
        String password = "";

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Connected to H2 in server mode.");

        String sql = "Create table if not exists students (ID int primary key, name varchar(50))";

        Statement statement = connection.createStatement();

        statement.execute(sql);

        System.out.println("Created table students.");

        sql = "Insert into students (ID, name) values (1, 'Ajay')";

        int rows = statement.executeUpdate(sql);

        if (rows > 0) {
            System.out.println("Inserted a new row.");
        }

        sql = "SELECT * FROM students";

        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        while (resultSet.next()) {
            count++;

            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println("Student #" + count + ": " + ID + ", " + name);
        }
        connection.close();

    }
}
