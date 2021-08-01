import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class LoginPageController extends Stage {
    @FXML private Button register;
    @FXML private Button login;
    @FXML private TextField usernameText;
    @FXML private PasswordField passwordText;

    private User loggedUser; // Used for @initData()

    private Stage stage;
    private Scene scene;

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Mollymay10";
    static final String QUERY = "SELECT username FROM users";
    static final String STMT = "USE demo";


    public void login(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
            stmt.execute(STMT);
            ResultSet rs = stmt.executeQuery(QUERY);

            boolean usernameFound = false;
            boolean passwordFound = false;

            //Searches for username in the DB
            while (rs.next()) {
                String currentUsername = rs.getString("username");
                if (username.equals(currentUsername)) {
                    usernameFound = true;
                    break;
                }
            }

            // If username is not found, user is notified and function ends
            if (!usernameFound) {
                JOptionPane.showMessageDialog(null, "Incorrect login information");
            } else {
                ResultSet rs1 = stmt.executeQuery("SELECT password FROM users WHERE username = '" + username + "'");
                while (rs1.next()) {
                    String currentPassword = rs1.getString("password");
                    if (password.equals(currentPassword)) {
                        passwordFound = true;
                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
                        User user = new User(null, null, null, null, null, null, null, 0, 0);
                        while (rs2.next()) {
                            user.setLn(rs2.getString("last_name"));
                            user.setFn(rs2.getString("first_name"));
                            user.setUsername(rs2.getString("username"));
                            user.setPassword(rs2.getString("password"));
                            user.setPhoneNum(rs2.getString("phone_number"));
                            user.setEmail(rs2.getString("email"));
                            user.setbMonth(rs2.getString("birth_month"));
                            user.setbDay(rs2.getInt("birth_day"));
                            user.setbYear(rs2.getInt("birth_year"));
                        }
                        sendData(e, user);
                        break;
                    }
                }
                if (!passwordFound) {
                    JOptionPane.showMessageDialog(null, "Incorrect login information");
                }
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void sendData (ActionEvent e, User user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ExpensesPage.fxml"));
        Parent expensesPageParent = loader.load();
        Scene expensesPage = new Scene(expensesPageParent);

        ExpensesPageController controller = loader.getController();
        controller.initData(user);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(expensesPage);
        window.show();
    }


    public void switchToRegisterPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegisterPage.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
