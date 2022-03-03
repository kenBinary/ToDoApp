import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.*;

public class App {
    
    JButton deleteActivity;
    JButton addActivity;
    JButton deleteAllActivity;

    App() {

        JFrame frame = new JFrame("To-do");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(0,10));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.ipady = 5;


        firstPanel fPanel = new firstPanel();
        JScrollPane scrollPane = new JScrollPane();
        thirdPanel tPanel = new thirdPanel();
        secondPanel sPanel = new secondPanel();
        tPanel.add(sPanel,BorderLayout.CENTER);
        scrollPane.setViewportView(fPanel);
        frame.add(scrollPane,BorderLayout.CENTER);
        frame.setSize(500,500);
        frame.add(tPanel,BorderLayout.EAST);
        frame.setVisible(true);

        deleteAllActivity = sPanel.getDeleteAll();
        addActivity = sPanel.getAddActivity();
        deleteActivity = sPanel.getDeleteActivity();




        //event listener to remove all components and activities
        deleteAllActivity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fPanel.removeAll();
                fPanel.revalidate();
                fPanel.repaint();
            }
        });

        ActionListener dActvity = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Component[] component = fPanel.getComponents();
                fPanel.remove(component[0]);
                fPanel.repaint();
                fPanel.revalidate();
            }
        };

        deleteActivity.addActionListener(dActvity);

        // event listener to add new activity
        addActivity.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {


                    // JTextField activityName = new JTextField(11);
                    // JTextField dueDate = new JTextField(11);
                    // JTextField dueHour = new JTextField(11);
              
                    // JPanel myPanel = new JPanel(new GridLayout(3,2));

                    
                    // TextPrompt aPholder = new TextPrompt("Activity Name",activityName);
                    // aPholder.setForeground(Color.red);
                    // aPholder.changeAlpha(0.5f);

                    // TextPrompt datePholder = new TextPrompt("mm/dd/yyyy",dueDate);
                    // datePholder.setForeground(Color.red);
                    // datePholder.changeAlpha(0.5f);

                    // TextPrompt hourPholder = new TextPrompt("hh/mm/am or pm",dueHour);
                    // hourPholder.setForeground(Color.red);
                    // hourPholder.changeAlpha(0.5f);

                    // myPanel.add(activityName);
                    // myPanel.add(Box.createHorizontalStrut(15));
                    // myPanel.add(new JLabel("Due Date:"));
                    // myPanel.add(dueDate);
                    // myPanel.add(Box.createHorizontalStrut(15));
                    // myPanel.add(new JLabel("Due hour:"));
                    // myPanel.add(dueHour);


                    AddActivityPrompt myPanel = new AddActivityPrompt();
              
                    int result = JOptionPane.showConfirmDialog(frame, myPanel, 
                             "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
                    System.out.println(result);
                    if (myPanel.getActivityNameText().equals("") && myPanel.getDueDateText().equals("") && myPanel.getDueHourText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "Enter some input!");
                        
                    }
                    else if (!myPanel.getActivityNameText().equals("") || !myPanel.getDueDateText().equals("") || !myPanel.getDueHourText().equals("")) {
                       JPanel pan  = new JPanel(new BorderLayout());
                       pan.setBackground(Color.blue);
                       pan.setBorder(BorderFactory.createLineBorder(Color.green));
                       Activity test = new Activity(myPanel.getActivityNameText(),myPanel.getDueDateText(),myPanel.getDueHourText());
                       System.out.println(test);
                       JTextArea label = new JTextArea(myPanel.getActivityNameText()+"\n"+myPanel.getDueDateText()+"\n"+myPanel.getDueHourText());
                       label.setEditable(false);
                       pan.add(label,BorderLayout.CENTER);
                       fPanel.add(pan,gbc);
                       fPanel.repaint();
                       fPanel.revalidate();
                    }
                }

            });


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
                }
                new App();
            }
        });

    }

    



}
