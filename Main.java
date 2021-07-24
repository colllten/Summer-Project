
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import java.awt.*;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.scene.shape.*;
import javafx.scene.image.*;

public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws Exception {

        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root1));
        stage.show();

        //Stage is like a JFrame

        Group root = new Group(); // Groups are like layout managers
        Scene scene = new Scene(root, 600, 600, Color.SKYBLUE); //Scene is like a JPanel, can add color as second param
        stage.setTitle("Welcome");

        /*

        //SCENES + DRAWING//
        Text text = new Text(); //needs to be added to root node
        text.setText("Wow");
        text.setX(50); //sets x-coord
        text.setY(50); //sets y-coord
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.GREY); //Colors the text
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(300);
        line.setStrokeWidth(65); // Makes line thicker
        line.setStroke(Color.CRIMSON);
        root.getChildren().add(text); // adds the text node
        root.getChildren().add(line);
        //SCENES + DRAWING//

         */


        /*
        //Image icon = new Image("icon.png"); Looks for image in src
        //stage.getIcons().add(icon); //Sets the top left image in window to new icon
        //stage.setWidth/Height(420); Sets dimensions of window
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press q to escape"); //Shows message of how to exit fullscreen mode
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

         */

        /*
        stage.setScene(scene);
        stage.show();

         */
    }
}