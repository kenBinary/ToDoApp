import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import java.awt.event.*;


public class test {

    test(){
        JFrame bruh = new JFrame();
        JPanel test = new JPanel();


        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());


        String[] hours = new String[] {"1:00 am","2:00 am","3:00 am","4:00 am","5:00 am","6:00 am","7:00 am","8:00 am","9:00 am","10:00 am","11:00 am","12:00 am","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm","11:00 pm","12:00 pm"};
        JComboBox<String> hourList = new JComboBox<>(hours);
        test.add(hourList);

        JButton dd = new JButton();
        test.add(dd);
        test.add(datePicker);
        bruh.add(test);
        bruh.setVisible(true);
        bruh.setSize(500,500);


        ActionListener dActvity = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(datePicker.getJFormattedTextField().getText());
                System.out.print(String.valueOf(hourList.getSelectedItem()));

            }
        };
        dd.addActionListener(dActvity);

    }

    public static void main(String[] args) throws Exception {
        new test();
        // String[] bookTitles = new String[] {"1:00 am","2:00 am","3:00 am","4:00 am","5:00 am","6:00 am","7:00 am","8:00 am","9:00 am","10:00 am","11:00 am","12:00 am","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm","11:00 pm","12:00 pm"};
        for (int i = 1; i < 12+1; i++) {
            System.out.print(i+":00 pm,");
        }
    }
}
