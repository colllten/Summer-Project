import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        stage.show();

        /*
        Image icon = new Image("icon.png"); Looks for image in src
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press q to escape"); //Shows message of how to exit fullscreen mode
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
         */
    }
}