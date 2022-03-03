import java.awt.*;
import javax.swing.*;

public class secondPanel extends JPanel {
    secondPanel(){
        this.setBackground(new Color(12, 14, 12));
        this.setSize(250, 250);
        this.setLayout(new GridLayout(10,1,0,25));
        this.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
        // JLabel listLabel = new JLabel("View list",SwingConstants.CENTER);
        // listLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        // JButton deleteActivity = new JButton("Delete Activity");
        // JLabel Blank  = new JLabel("       ");
        // JLabel blank1 = new JLabel("       ");
        // JLabel blank2 = new JLabel("       ");
        // JButton addActivity = new JButton("Add Activity");
        // JButton deleteAllActivity = new JButton("Delete All");

        // this.add(Blank);
        // this.add(blank1);
        // this.add(blank2);
        // this.add(deleteActivity);
        // this.add(addActivity);
        // this.add(deleteAllActivity);
    }
}
