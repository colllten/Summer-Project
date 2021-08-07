import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.*;
import java.util.Objects;

// TODO: Create "tips" and "other" column in the expenses table in SQL

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome");
        stage.setResizable(false);
        stage.getIcons().add(new Image("TXLogo.png"));
        stage.show();
    }
}