import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.*;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ExpensesPage.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome");
        stage.setResizable(false);
        stage.getIcons().add(new Image("TXLogo.png"));
        stage.show();
    }
}