import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {

    @FXML

    public void up(ActionEvent e) {
        System.out.println("Up");
    }

    public void left(ActionEvent e) {
        System.out.println("Left");
    }

    public void right(ActionEvent e) {
        System.out.println("Right");
    }

    public void down(ActionEvent e) {
        System.out.println("Down");
    }
}
