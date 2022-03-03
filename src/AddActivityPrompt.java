import javax.swing.*;

import java.awt.*;

public class AddActivityPrompt extends JPanel {
    JTextField activityName = new JTextField(11);
    JTextField dueDate = new JTextField(11);
    JTextField dueHour = new JTextField(11);

    AddActivityPrompt(){

        
        this.setLayout(new GridLayout(3,2));
        TextPrompt aPholder = new TextPrompt("Activity Name",activityName);
        aPholder.setForeground(Color.red);
        aPholder.changeAlpha(0.5f);

        
        TextPrompt datePholder = new TextPrompt("mm/dd/yyyy",dueDate);
        datePholder.setForeground(Color.red);
        datePholder.changeAlpha(0.5f);

        TextPrompt hourPholder = new TextPrompt("hh/mm/am or pm",dueHour);
        hourPholder.setForeground(Color.red);
        hourPholder.changeAlpha(0.5f);

        this.add(new JLabel("Activity Name:"));
        this.add(activityName);
        this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Due Date:"));
        this.add(dueDate);
        this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Due hour:"));
        this.add(dueHour);
    }

    public JTextField getActivityName(){
		return activityName;
	}
	public JTextField getDueDate() {
		return dueDate;
	}
    public JTextField getDueHour() {
		return dueHour;
	}

    public String getActivityNameText(){
		return activityName.getText();
	}
	public String getDueDateText() {
		return dueDate.getText();
	}
    public String getDueHourText() {
		return dueHour.getText();
	}
    
}
