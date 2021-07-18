import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDate;

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
        JLabel cPassword = new JLabel("Confirm Password: ");
        JLabel showPassword = new JLabel("Show Password ");

        JCheckBoxMenuItem showPass = new JCheckBoxMenuItem();
        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");

        JTextField fNameText = new JTextField(8);
        JTextField lNameText = new JTextField(8);
        JTextField passText = new JTextField(10);
        JTextField passCText = new JTextField(10);
        JTextField emailText = new JTextField(10);
        JTextField usernameText = new JTextField(10);

        JComboBox months = new JComboBox();
        String[] monthsA = new String[13];
        monthsA[0] = "Null";
        monthsA[1] = "January";
        monthsA[2] = "February";
        monthsA[3] = "March";
        monthsA[4] = "April";
        monthsA[5] = "May";
        monthsA[6] = "June";
        monthsA[7] = "July";
        monthsA[8] = "August";
        monthsA[9] = "September";
        monthsA[10] = "October";
        monthsA[11] = "November";
        monthsA[12] = "December";
        for (int i = 1; i < monthsA.length; i++) {
            months.addItem(monthsA[i]);
        }
        JComboBox days = new JComboBox();
        JComboBox years = new JComboBox();

        //COMPONENTS//
    }
}
