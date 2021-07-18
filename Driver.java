import java.sql.*;

public class Driver {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Mollymay10";
    static final String QUERY = "SELECT * FROM users";
    static final String STMT = "USE demo";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet useDB = stmt.executeQuery(STMT);
            ResultSet rs = stmt.executeQuery(QUERY)) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Last Name: " + rs.getString("last_name"));
                System.out.print(", First Name: " + rs.getString("first_name"));
                System.out.println(", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
