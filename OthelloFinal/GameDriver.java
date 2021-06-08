import java.io.*;

// main driver

public class GameDriver
{
   private Player player1;
   private Player player2;
   private AnnouncementGUI announcement;
   private BoardGUI board;
   private GameGUI game;
   private GameSettingGUI gameSetting;

   public static void main(String[] args)
   {
      GameGUI game = new GameGUI();
      game.add_Board(new BoardGUI());
      game.add_Option(new OptionGUI());
      GameControl gameControl = new GameControl(game.getBoardGUI());
      game.getBoardGUI().addGameControl(gameControl);
      gameControl.useAnnouncements(game.option.getAnnouncementGUI());
      game.setControl(gameControl);
      gameControl.setData(game.getData());
   }
}
