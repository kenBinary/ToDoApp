import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.*;

public class ActivityPanel extends JPanel {

    ActivityPanel(){
        JTextField activityName = new JTextField(11);
        JTextField dueDate = new JTextField(11);
        JTextField dueHour = new JTextField(11);
        this.setLayout(new GridLayout(3,2));
    }
    
}
