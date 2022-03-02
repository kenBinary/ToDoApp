import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.*;



public class Layout {
Layout(){

    JFrame frame = new JFrame("To Do");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    JPanel firstPanel = new JPanel();
    JPanel p = new JPanel();

    frame.add(firstPanel,BorderLayout.CENTER);
    frame.add(p,BorderLayout.EAST);

    p.setLayout(new GridLayout(10, 1,100,10));
    p.setSize(100,100);       
    p.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
    // p.setBorder(BorderFactory.createLineBorder(Color.black,50));



    JLabel ViewL = new JLabel("View List");
    String month[]={"List", "List1", "List2"};
    JComboBox<String> cb = new JComboBox<String>(month);
    JButton CrtList = new JButton("Create List");
    JButton DltList = new JButton("Delete List");
    JLabel Blank  = new JLabel("       ");
    JLabel blank1 = new JLabel("       ");
    JButton Add = new JButton("Add Activity");
    JButton DAll = new JButton("Delete All");

    p.add(ViewL);
    p.add(cb);
    p.add(CrtList);
    p.add(DltList);
    p.add(Blank);
    p.add(blank1);
    p.add(Add);
    p.add(DAll); 
    frame.setSize(500, 500);
    frame.setVisible(true);
    firstPanel.add(new JScrollPane(new JTextArea(30, 30)), BorderLayout.AFTER_LINE_ENDS);

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
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
                new Layout();
            }
        });
    }

}
