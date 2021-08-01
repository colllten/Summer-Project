import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SettingsPageController {

    @FXML private TextField usernameText;
    @FXML private TextField emailText;
    @FXML private TextField phText;
    @FXML private PasswordField passwordText;
    @FXML private PasswordField cpasswordText;

    private User loggedUser;

    public void initData(User user) {
        loggedUser = user;
        usernameText.setText(user.getUsername());
        emailText.setText(user.getEmail());
        phText.setText(user.getPhoneNum());
        passwordText.setText(user.getPassword());
        cpasswordText.setText(user.getPassword());
    }


}
