import java.util.ArrayList;
import java.io.*;

public class GameControl
{
   BoardGUI boardGUI;
   AnnouncementGUI announcement;
   Board board;
   int currentPlayerIndex;
   int max;
   ArrayList<Player> player_info = new ArrayList<Player>();
   ArrayList<Player> player_list = new ArrayList<Player>();
   ArrayList<Player> current_player = new ArrayList<Player>();

// default players
   public GameControl(BoardGUI b)
   {
      boardGUI = b;
      board = b.getBoard();
      currentPlayerIndex = 0;
      Player x = new Player("Blue", "w", 0, 0);
      Player y = new Player("Red", "b", 0, 0);
      player_list.add(x);
      player_list.add(y);
      max = 64;
      int size = boardGUI.getBoardSize();
   }

// after each piece is added to the board the board and boardGUI are updated
   public void update(int row, int col)
   {
      int c = currentPlayerIndex;
      currentPlayerIndex++;
      currentPlayerIndex = currentPlayerIndex % 2;
      board.addPiece(row, col, player_list.get(currentPlayerIndex).getGamePiece());
      if (board.getValid() == false)
      {
         announcement.announceWin("Valid Move: " + board.getValid());
         currentPlayerIndex = c;
      }
      else
      {
         checkWinner();
      }
      boardGUI.update();
   }

   public void useAnnouncements(AnnouncementGUI a)
   {
      announcement = a;
   }

// check for winner
   public void checkWinner()
   {
      String p1 = player_list.get(0).getName();
      String p2 = player_list.get(1).getName();

      int pieces = board.getBlackScore() + board.getWhiteScore();
      announcement.announceWin("Valid: " + board.getValid());

      if (pieces == max || board.getBlackScore() == 0 || board.getWhiteScore() == 0)
      {
         if (board.getWhiteScore() < board.getBlackScore())
         {
            announcement.announceWin("Result: " + p1 + " wins");
            if (current_player.get(0).getGamePiece().equals("b"))
            {
               current_player.get(0).set_black_won(current_player.get(0).getBlackWon() + 1);
            }
            else
            {
               current_player.get(1).set_black_won(current_player.get(1).getBlackWon() + 1);
            }
         }
         if (board.getWhiteScore() == board.getBlackScore())
         {
            announcement.announceWin("Result: It's a tie");
         }
         if (board.getWhiteScore() > board.getBlackScore())
         {
            announcement.announceWin("Result: " + p2 + " wins");
            if (current_player.get(0).getGamePiece().equals("w"))
            {
               current_player.get(0).set_white_won(current_player.get(0).getWhiteWon() + 1);
            }
            else
            {
               current_player.get(1).set_white_won(current_player.get(1).getWhiteWon() + 1);
            }

         }
         announcement.announcePlayer("Game Over");
      }
      else
      {
         if (currentPlayerIndex == 0)
         {
            announcement.announcePlayer("Current Player is " + p1);
         }
         else
         {
            announcement.announcePlayer("Current Player is " + p2);
         }
      }

      announcement.announceScore(p1 + ": " + board.getBlackScore() + " vs " + p2 + ": " + board.getWhiteScore());
   }

// set players in the announcePlayerName label
   public void setPlayer(Player[] players)
   {
      String name1 = players[0].getName() + "";
      String name2 = players[1].getName() + "";

      if (players[0].getGamePiece().equals("b"))
      {
         name1 += "(Blue)";
         name2 += "(Red)";
      }
      else
      {
         name1 += "(Red)";
         name2 += "(Blue)";
      }
      current_player.clear();
      current_player.add(players[0]);
      current_player.add(players[1]);

      announcement.announcePlayerName(name1 + " vs " + name2);
   }

// reset the bound for every new game
   public void reset(int size)
   {
      //after the confirm pressed, it should claer the board and reset the game
      currentPlayerIndex = 0;

      boardGUI.reset(size);
      boardGUI.addGameControl(this);
      board = boardGUI.getBoard();

      String p1 = current_player.get(0).getName();
      String p2 = current_player.get(1).getName();
      announcement.announceScore(p1 + ": " + board.getBlackScore() + " vs " + p2 + ": " + board.getWhiteScore());
      announcement.announceWin("Valid: " + "N/A");
      announcement.announcePlayer("Current Player is Blue");
      int x = boardGUI.getBoardSize();
      if (x == 8)
      {
         max = 64;
      }
      else
      {
         max = 36;
      }
   }

// pass turn over to the other player when pressed
   public void passTurn()
   {
      currentPlayerIndex++;
      currentPlayerIndex = currentPlayerIndex % 2;
      String p1 = player_list.get(0).getName();
      String p2 = player_list.get(1).getName();
      if (currentPlayerIndex == 0)
      {
         announcement.announcePlayer("Current Player is " + p1);
      }
      else
      {
         announcement.announcePlayer("Current Player is " + p2);
      }
   }

// save method
   public void save()
   {
      int flag1 = 0;
      int flag2 = 0;
      System.out.println("Saving State");
      try
      {
         String name1 = current_player.get(0).getName();
         String name2 = current_player.get(1).getName();
         File f = new File("player_data.txt");
         for (int i = 0; i < player_info.size(); i++)
         {
            if (player_info.get(i).getName().equals(name1))
            {
               player_info.get(i).set_white_won(current_player.get(0).getWhiteWon() + player_info.get(i).getWhiteWon());
               player_info.get(i).set_black_won(current_player.get(0).getBlackWon() + player_info.get(i).getBlackWon());
               flag1 = 1;
               FileWriter fstream2 = new FileWriter("player_data.txt");
               BufferedWriter writer2 = new BufferedWriter(fstream2);
               for (int j = 0; j < player_info.size(); j++)
               {
                  writer2.write(player_info.get(j).get_info());
               }
               writer2.close();
            }
            if (player_info.get(i).getName().equals(name2))
            {
               player_info.get(i).set_white_won(current_player.get(1).getWhiteWon() + player_info.get(i).getWhiteWon());
               player_info.get(i).set_black_won(current_player.get(1).getBlackWon() + player_info.get(i).getBlackWon());
               flag2 = 1;
               FileWriter fstream3 = new FileWriter("player_data.txt");
               BufferedWriter writer3 = new BufferedWriter(fstream3);
               for (int x = 0; x < player_info.size(); x++)
               {
                  writer3.write(player_info.get(x).get_info());
               }
               writer3.close();
            }
         }
         FileWriter fstream = new FileWriter("player_data.txt", true);
         BufferedWriter writer = new BufferedWriter(fstream);
         if (flag1 == 0)
         {
            writer.write(current_player.get(0).get_info());
         }
         if (flag2 == 0)
         {
            writer.write(current_player.get(1).get_info());
         }
      writer.close();
      }
      catch (IOException ex)
      {
         System.out.println("IOException is caught");
      }
   }

// get loaded player array
   public void setData(ArrayList<Player> a)
   {
      player_info = a;
   }
}
