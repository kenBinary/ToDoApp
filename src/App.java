import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;

public class App {

    App(){
        JFrame frame = new JFrame("To-do");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(0,10));

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(new Color(12, 14, 12));
        firstPanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(234, 235, 234) ));
        firstPanel.setLayout(new GridLayout(1000,1,1,1));

        for (int i=0; i < 20; i++) {
            for (int j=0; j < 4; j++) {

               JButton tes = new JButton("laksdjf" + i+"," + j);
            //    JLabel label = new JLabel("label " + i + ", " + j);
            //    label.setFont(new Font("Arial", Font.PLAIN, 20));
            firstPanel.add(tes);
            }
        }    
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(firstPanel);
        frame.add(scrollPane,BorderLayout.CENTER);


        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(new Color(12, 14, 12));


        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BorderLayout());
        thirdPanel.setBorder(BorderFactory.createMatteBorder(3, 0,3, 3, new Color(234, 235, 234)));
        thirdPanel.add(secondPanel,BorderLayout.CENTER);

        secondPanel.setSize(250, 250);
        secondPanel.setLayout(new GridLayout(10,1,0,25));
        secondPanel.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));

        JLabel listLabel = new JLabel("View list",SwingConstants.CENTER);
        listLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        String list[]={"Default List"};
        JComboBox<String> activityList = new JComboBox<String>(list);
        JButton createList = new JButton("Create List");
        JButton deleteList = new JButton("Delete List");
        JLabel Blank  = new JLabel("       ");
        JLabel blank1 = new JLabel("       ");
        JButton addActivity = new JButton("Add Activity");
        JButton deleteAllActivity = new JButton("Delete All");
        
        secondPanel.add(listLabel);
        secondPanel.add(activityList);
        secondPanel.add(createList);
        secondPanel.add(Blank);
        secondPanel.add(blank1);
        secondPanel.add(deleteList);
        secondPanel.add(addActivity);
        secondPanel.add(deleteAllActivity);
        
        frame.setSize(500,500);
        frame.add(thirdPanel,BorderLayout.EAST);
        frame.setVisible(true);
}

    public static void main(String[] args) throws Exception {
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
                new App();
            }
        });

    }
}
