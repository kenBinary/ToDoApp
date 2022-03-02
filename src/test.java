import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class test {
    test(){

        JFrame frame = new JFrame();
        JPanel secondPanel = new JPanel();
        JButton test = new JButton("asdfasfdsa");
        secondPanel.add(test);
        frame.add(secondPanel,BorderLayout.EAST);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(50,1,10,10));
        for (int i=0; i < 10; i++) {
            for (int j=0; j < 4; j++) {

               JButton tes = new JButton("laksdjf" + i+"," + j);
            //    JLabel label = new JLabel("label " + i + ", " + j);
            //    label.setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(tes);
            }
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(panel);
        frame.add(scroll,BorderLayout.CENTER);




        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
