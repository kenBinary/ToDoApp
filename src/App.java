import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.LinkedList;

public class App extends JFrame {
    
    JButton deleteActivity;
    JButton addActivity;
    JButton deleteAllActivity;

    

    App() {


        JFrame frame = new JFrame("To-do Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(0,10));

        FileHandler fHandler = new FileHandler();



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.ipady = 5;

        JTextArea welcome = new JTextArea("Welcome! \n to add an activity press 'Add Activity'\n to delete finished activities press 'Delete Activities' \n to delete all activities press 'Delete All' \n GREEN MEANS DONE AND YELLOW MEANS PENDING ");
        welcome.setEditable(false);
        welcome.setFont(new Font("Serif", Font.PLAIN, 13));
        firstPanel fPanel = new firstPanel();
        frame.add(welcome,BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane();
        thirdPanel tPanel = new thirdPanel();
        secondPanel sPanel = new secondPanel();
        tPanel.add(sPanel,BorderLayout.CENTER);
        scrollPane.setViewportView(fPanel);


        frame.add(scrollPane,BorderLayout.CENTER);
        frame.setMinimumSize(new Dimension(700,700));
        frame.setSize(700,700);
        frame.add(tPanel,BorderLayout.WEST);
        frame.setVisible(true);

        deleteAllActivity = sPanel.getDeleteAll();
        addActivity = sPanel.getAddActivity();
        deleteActivity = sPanel.getDeleteActivity();


        LinkedList<Activity> activities = fHandler.readFile();



        for (Activity activity : activities) {
            ActivityPanel aPanel = new ActivityPanel();
            aPanel.setActivityDetails(activity.getActivityName(),activity.getDueDate(),activity.getDueHour());
            fPanel.add(aPanel,gbc);
            fPanel.updateNumbers();


            aPanel.getFinished().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    activities.remove(aPanel.getActivityIndex());
                    File myObj = new File("Activities.csv"); 
                    try {
                        myObj.delete();
                        System.out.println("Deleted the file: " + myObj.getName());
                    } catch (Exception z) {
                        System.out.print(z);
                      System.out.println("Failed to delete the file.");
                    }
                    for (Activity activity : activities) {
                        fHandler.appendFile(activity.toString());
                        System.out.print(activity.toString()); 
                    }

                    fPanel.updateNumbers();
                    aPanel.changeState();
                    fPanel.revalidate();
                }
            });

            aPanel.getEdit().addMouseListener( new MouseAdapter(){
                public void mousePressed(MouseEvent e){

                    AddActivityPrompt myPanel = new AddActivityPrompt();
                    int result = JOptionPane.showConfirmDialog(frame, myPanel, 
                    "Enter Inputs", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
                    
                    if (result == JOptionPane.OK_OPTION) {
                        if (myPanel.getActivityNameText().equals("") && myPanel.getDueDateText().equals("") && myPanel.getDueHourText().equals("")) {
                            JOptionPane.showMessageDialog(frame, "Enter some input!");
                        }
                        else if(!myPanel.getActivityNameText().equals("") || !myPanel.getDueDateText().equals("") || !myPanel.getDueHourText().equals("")){
                            Activity nActivity = new Activity(myPanel.getActivityNameText(), myPanel.getDueDateText(), myPanel.getDueHourText());
                            fHandler.appendFile(nActivity.toString());
                            aPanel.setActivityDetails(nActivity.getActivityName(),nActivity.getDueDate(),nActivity.getDueHour());
                        }
                    }
                }
        });
        }

        fPanel.repaint();
        fPanel.revalidate();




        //event listener to remove all components and activities
        deleteAllActivity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fPanel.updateNumbers();
                fPanel.removeAll();
                fPanel.revalidate();
                fPanel.repaint();
                File myObj = new File("Activities.csv"); 
                try {
                    myObj.delete();
                    System.out.println("Deleted the file: " + myObj.getName());
                } catch (Exception z) {
                    System.out.print(z);
                  System.out.println("Failed to delete the file.");
                }

;
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
                    ActivityPanel aPanel;



                    AddActivityPrompt myPanel = new AddActivityPrompt();
                    int result = JOptionPane.showConfirmDialog(frame, myPanel, 
                             "Enter inputs", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {


                        if (myPanel.getActivityNameText().equals("") || myPanel.getDueDateText().equals("") || myPanel.getDueHourText().equals("")) {
                            JOptionPane.showMessageDialog(frame, "Enter some input!");
                        }

                        else if(!myPanel.getActivityNameText().equals("") && !myPanel.getDueDateText().equals("") && !myPanel.getDueHourText().equals("") && !myPanel.getDescription().equals("")){
                            DescriptionActivity dActivity = new DescriptionActivity(myPanel.getActivityNameText(), myPanel.getDueDateText(), myPanel.getDueHourText(), myPanel.getDescription());
                            activities.add(dActivity);
                            fHandler.appendFile(dActivity.toString());
                            aPanel = new ActivityPanel();
                            aPanel.setActivityDetails(dActivity.getActivityName(), dActivity.getDueDate(), dActivity.getDueHour(), dActivity.getDescription());
                            fPanel.add(aPanel,gbc);
                            fPanel.updateNumbers();
                            aPanel.getFinished().addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {

                                    activities.remove(aPanel.getActivityIndex());
                                    File myObj = new File("Activities.csv"); 
                                    try {
                                        myObj.delete();
                                        System.out.println("Deleted the file: " + myObj.getName());
                                    } catch (Exception z) {
                                        System.out.print(z);
                                      System.out.println("Failed to delete the file.");
                                    }
                                    for (Activity activity : activities) {
                                        fHandler.appendFile(activity.toString());
                                        System.out.print(activity.toString()); 
                                    }
                                    
                                    aPanel.changeState();
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
                                                DescriptionActivity dActivity = new DescriptionActivity(myPanel.getActivityNameText(), myPanel.getDueDateText(), myPanel.getDueHourText(), myPanel.getDescription());
                                                fHandler.appendFile(dActivity.toString());
                                                aPanel.setActivityDetails(dActivity.getActivityName(),dActivity.getDueDate(),dActivity.getDueHour(),dActivity.getDescription());
                                            }
                                        }
                                    }
                            });



                        }
                        else if((!myPanel.getActivityNameText().equals("") || !myPanel.getDueDateText().equals("") || !myPanel.getDueHourText().equals(""))){

                            Activity nActivity = new Activity(myPanel.getActivityNameText(), myPanel.getDueDateText(), myPanel.getDueHourText());
                            activities.add(nActivity);


                            fHandler.appendFile(nActivity.toString());
                            aPanel = new ActivityPanel();
                            aPanel.setActivityDetails(nActivity.getActivityName(),nActivity.getDueDate(),nActivity.getDueHour());
                            fPanel.add(aPanel,gbc);
                            fPanel.updateNumbers();

                            aPanel.getFinished().addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {

                                    activities.remove(aPanel.getActivityIndex());
                                    File myObj = new File("Activities.csv"); 
                                    try {
                                        myObj.delete();
                                        System.out.println("Deleted the file: " + myObj.getName());
                                    } catch (Exception z) {
                                        System.out.print(z);
                                      System.out.println("Failed to delete the file.");
                                    }
                                    for (Activity activity : activities) {
                                        fHandler.appendFile(activity.toString());
                                        System.out.print(activity.toString()); 
                                    }

                                    aPanel.changeState();
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
                                                Activity nActivity = new Activity(myPanel.getActivityNameText(), myPanel.getDueDateText(), myPanel.getDueHourText());
                                                fHandler.appendFile(nActivity.toString());
                                                aPanel.setActivityDetails(nActivity.getActivityName(),nActivity.getDueDate(),nActivity.getDueHour());
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
