import javax.swing.*;

import java.awt.*;



public class ActivityPanel extends JPanel {
    JLabel activityIndex;
	JTextField activityName;
	JButton finished;
	
	private boolean isFinished;
    ActivityPanel(){
        this.setBackground(Color.blue);
        this.setBorder(BorderFactory.createLineBorder(Color.green));
        this.setLayout(new BorderLayout());
        isFinished = false;

        activityIndex = new JLabel();
		activityIndex.setHorizontalAlignment(JLabel.CENTER);
		this.add(activityIndex,BorderLayout.WEST);

        activityName = new JTextField("TEST");
		activityName.setBorder(BorderFactory.createEmptyBorder());
		activityName.setBackground(Color.red);
        this.add(activityName,BorderLayout.CENTER);

        finished = new JButton("finished");
		finished.setPreferredSize(new Dimension(40,20));
		finished.setBorder(BorderFactory.createEmptyBorder());
		finished.setFocusPainted(false);
		this.add(finished,BorderLayout.EAST);

    }

    public void changeIndex(int num)
	{
		this.activityIndex.setText(String.valueOf(num));
		this.revalidate();
	}
	
	
	public JButton getFinished()
	{
		return finished;
	}
	
	public boolean getState()
	{
		return isFinished;
	}
	
	public void changeState()
	{
		this.setBackground(Color.green);
		this.setBorder(BorderFactory.createLineBorder(Color.blue));
		activityName.setBackground(Color.green);
		isFinished = true;
		revalidate();
	}
}
