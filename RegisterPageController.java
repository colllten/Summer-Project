import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPageController implements Initializable {
    @FXML
    private ComboBox<String> months;
    ObservableList<String> monthsList = FXCollections.observableArrayList("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    @FXML
    private ComboBox<Integer> days;
    ObservableList<Integer> daysList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
    @FXML
    private ComboBox<Integer> years;
    ObservableList<Integer> yearsList = FXCollections.observableArrayList(2001, 2002, 2003, 2004, 2005, 2006, 2007);
    @FXML
    private TextField fnText;
    @FXML
    private TextField lnText;
    @FXML
    private TextField emailText;
    @FXML
    private Button registerB;
    @FXML
    private PasswordField passText;
    @FXML
    private PasswordField cPassText;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField phText;
    @FXML
    private Button cancelB;

    private Stage stage;
    private Scene scene;

    public void register(ActionEvent event) {

        String passwordTest = String.valueOf(passText.getText());
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(passwordTest);
        boolean hasSpecialChar = matcher.find();

        /*
        try {
            if (Driver.matchingEmail(emailText.getValue())) {
                JOptionPane.showMessageDialog(null, "Email already in use", "Email Taken",
                        JOptionPane.ERROR_MESSAGE);
            }

            if(Driver.matchingUsername(usernameText.getValue())) {
                JOptionPane.showMessageDialog(null, "Username already in use", "Username Taken",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */

        if (fnText.getText().length() < 1 || fnText.getText().length() > 12) {
            JOptionPane.showMessageDialog(null, "Invalid first name length", "Error",
                    JOptionPane.WARNING_MESSAGE);
        } else if (lnText.getText().length() < 1 || lnText.getText().length() > 12) {
            JOptionPane.showMessageDialog(null, "Invalid first name length", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!emailText.getText().contains("@") || !emailText.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (usernameText.getText().length() < 3 || usernameText.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Invalid username length", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!passText.getText().equals(cPassText.getText())) {
            JOptionPane.showMessageDialog(null, "Password fields do not match", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (passText.getText().length() < 3 || passText.getText().length() > 12) {
            JOptionPane.showMessageDialog(null, "Invalid password length", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!hasSpecialChar) {
            JOptionPane.showMessageDialog(null, "Password does not contain a special character",
                    "Password Error", JOptionPane.ERROR_MESSAGE);
        } else {
            User user = new User(fnText.getText(), lnText.getText(), usernameText.getText(),
                    passText.getText(), phText.getText(), emailText.getText(),
                    months.getValue(), Integer.parseInt(days.getValue().toString()),
                    Integer.parseInt(years.getValue().toString()));
            System.out.println(user);
            System.out.println("Registration Success!");
        }

    }

    public void cancel() {

    }

    public void checkCreds() {

    }

    public void createUser() {
        
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        months.setItems(monthsList);
        days.setItems(daysList);
        years.setItems(yearsList);
    }

    public void switchToLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
