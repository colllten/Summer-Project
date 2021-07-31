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

    @FXML
    private void receiveData(MouseEvent event) {
        // Step 1
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Step 2
        User user = (User) stage.getUserData();
        // Step 3
        System.out.println(user.getFn());
    }

    private User userLogged;


    public void initData(User user) {
        userLogged = user;
        
    }

    public void switchToLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
