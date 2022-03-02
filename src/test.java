import javax.swing.*;
import javax.swing.UIManager.*;

public class test {
    private JFrame frame = new JFrame("Test");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("CenteredJLabel");
    test(){

          panel.add(label);
          panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
          frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          frame.add(panel);
          frame.setSize(400, 300);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
    }







    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        
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
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
                new test();
            }
        });

    }
}
