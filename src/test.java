import javax.swing.*;
// import javax.swing.UIManager.*;

public class test {
    test(){


         

    }







    public static void main(String[] args) throws Exception {
        JTextField activityName = new JTextField(5);
        JTextField dueDate = new JTextField(5);
        JTextField dueHour = new JTextField(5);
  
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Activity Name:"));
        // TextPrompt t = new TextPrompt("asdf",activityName);
        // myPanel.add(t);
        myPanel.add(activityName);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Due Date:"));
        myPanel.add(dueDate);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Due hour:"));
        myPanel.add(dueHour);
  
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
                 "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);


        if (result == JOptionPane.OK_OPTION) {
           System.out.println("x value: " + activityName.getText());
           System.out.println("y value: " + dueDate.getText());
           System.out.println("y value: " + dueHour.getText());
           Activity test = new Activity("sadf","asdf","asdf");
           System.out.println(test);
        }
        
        





        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
        //         try {
        //             for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        //                 if ("Nimbus".equals(info.getName())) {
        //                     UIManager.setLookAndFeel(info.getClassName());
        //                     break;
        //                 }
        //             }
        //         } catch (Exception e) {
        //             // If Nimbus is not available, you can set the GUI to another look and feel.
        //         }
        //         new test();
        //     }
        // });

    }
}
