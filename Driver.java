import java.sql.*;

public class Driver {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Mollymay10";
    static final String STMT = "USE demo";
    //PARAM User user
    public static boolean matchingEmail(String email) throws SQLException {
        boolean matches = false;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();){
            stmt.execute(STMT); //Puts us into demo
            String sql = "SELECT email FROM users";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                String currentEmail = rs.getString("email");
                if (email.equals(currentEmail)) {
                    matches = true;
                    stmt.close();
                    rs.close();
                    return matches;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void sendToDB(User user) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();) {
            stmt.execute(STMT);
            String sql = "INSERT INTO users(last_name, first_name, email, username, password, birth_month," +
                    " birth_day, birth_year, phone_number) VALUES ('"+ user.getLn() + "','" + user.getFn() + "','" +
                    user.getEmail() + "','" + user.getUsername() + "','" + user.getPassword() + "','" +
                    user.getbMonth() + "'," + user.getbDay() + "," + user.getbYear() + ",'" + user.getPhoneNum() + "')";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean matchingUsername(String username) throws SQLException {
        boolean matches = false;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();) {
            stmt.execute(STMT); //Puts us into demo
            String sql = "SELECT username FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String currentUsername = rs.getString("username");
                if (username.equals(currentUsername)) {
                    matches = true;
                    stmt.close();
                    return matches;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}