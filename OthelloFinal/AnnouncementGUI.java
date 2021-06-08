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
   JLabel player_names;

   private GridBagConstraints gbc = new GridBagConstraints();

// constructor that initializes the labels and adds them to the panel
   public AnnouncementGUI()
   {
      result = new JLabel("Valid: N/A");
      current_score = new JLabel("Blue: 2 vs Red: 2");
      current_player = new JLabel("Current Player is Blue");
      player_names = new JLabel("(Blue) vs (Red)");

      Dimension d = new Dimension(200, 80);
      result.setPreferredSize(d);
      current_score.setPreferredSize(d);
      current_player.setPreferredSize(d);

      setLayout(new GridBagLayout());
      gbc.insets = new Insets(10, 5, 5, 5);

      addGrid(0,0,result);
      addGrid(0,1,current_score);
      addGrid(0,2,current_player);
      addGrid(0,3,player_names);

      setPreferredSize(new Dimension(200, 200));
   }

// announces if button is valid and announces when a player wins
   public void announceWin(String announcement)
   {
      result.setText(announcement);
   }

// announces the score of the game
   public void announceScore(String announcement)
   {
      current_score.setText(announcement);
   }

// announces who the current player is
   public void announcePlayer(String announcement)
   {
      current_player.setText(announcement);
   }

// displays the names of the players playing the game
   public void announcePlayerName(String names)
   {
      player_names.setText(names);
   }

// adds the labels to the correct position
   public void addGrid(int x, int y, JLabel label)
   {
      gbc.gridx = x;
      gbc.gridy = y;
      add(label, gbc);
   }
}


