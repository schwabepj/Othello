import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class LaunchGameGUI extends JPanel
{
   JButton start;
   JButton save;
   JButton pass;
   private GameSettingGUI setting;
   private GridBagConstraints gbc = new GridBagConstraints();
   private ConfirmPressed confirm;
   private GameControl control;

// constructor
   public LaunchGameGUI()
   {
      confirm = new ConfirmPressed();

      start = new JButton("New Game");
      save = new JButton("Save Game");
      pass = new JButton("Pass Turn");

      start.setPreferredSize(new Dimension(100, 100));
      save.setPreferredSize(new Dimension(100, 100));
      pass.setPreferredSize(new Dimension(100, 100));

      setLayout(new GridBagLayout());

      gbc.gridx = 0;
      gbc.gridy = 0;
      add(start, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      add(save, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      add(pass, gbc);

      setPreferredSize(new Dimension(130, 90));

      start.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            setting = new GameSettingGUI(confirm);
            // additional part
            confirm.setGameSettingGUI(setting);
            // additional part
            confirm.setControl(control);
         }
      }
      );

      pass.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            control.passTurn();
         }
      }
      );

      save.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            control.save();
         }
      }
      );

   }

   public void setControl(GameControl c)
   {
      control = c;
   }
}
