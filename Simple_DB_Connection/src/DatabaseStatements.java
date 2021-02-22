import java.sql.*;

public class DatabaseStatements {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://root:root@localhost/java_course?serverTimezone=CET");
        System.out.println("Database connected");
        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement
        
        ResultSet resultSet = statement.executeQuery
                ("select firstName, mi, lastName from Student where lastName "
                        + " = 'Smith'");

        // Iterate through the result and print the student names
        while (resultSet.next())
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3));

        // Close the connection
        connection.close();

    }
}
