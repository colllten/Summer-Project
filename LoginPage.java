import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {

        //FRAME SETUP//
        setTitle("Welcome!");
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

        //TEXTFIELDS, LABELS, BUTTONS//
        JLabel username = new JLabel("Username: ");
        JLabel password = new JLabel("Password");
        JTextField usernameTxt = new JTextField(10);
        JTextField passwordTxt = new JTextField(10);
        JCheckBox showPass = new JCheckBox("Show Password");
        JButton login = new JButton("Login");
        JButton signUp = new JButton("Sign Up");
        //TEXTFIELDS, LABELS, BUTTONS//

        //PANEL LAYOUT//
        g.gridx = 0;
        g.gridy = 0;
        panel.add(username, g);
        g.gridy++;
        panel.add(password, g);
        //PANEL LAYOUT//
        setVisible(true);

    }
}