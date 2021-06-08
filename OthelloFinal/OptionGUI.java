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
   ArrayList<Player> data = new ArrayList<Player>();

   private GridBagConstraints gbc = new GridBagConstraints();

// constructor that initializes the panels
   public OptionGUI()
   {
      announcement = new AnnouncementGUI();
      launch = new LaunchGameGUI();
      player_data = new LoadFile();

      data = player_data.loadPlayer("player_data.txt");

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

// returns the announcementGUI
   public AnnouncementGUI getAnnouncementGUI()
   {
      return announcement;
   }

// sets a GameControl
   public void setControl(GameControl c)
   {
      launch.setControl(c);
   }

   public ArrayList<Player> getData()
   {
      return data;
   }
}
