import javax.swing.*;
import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AnnouncementGUI extends JPanel
{
   JLabel result;
   JLabel current_score;
   JLabel current_player;
   // additional part
   JLabel player_names;

   private GridBagConstraints gbc = new GridBagConstraints();

   public AnnouncementGUI()
   {
      result = new JLabel("Valid: N/A");
      current_score = new JLabel("Blue: 2 vs Red: 2");
      current_player = new JLabel("Current Player is Blue");
      player_names = new JLabel("N/A   vs   N/A"); 

      Dimension d = new Dimension(200, 80);
      result.setPreferredSize(d);
      current_score.setPreferredSize(d);
      current_player.setPreferredSize(d);

      setLayout(new GridBagLayout());
      gbc.insets = new Insets(10, 5, 5, 5);
      gbc.gridx = 0;
      gbc.gridy = 0;
      add(result, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      add(current_score, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      add(current_player, gbc);

      //additonal part
      gbc.gridx = 0;
      gbc.gridy = 3;
      add(player_names, gbc);


      setPreferredSize(new Dimension(200, 200));
   }

   public void announceWin(String announcement)
   {
      result.setText(announcement);
   }

   public void announceScore(String announcement)
   {
      current_score.setText(announcement);
   }

   public void announcePlayer(String announcement)
   {
      current_player.setText(announcement);
   }

   // additonal part
   public void announcePlayerName(String names)
   {
      player_names.setText(names);
   }

}
