import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ExpensesPageController {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Mollymay10";
    static final String STMT = "USE demo";

    private Stage stage;
    private Scene scene;

    @FXML private TextField delivery;
    @FXML private TextField tips;
    @FXML private TextField otherProfit;
    @FXML private TextField grocery;
    @FXML private TextField gas;
    @FXML private TextField bills;
    @FXML private TextField rent;
    @FXML private TextField food;
    @FXML private TextField car;
    @FXML private TextField otherLoss;
    @FXML private Button cancel;
    @FXML private Button submit;
    @FXML private Button stats;
    @FXML private Button settings;
    @FXML private Label welcomeName;
    @FXML private DatePicker calendar;

    private User loggedUser;

    /**
     * Accepts a User to initialize to send to home page
     * @param user
     */
    public void initData(User user) {
        loggedUser = user;
        welcomeName.setText(user.getFn());
    }

    public void switchToSettings (ActionEvent e) throws IOException {
        sendDataToSettings(e, loggedUser);
    }

    public void switchToStats (ActionEvent e) throws SQLException, IOException {
        sendDataToStats(e, loggedUser);
    }

    public void switchToLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sendDataToStats(ActionEvent actionEvent, User user) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StatsPage.fxml"));
        Parent statsPageParent = loader.load();
        Scene statsPage = new Scene(statsPageParent);

        StatsPageController controller = loader.getController();
        controller.initData(user);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(statsPage);
        window.show();
    }

    public void sendDataToSettings(ActionEvent actionEvent, User user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SettingsPage.fxml"));
        Parent settingsPageParent = loader.load();
        Scene settingsPage = new Scene(settingsPageParent);

        SettingsPageController controller = loader.getController();
        controller.initData(user);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(settingsPage);
        window.show();
    }

    public void addExpenses(ActionEvent e) throws SQLException {
        int userIDNum = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(STMT);
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE username = '" + loggedUser.getUsername() + "'");
            while (rs.next()) {
                userIDNum = rs.getInt("id");
            }
            if (calendar.getValue() == null) {
                JOptionPane.showMessageDialog(null, "Please select a date", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String sql = "INSERT INTO expenses (user_id, month, year, profit, groceries, car_maintenance, gas, bills," +
                        " rent, food, other, net_profit, spending_money) VALUES (" +
                        userIDNum + ", '"
                        + calendar.getValue().getMonth().toString() + "', " + calendar.getValue().getYear()
                        + ", " +
                        (Double.parseDouble(delivery.getText()) + Double.parseDouble(tips.getText()) +
                                Double.parseDouble(otherProfit.getText())) + ", " +
                        Double.parseDouble(grocery.getText()) + ", "
                        + Double.parseDouble(car.getText()) + ", " +
                        Double.parseDouble(gas.getText()) + ", " +
                        Double.parseDouble(bills.getText()) + ", " +
                        Double.parseDouble(rent.getText()) + ", " +
                        Double.parseDouble(food.getText()) + ", " +
                        Double.parseDouble(otherLoss.getText()) + ", " +
                        ((Double.parseDouble(delivery.getText()) +
                        Double.parseDouble(tips.getText()) + Double.parseDouble(otherProfit.getText())) -
                        (Double.parseDouble(grocery.getText()) + Double.parseDouble(car.getText()) +
                                Double.parseDouble(gas.getText()) + Double.parseDouble(bills.getText()) +
                                Double.parseDouble(rent.getText()) + Double.parseDouble(food.getText()) +
                                Double.parseDouble(otherLoss.getText()))) + "," +
                        (Double.parseDouble(tips.getText()) * 0.25 + Double.parseDouble(otherProfit.getText()) * 0.5
                        - Double.parseDouble(otherLoss.getText()) - Double.parseDouble(food.getText())) + ")";
                stmt.execute(sql);
                JOptionPane.showMessageDialog(null, "Expenses added!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
