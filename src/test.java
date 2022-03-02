import javax.swing.*;
import javax.swing.UIManager.*;

public class test {
    test(){


         

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
