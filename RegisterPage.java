import javax.swing.*;
import java.awt.*;

public class RegisterPage extends JFrame {

    public RegisterPage() {

        //FRAME SETUP//
        setTitle("Account Registration");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //FRAME SETUP//

        //JPANEL SETUP//
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        add(panel, BorderLayout.CENTER);
        GridBagConstraints g = new GridBagConstraints();
        //JPANEL SETUP//

        //COMPONENTS//
        JLabel fName = new JLabel("First Name: ");
        JLabel lName = new JLabel("Last Name: ");
        JLabel email = new JLabel("Email: ");
        JLabel dob = new JLabel("Date of Birth: ");
        JLabel username = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        JLabel cpassword = new JLabel("Confirm Password: ");

        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");
        //COMPONENTS//
    }

}
