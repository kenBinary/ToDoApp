import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.util.Properties;

public class AddActivityPrompt extends JPanel {
    JTextField activityName = new JTextField(11);
    JTextField dueDate = new JTextField(11);
    JTextField dueHour = new JTextField(11);
    JTextField activityDescription = new JTextField(11);
    JDatePickerImpl datePicker;

    AddActivityPrompt(){

        this.setLayout(new GridLayout(4,2));
        TextPrompt aPholder = new TextPrompt("Activity Name",activityName);
        aPholder.setForeground(Color.red);
        aPholder.changeAlpha(0.5f);


        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        TextPrompt datePholder = new TextPrompt("mm/dd/yyyy",dueDate);
        datePholder.setForeground(Color.red);
        datePholder.changeAlpha(0.5f);

        TextPrompt hourPholder = new TextPrompt("hh/mm/am or pm",dueHour);
        hourPholder.setForeground(Color.red);
        hourPholder.changeAlpha(0.5f);

        TextPrompt aDescription = new TextPrompt("Description",activityDescription);
        aDescription.setForeground(Color.red);
        aDescription.changeAlpha(0.5f);

        this.add(new JLabel("Activity Name:"));
        this.add(activityName);
        this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Due Date:"));
        this.add(datePicker);
        this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Due hour:"));
        this.add(dueHour);
        this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Description:"));
        this.add(activityDescription);
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
		return datePicker.getJFormattedTextField().getText();
	}
    public String getDueHourText() {
		return dueHour.getText();
	}

  public String getDescription() {
		return activityDescription.getText();
	}
    
}
