import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.UIManager.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.LinkedList;


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

            }
        };
        dd.addActionListener(dActvity);

    }

    public static void main(String[] args) throws Exception {
        new test();
    }
}
