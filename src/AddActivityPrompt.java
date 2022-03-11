import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.util.Properties;
import java.awt.event.*;

public class AddActivityPrompt extends JPanel {
    JTextField activityName = new JTextField(11);
    JTextField dueHour = new JTextField(11);
    JTextField activityDescription = new JTextField(11);
    JDatePickerImpl datePicker;
    JComboBox<String> hourList;
    public String x;

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

        String[] hours = new String[] {"1:00 am","2:00 am","3:00 am","4:00 am","5:00 am","6:00 am","7:00 am","8:00 am","9:00 am","10:00 am","11:00 am","12:00 am","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm","11:00 pm","12:00 pm"};
        JComboBox<String> hourList = new JComboBox<String>(hours);
        hourList.setSelectedIndex(-1);

        ActionListener dActvity = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae) {
              x = String.valueOf(hourList.getSelectedItem());
              System.out.print(x);

          }
      };
      hourList.addActionListener(dActvity);

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
        this.add(hourList);
        this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Description:"));
        this.add(activityDescription);
    }

    public JTextField getActivityName(){
		return activityName;
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
    return x;
		// return dueHour.getText();
	}

  public String getDescription() {
		return activityDescription.getText();
	}
    
}
