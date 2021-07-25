import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterPageController {

    @FXML
    private TextField fnText;
    @FXML
    private TextField lnText;
    @FXML
    private TextField emailText;
    @FXML
    private Button registerB;

    String name;

    public void register(ActionEvent event) {
        name = fnText.getText();
        System.out.println(name);
    }

    public void cancel() {

    }

    public void checkCreds() {

    }

    public void createUser() {
        
    }


}
