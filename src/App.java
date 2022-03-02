import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    App(){
        JFrame frame = new JFrame("To-do");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(0,10));

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(new Color(12, 14, 12));
        firstPanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(234, 235, 234) ));
        // firstPanel.setLayout(new GridLayout(1000,1,1,1));

        firstPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.ipady = 5;

        for (int i=0; i < 20; i++) {
            for (int j=0; j < 4; j++) {
                // JLabel bruh = new JLabel("laksdfj" + i + "," + j);
            //    JButton tes = new JButton("laksdjf" + i+"," + j);
               JPanel test  = new JPanel(new BorderLayout());
               test.setBackground(Color.blue);
               test.setBorder(BorderFactory.createLineBorder(Color.green));
               JTextArea label = new JTextArea("asdf\naskldjfsdf\naskldfj");
               label.setEditable(false);
               test.add(label,BorderLayout.CENTER);
            firstPanel.add(test,gbc);
            }
        }    


        JScrollPane scrollPane = new JScrollPane();



        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(new Color(12, 14, 12));


        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BorderLayout());
        thirdPanel.setBorder(BorderFactory.createMatteBorder(3, 0,3, 3, new Color(234, 235, 234)));
        thirdPanel.add(secondPanel,BorderLayout.CENTER);

        secondPanel.setSize(250, 250);
        secondPanel.setLayout(new GridLayout(10,1,0,25));
        secondPanel.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));

        JLabel listLabel = new JLabel("View list",SwingConstants.CENTER);
        listLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        String list[]={"Default List"};
        JComboBox<String> activityList = new JComboBox<String>(list);
        JButton createList = new JButton("Create List");
        JButton deleteList = new JButton("Delete List");
        JLabel Blank  = new JLabel("       ");
        JLabel blank1 = new JLabel("       ");
        JButton addActivity = new JButton("Add Activity");
        JButton deleteAllActivity = new JButton("Delete All");
        
        secondPanel.add(listLabel);
        secondPanel.add(activityList);
        secondPanel.add(createList);
        secondPanel.add(Blank);
        secondPanel.add(blank1);
        secondPanel.add(deleteList);
        secondPanel.add(addActivity);
        secondPanel.add(deleteAllActivity);
        scrollPane.setViewportView(firstPanel);
        frame.add(scrollPane,BorderLayout.CENTER);
        frame.setSize(500,500);
        frame.add(thirdPanel,BorderLayout.EAST);
        frame.setVisible(true);

        addActivity.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    JTextField activityName = new JTextField(11);
                    JTextField dueDate = new JTextField(11);
                    JTextField dueHour = new JTextField(11);
              
                    JPanel myPanel = new JPanel(new GridLayout(3,2));

                    myPanel.add(new JLabel("Activity Name:"));
                    TextPrompt aPholder = new TextPrompt("Activity Name",activityName);
                    aPholder.setForeground(Color.red);
                    aPholder.changeAlpha(0.5f);

                    TextPrompt datePholder = new TextPrompt("mm/dd/yyyy",dueDate);
                    datePholder.setForeground(Color.red);
                    datePholder.changeAlpha(0.5f);

                    TextPrompt hourPholder = new TextPrompt("hh/mm/am or pm",dueHour);
                    hourPholder.setForeground(Color.red);
                    hourPholder.changeAlpha(0.5f);

                    myPanel.add(activityName);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Due Date:"));
                    myPanel.add(dueDate);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Due hour:"));
                    myPanel.add(dueHour);
              
                    int result = JOptionPane.showConfirmDialog(frame, myPanel, 
                             "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            
            
                    if (result == JOptionPane.OK_OPTION) {
                       System.out.println("x value: " + activityName.getText());
                       System.out.println("y value: " + dueDate.getText());
                       System.out.println("y value: " + dueHour.getText());
                       Activity test = new Activity(activityName.getText(),dueDate.getText(),dueHour.getText());
                       System.out.println(test);
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
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
                new App();
            }
        });

    }
}
