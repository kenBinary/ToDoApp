import java.awt.*;
import javax.swing.*;

public class firstPanel extends JPanel {
    firstPanel(){
        this.setBackground(new Color(12, 14, 12));
        this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(234, 235, 234) ));
        this.setLayout(new GridBagLayout());
    }

    public void updateNumbers()
	{
		Component[] listItems = this.getComponents();
		
		for(int i = 0;i<listItems.length;i++)
		{
			if(listItems[i] instanceof ActivityPanel)
			{
				((ActivityPanel)listItems[i]).changeIndex(i+1);
			}
		}
		
	}
    public void removeCompletedTasks()
	{
		
		for(Component c : getComponents())
		{
			if(c instanceof ActivityPanel)
			{
				if(((ActivityPanel)c).getState())
				{
					remove(c);
					updateNumbers();
				}
			}
		}
		
	}
}
