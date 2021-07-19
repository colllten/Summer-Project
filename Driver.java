import java.sql.*;

public class Driver {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Mollymay10";
    static final String QUERY = "SELECT birth_month FROM users";
    static final String STMT = "USE demo";

    public static void main(String[] args) throws SQLException {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            stmt.execute(STMT);
            String sql = "insert into users (last_name, first_name, email, username, password, birth_month," +
                    " birth_day, birth_year, phone_number) values ('LAdmin', 'FAdmin', 'admin@yahoo.com'," +
                    " 'Admin', 'Admin', 'July', 19, 2021, '7652995452')";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}