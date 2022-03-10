import java.awt.*;
import javax.swing.*;

public class secondPanel extends JPanel {
    JButton deleteActivity;
    JButton addActivity;
    JButton deleteAllActivity;

    secondPanel(){
        this.setBackground(new Color(12, 14, 12));
        this.setLayout(new GridLayout(10,1,0,25));
        // this.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
        this.setBorder(BorderFactory.createLineBorder(Color.white, 3, true));
        JLabel listLabel = new JLabel("View list",SwingConstants.CENTER);
        listLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        JLabel Blank  = new JLabel("       ");
        JLabel blank1 = new JLabel("       ");
        JLabel blank3 = new JLabel("Options List",SwingConstants.CENTER);
        deleteActivity = new JButton("Delete Activity");
        addActivity = new JButton("Add Activity");
        deleteAllActivity = new JButton("Delete All");
        blank3.setForeground(Color.white);
        blank3.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(blank3);
        this.add(Blank);
        this.add(blank1);
        this.add(deleteActivity);
        this.add(addActivity);
        this.add(deleteAllActivity);
    }
    public JButton getDeleteActivity(){
		return deleteActivity;
	}
	public JButton getAddActivity() {
		return addActivity;
	}
    public JButton getDeleteAll() {
		return deleteAllActivity;
	}
}
