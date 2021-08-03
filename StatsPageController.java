import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.*;
import java.util.ArrayList;

public class StatsPageController {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Mollymay10";
    static final String STMT = "USE demo";

    @FXML private Label january;
    @FXML private Label february;
    @FXML private Label march;
    @FXML private Label april;
    @FXML private Label may;
    @FXML private Label june;
    @FXML private Label july;
    @FXML private Label august;
    @FXML private Label september;
    @FXML private Label october;
    @FXML private Label november;
    @FXML private Label december;
    @FXML private Label userStats;
    @FXML private Label totalPlusMinus;

    private User loggedUser;

    public void initData(User user) throws SQLException {
        loggedUser = user;
        january.setText(getMonthlyProfit("January", user.getUsername()));
        february.setText(getMonthlyProfit("February", user.getUsername()));
        march.setText(getMonthlyProfit("March", user.getUsername()));
        april.setText(getMonthlyProfit("April", user.getUsername()));
        may.setText(getMonthlyProfit("May", user.getUsername()));
        june.setText(getMonthlyProfit("June", user.getUsername()));
        july.setText(getMonthlyProfit("July", user.getUsername()));
        august.setText(getMonthlyProfit("August", user.getUsername()));
        september.setText(getMonthlyProfit("September", user.getUsername()));
        october.setText(getMonthlyProfit("October", user.getUsername()));
        november.setText(getMonthlyProfit("November", user.getUsername()));
        december.setText(getMonthlyProfit("December", user.getUsername()));
        userStats.setText(user.getUsername() + "'s Stats");
        totalPlusMinus.setText("Total Profit : " + getTotalPlusMinus(user.getUsername()));
    }

    public String getMonthlyProfit (String month, String username) {
        int userID = 0;
        String labelText = "No data";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(STMT);

            //Getting the id from users so I can search it in the expenses table and add all of their expenses
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE username = '" + username + "'");
            while (rs.next()) {
                userID = rs.getInt("id");
            }
            rs = stmt.executeQuery("SELECT * FROM expenses where user_id = " + userID + " and month = '" +
                    month + "'");
            if (rs.isBeforeFirst()) {
                ArrayList<Double> sums = new ArrayList<>();
                while (rs.next()) {
                    sums.add(rs.getDouble("net_profit"));
                }
                double total = 0.00;
                for (int i = 0; i < sums.size(); i++) {
                    total = total + sums.get(i);
                }
                labelText = month + ": " + total;
                return labelText;
            } else {
                labelText = month + ": No Data";
                return labelText;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return labelText;
    }

    public double getTotalPlusMinus(String username) throws SQLException {
        int userID = 0;
        ArrayList<Double> totalPlusMinus = new ArrayList<>();
        double totalAmount = 0.0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
            stmt.execute(STMT);
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE username = '" + username + "'");
            while (rs.next()) {
                userID = rs.getInt("id");
            }
            rs = stmt.executeQuery("SELECT net_profit FROM expenses WHERE user_id = " + userID);
            while (rs.next()) {
                totalPlusMinus.add(rs.getDouble("net_profit"));
            }
            for (int i = 0; i < totalPlusMinus.size(); i++) {
                totalAmount = totalAmount + totalPlusMinus.get(i);
            }
        }
        return totalAmount;
    }
}
