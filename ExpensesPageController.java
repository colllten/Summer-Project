import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ExpensesPageController {

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

    private User loggedUser;

    /**
     * Accepts a User to initialize to send to home page
     * @param user
     */
    public void initData(User user) {
        loggedUser = user;
    }



    public void switchToSettings (ActionEvent e, User user) throws IOException {
        sendData(e, user);
    }

    public void switchToLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void sendData(ActionEvent actionEvent, User user) throws IOException {
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
}
