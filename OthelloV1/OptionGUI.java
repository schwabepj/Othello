import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class OptionGUI extends JPanel
{
   AnnouncementGUI announcement;
   LaunchGameGUI launch;
   RankGUI rank_and_info;
   LoadFile player_data;

   private GridBagConstraints gbc = new GridBagConstraints();

   public OptionGUI()
   {
      announcement = new AnnouncementGUI();
      launch = new LaunchGameGUI();
      player_data = new LoadFile();

      ArrayList<Player> data = player_data.loadPlayer("player_data.txt");

      // for(int i = 0; i < data.size(); i++)
      // {
      //    System.out.println(data.get(i).getName());
      // }

      RankGUI rank_and_info = new RankGUI(data);

      setLayout(new GridBagLayout());

      gbc.gridx = 0;
      gbc.gridy = 0;
      add(announcement, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      add(launch, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      add(rank_and_info, gbc);

      setPreferredSize(new Dimension(120, 320));
   }

   public AnnouncementGUI getAnnouncementGUI()
   {
      return announcement;
   }
   
   public void setControl(GameControl c)
   {
      launch.setControl(c);
   }
}
