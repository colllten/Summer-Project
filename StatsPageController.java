import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML private Label spendingMoney;
    @FXML private Label totalPlusMinus;
    @FXML private Button returnToExpenses;

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
        spendingMoney.setText(("Spending Money: " + getSpendingMoney(user.getUsername())));
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
                for (Double sum : sums) {
                    total = total + sum;
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
    
    public double getSpendingMoney(String username) throws SQLException {
        int userID = 0;
        ArrayList<Double> spendingMoney = new ArrayList<>();
        double spendingAmount = 0.0;
    
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(STMT);
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE username = '" + username + "'");
            while (rs.next()) {
                userID = rs.getInt("id");
            }
            rs = stmt.executeQuery("SELECT spending_money FROM expenses WHERE user_id = " + userID);
            while (rs.next()) {
                spendingMoney.add(rs.getDouble("spending_money"));
            }
            for (int i = 0; i < spendingMoney.size(); i++) {
                spendingAmount = spendingAmount + spendingMoney.get(i);
            }
        }
        return spendingAmount;
    }

    public void switchToExpensesPage(ActionEvent e) throws IOException {
        sendDataToExpenses(e, loggedUser);
    }

    public void sendDataToExpenses(ActionEvent actionEvent, User user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ExpensesPage.fxml"));
        Parent expensesPageParent = loader.load();
        Scene expensesPage = new Scene(expensesPageParent);

        ExpensesPageController controller = loader.getController();
        controller.initData(user);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(expensesPage);
        window.show();
    }
}
