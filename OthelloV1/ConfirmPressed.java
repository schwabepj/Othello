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

   public ConfirmPressed()
   {
      p1[0] = "N/A";
      p2[0] = "N/A";
      boardsize = 8;

   }

   public void actionPerformed(ActionEvent event)
   {
      String[] names = setting.getPlayerName();
      String[] color = setting.getPlayerColor();
      // testing whether the data in the GameSettingGUI is received
      p1[0] = names[0];
      p1[1] = color[1];
      p2[0] = names[1];
      p2[1] = color[1];
      boardsize = setting.getBoardSize();
      
      // additional part
      Player[] players = this.getPlayer();
      if(control != null)
         System.out.println("Control is not null in ConfirmPressed"); 
      control.setPlayer(players);
      control.reset(boardsize);
      setting.closeWindow();

   }

   public void setGameSettingGUI(GameSettingGUI s)
   {
      this.setting = s;
   }

   public GameSettingGUI getGameSettingGUI()
   {
      return this.setting;
   }

   public Player[] getPlayer()
   {
      Player[] players = new Player[2];
      players[0] = new Player(p1[0], p1[1], 0, 0);
      players[1] = new Player(p2[0], p2[1], 0, 0);

      return players;
   }

   public int getBoardSize()
   {
      return boardsize;
   }
   
   public void setControl(GameControl c)
   {
      control = c;
   }
}


