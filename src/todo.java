import java.awt.Color;

import javax.swing.JButton;
// import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
/**
 * todo
 */
public class todo {
    todo(){
        JFrame f = new JFrame("To do app");
        f.setSize(500,700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        // f.setResizable(false);
        f.setLayout(new BorderLayout());

        JLabel vlist = new JLabel("View List");
        // JComboBox<String> listv = new<String> JComboBox();
        JButton clist = new JButton("create list");
        JButton dlist = new JButton("Delete list");
        JButton add = new JButton("add");
        JButton delete = new JButton("Delete all");

        JPanel top = new JPanel();

        f.add(top);
        f.getContentPane().setBackground(Color.yellow);
        f.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));   
        
        top.setBorder(new LineBorder(Color.BLACK, 3));
        top.setBackground(Color.pink);
        top.setLayout(new GridLayout(14,1,10,10));
        top.add(vlist);
        // top.add(listv);
        top.add(clist);
        top.add(dlist);
        top.add(add);
        top.add(delete);
        f.add(top,BorderLayout.EAST);
        


      
        
        
    }
    public static void main(String[] args) {
       new todo();
    }
}