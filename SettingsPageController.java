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

import java.io.IOException;

public class SettingsPageController {

    @FXML private TextField usernameText;
    @FXML private TextField emailText;
    @FXML private TextField phText;
    @FXML private PasswordField passwordText;
    @FXML private PasswordField cpasswordText;
    @FXML private Button submit;
    @FXML private Button cancel;

    private User loggedUser;

    public void initData(User user) {
        loggedUser = user;
        usernameText.setText(user.getUsername());
        emailText.setText(user.getEmail());
        phText.setText(user.getPhoneNum());
        passwordText.setText(user.getPassword());
        cpasswordText.setText(user.getPassword());
    }

    public void switchToExpensesPage(ActionEvent e) throws IOException {
        sendData(e, loggedUser);
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


}
