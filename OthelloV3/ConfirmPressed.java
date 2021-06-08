import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmPressed implements ActionListener
{
   private String[] p1 = new String[2];
   private String[] p2 = new String[2];
   private int boardsize;
   private GameSettingGUI setting;
   private GameControl control;

// constructor that initializes the strings and boardsize
   public ConfirmPressed()
   {
      p1[0] = "N/A";
      p2[0] = "N/A";
      boardsize = 8;

   }

// when confirm is pressed this is called
   public void actionPerformed(ActionEvent event)
   {
      String[] names = setting.getPlayerName();
      String[] color = setting.getPlayerColor();
      p1[0] = names[0];
      p1[1] = color[1];
      p2[0] = names[1];
      p2[1] = color[1];
      boardsize = setting.getBoardSize();

      Player[] players = this.getPlayer();
      
      if(!(names[0].equals("") || names[1].equals("")) && setting.confirmFlag())
      {      
         control.setPlayer(players);
         control.reset(boardsize);
         setting.closeWindow();
      }

   }

// sets the gameSettingGUI
   public void setGameSettingGUI(GameSettingGUI s)
   {
      this.setting = s;
   }

// returns the gameSettingGUI
   public GameSettingGUI getGameSettingGUI()
   {
      return this.setting;
   }

// returns a list of with the player names entered
   public Player[] getPlayer()
   {
      Player[] players = new Player[2];
      players[0] = new Player(p1[0], p1[1], 0, 0);
      players[1] = new Player(p2[0], p2[1], 0, 0);

      return players;
   }

// returns the boardsize
   public int getBoardSize()
   {
      return boardsize;
   }

// sets the control
   public void setControl(GameControl c)
   {
      control = c;
   }
}
