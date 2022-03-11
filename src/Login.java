import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login{

    Login(){
    
    JFrame newFrame = new JFrame("Log in");
    JPanel jp1 = new JPanel();
    JLabel userName = new JLabel("User Name");
    JTextField userName1 = new JTextField("Enter Name", 16);
    JPasswordField passwordField = new JPasswordField(16);
    JLabel passwordField1 = new JLabel("Password");
    JButton submit = new JButton("Submit");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    jp1.add(userName);
    jp1.add(userName1);
    jp1.add(passwordField);
    jp1.add(passwordField1);
    jp1.add(submit);

    
    submit.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            newFrame.dispose();




            if (e.getSource() == submit) {
                String userText;
                String pwdText;
                userText = userName1.getText();
                pwdText = passwordField1.getText();

                if (userText.equalsIgnoreCase("User") && pwdText.equalsIgnoreCase("12345")) {
                    JOptionPane.showMessageDialog(showPassword, this, "Login Successful", 0);
                        // MAO NI SYA ANG MU TAWAG SA APP NGA CLASS DAYUN IYANG I PAKITA
                        // AYUHA ANG IF STATEMENT NGA MO MO GANA
                        App test = new App();
                        test.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(showPassword, this, "Invalid Username or Password", 0);
                }
     
            }
           
            if (e.getSource() == resetButton) {
                userName1.setText("");
                passwordField.setText("");
            }
    
            if (e.getSource() == showPassword) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
     
     
            }
        }
 
    });
    newFrame.add(jp1);
    newFrame.setVisible(true);
    newFrame.setSize(500,500);


}
public static void main(String[] args) {

    new Login();
}
}
