import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

// ActionListener probably should be implemented somewhere else
// But for demonstration I temporily implement here.
public class LaunchGameGUI extends JPanel
{
   JButton start;
   JButton save;
   private GameSettingGUI setting;
   private GridBagConstraints gbc = new GridBagConstraints();
   private ConfirmPressed confirm;
   private GameControl control;

   public LaunchGameGUI()
   {
      confirm = new ConfirmPressed();
      // System.out.println(confirm.getPlayer()[0].getName());
      start = new JButton("New Game");
      save = new JButton("Save Game");

      start.setPreferredSize(new Dimension(100, 100));
      save.setPreferredSize(new Dimension(100, 100));

      setLayout(new GridBagLayout());

      gbc.gridx = 0;
      gbc.gridy = 0;
      add(start, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      add(save, gbc);

      setPreferredSize(new Dimension(130, 90));

      start.addActionListener(new ActionListener()
      {
            public void actionPerformed(ActionEvent event)
            {
               setting = new GameSettingGUI(confirm);
               // additional part
               confirm.setGameSettingGUI(setting);
              // additional part
               if(control != null)
                  System.out.println("Control is not null in LaunchGameGUI");
               confirm.setControl(control);
               System.out.println("Sent control");
               
            }
      }
      );
   }
   
   public void setControl(GameControl c)
   {
      control = c;
   }
   
   
}

