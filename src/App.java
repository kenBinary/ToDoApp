import javax.swing.*;
import javax.swing.UIManager.*;


import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

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

                fPanel.removeCompletedTasks();
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

                    AddActivityPrompt myPanel = new AddActivityPrompt();
              
                    int result = JOptionPane.showConfirmDialog(frame, myPanel, 
                             "Enter inputs", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        if (myPanel.getActivityNameText().equals("") && myPanel.getDueDateText().equals("") && myPanel.getDueHourText().equals("")) {
                            JOptionPane.showMessageDialog(frame, "Enter some input!");
                        }
                        else if (!myPanel.getActivityNameText().equals("") || !myPanel.getDueDateText().equals("") || !myPanel.getDueHourText().equals("")) {

                            Activity nActivity = new Activity(myPanel.getActivityNameText(), myPanel.getDueDateText(), myPanel.getDueHourText());
                            System.out.print(nActivity.toString());
                            ActivityPanel aPanel = new ActivityPanel();
                            aPanel.setActivityDetails(myPanel.getActivityNameText(),myPanel.getDueDateText(),myPanel.getDueHourText());
                            fPanel.add(aPanel,gbc);
                            fPanel.updateNumbers();

                            aPanel.getFinished().addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {
                                    aPanel.changeState();
                                    fPanel.updateNumbers();
                                    fPanel.revalidate();
                                }
                            });
                            aPanel.getEdit().addMouseListener( new MouseAdapter(){
                                    public void mousePressed(MouseEvent e){
                                        int result = JOptionPane.showConfirmDialog(frame, myPanel, 
                                        "Enter Inputs", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
                                        if (result == JOptionPane.OK_OPTION) {
                                            if (myPanel.getActivityNameText().equals("") && myPanel.getDueDateText().equals("") && myPanel.getDueHourText().equals("")) {
                                                JOptionPane.showMessageDialog(frame, "Enter some input!");
                                            }
                                            else if(!myPanel.getActivityNameText().equals("") || !myPanel.getDueDateText().equals("") || !myPanel.getDueHourText().equals("")){
                                                aPanel.setActivityDetails(myPanel.getActivityNameText(),myPanel.getDueDateText(),myPanel.getDueHourText());
                                            }
                                        }
                                    }
                            });
                        }
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
