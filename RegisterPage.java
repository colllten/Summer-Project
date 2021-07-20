import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Scan database for matching email & username | Turn password text field into password field

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
        JLabel phoneNum = new JLabel("Phone #: ");

        JCheckBoxMenuItem showPass = new JCheckBoxMenuItem();
        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");

        JTextField fNameText = new JTextField(8);
        JTextField lNameText = new JTextField(8);
        JTextField passText = new JTextField(10);
        JTextField passCText = new JTextField(10);
        JTextField emailText = new JTextField(10);
        JTextField usernameText = new JTextField(10);
        JTextField phoneNumText = new JTextField(12);

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
        String[] daysA = new String[32];
        for (int i = 1; i < 32; i++) {
            daysA[i] = Integer.toString(i);
        }
        JComboBox years = new JComboBox();
        int[] yearsA = new int[100];
        int x = 0;
        for (int i = 1922; i < 2022; i++) {
            yearsA[x] = i;
            x++;
        }
        //COMPONENTS//

        //USER CREATION LOGIC//
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String passwordTest = passText.getText();
                Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                Matcher matcher = pattern.matcher(passwordTest);
                boolean hasSpecialChar = matcher.find();

                if (fNameText.getText().length() < 1 || fNameText.getText().length() > 12) {
                    JOptionPane.showMessageDialog(null, "Invalid first name length", "Error",
                            JOptionPane.WARNING_MESSAGE);
                } else if (lNameText.getText().length() < 1 || lNameText.getText().length() > 12) {
                    JOptionPane.showMessageDialog(null, "Invalid first name length", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!emailText.getText().contains("@") || !emailText.getText().contains(".")) {
                    JOptionPane.showMessageDialog(null, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //TODO: matching email?
                else if (usernameText.getText().length() < 3 || usernameText.getText().length() > 10) {
                    JOptionPane.showMessageDialog(null, "Invalid username length", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //TODO: scan database for matching username
                else if (!passText.getText().equals(passCText.getText())) {
                    JOptionPane.showMessageDialog(null, "Password fields do not match", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (passText.getText().length() < 3 || passText.getText().length() > 12) {
                    JOptionPane.showMessageDialog(null, "Invalid password length", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!hasSpecialChar) {
                    JOptionPane.showMessageDialog(null, "Password does not contain a special character",
                            "Password Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    User user = new User(fNameText.getText(), lNameText.getText(), usernameText.getText(),
                            passText.getText(), phoneNumText.getText(), emailText.getText(),
                            months.getSelectedItem().toString(), Integer.parseInt(days.getSelectedItem().toString()),
                            Integer.parseInt(years.getSelectedItem().toString()));
                }

            }
        });
        //USER CREATION LOGIC//
    }
}
