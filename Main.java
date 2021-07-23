import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import java.awt.*;

public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws Exception {

        //Stage is like a JFrame

        Group root = new Group(); // Groups are like layout managers
        Scene scene = new Scene(root, Color.BLUE); //Scene is like a JPanel
        stage.setTitle("Welcome");

        //Image icon = new Image("icon.png"); Looks for image in src
        //stage.getIcons().add(icon); //Sets the top left image in window to new icon
        //stage.setWidth/Height(420); Sets dimensions of window
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press q to escape"); //Shows message of how to exit fullscreen mode
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        stage.setScene(scene);

        stage.show();
    }
}