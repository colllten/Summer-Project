import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ExpensesPageController {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField delivery;
    @FXML
    private TextField tips;
    @FXML
    private TextField otherProfit;
    @FXML
    private TextField grocery;
    @FXML
    private TextField gas;
    @FXML
    private TextField bills;
    @FXML
    private TextField rent;
    @FXML
    private TextField food;
    @FXML
    private TextField car;
    @FXML
    private TextField otherLoss;

    @FXML
    private Button cancel;
    @FXML
    private Button submit;
    @FXML
    private Button stats;
    @FXML
    private Button settings;

    public void switchToRegisterPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegisterPage.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
