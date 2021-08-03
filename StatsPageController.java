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

    private User loggedUser;

    public void initData(User user) throws SQLException {
        loggedUser = user;
        int userID = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(STMT);

            //Getting the id from users so I can search it in the expenses table and add all of their expenses
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE username = '" + user.getUsername() + "'");
            while (rs.next()) {
                userID = rs.getInt("id");
            }

            // TODO: test this query in the DB
            //TODO: turn all of this into a function
            rs = stmt.executeQuery("SELECT * FROM expenses where user_id = " + userID + "and month = 'JANUARY'");
            if (rs.isBeforeFirst()) {
                ArrayList<Double> sums = new ArrayList<>();
                while (rs.next()) {
                    sums.add(rs.getDouble("net_profit"));
                }
                double total = 0.00;
                for (int i = 0; i < sums.size(); i++) {
                    total = total + sums.get(i);
                }
                january.setText("January: " + total);
            }
        }
    }
}
