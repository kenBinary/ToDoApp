import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class Login{

    Login(){
    
    JFrame newFrame = new JFrame("Log in");
    JPanel jp1 = new JPanel();
    jp1.setLayout(new GridLayout(6,1));
    JLabel loginTitle = new JLabel("User Login Form",SwingConstants.CENTER);
    loginTitle.setFont(new Font("Serif", Font.PLAIN, 20));
    loginTitle.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 10));
    JLabel userName = new JLabel("User Name");
    userName.setFont(new Font("Serif", Font.PLAIN, 15));
    userName.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    JTextField userName1 = new JTextField("");
    JLabel passwordField = new JLabel("Password");
    passwordField.setFont(new Font("Serif", Font.PLAIN, 15));
    passwordField.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    JPasswordField passwordField1 = new JPasswordField();



    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,3));
    JButton submit = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");
    bottomPanel.add(submit);
    bottomPanel.add(resetButton);
    bottomPanel.add(showPassword);

 
    jp1.add(loginTitle);
    jp1.add(userName);
    jp1.add(userName1);
    jp1.add(passwordField);
    jp1.add(passwordField1);

    resetButton.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent f) {
            try {
                if (f.getSource() == resetButton) {
                    userName1.setText("");
                    passwordField1.setText("");
                }
        
            } catch (Exception e) {
            }
        }

    });

    showPassword.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == showPassword) {
                    if (showPassword.isSelected()) {
                        passwordField1.setEchoChar((char) 0);
                    } else {
                        passwordField1.setEchoChar('*');
                    }
         
         
                }
            } catch (Exception f) {
            }
            
        }
        
    });
    
    submit.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {


                String userNames = userName1.getText();
                String pwd = new String(passwordField1.getPassword());
                System.out.println(userNames);
                System.out.println(pwd);

                if (userNames.equals("user") && pwd.equals("12345")) {
                   JOptionPane.showMessageDialog(null, "Login Sucessful");
                        newFrame.dispose();
                        App test = new App();
                        test.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid name or Password");
                }
        }
 
    });
    newFrame.setLocationRelativeTo(null);
    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newFrame.add(jp1,BorderLayout.CENTER);
    newFrame.add(bottomPanel,BorderLayout.SOUTH);
    newFrame.setVisible(true);
    newFrame.setMinimumSize(new Dimension(370,250));
    newFrame.setSize(370,250);


}
public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
            }
            new Login();
        }
    });;

}
}
