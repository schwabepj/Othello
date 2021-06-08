import java.util.ArrayList;
public class GameControl
{
   BoardGUI boardGUI;
   AnnouncementGUI announcement;
   Board board;
   int currentPlayerIndex;
   int max;
   ArrayList<Player> player_list = new ArrayList<Player>();
   ArrayList<Player> current_player = new ArrayList<Player>();

//default players
   public GameControl(BoardGUI b)
   {
      boardGUI = b;
      board = b.getBoard();
      currentPlayerIndex = 0;
      Player x = new Player("Blue","w",0,0);
      Player y = new Player("Red","b",0,0);
      player_list.add(x);
      player_list.add(y);
      max = 64;
      int size = boardGUI.getBoardSize();
   }

//after each piece is added to the board the board and boardGUI are updated
   public void update(int row, int col)
   {
      int c = currentPlayerIndex;
      currentPlayerIndex++;
      currentPlayerIndex = currentPlayerIndex % 2;
      board.addpiece(row, col, player_list.get(currentPlayerIndex).getGamePiece());
      if(board.getValid() == false)
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

   public void checkWinner()
   {
      String p1 = player_list.get(0).getName();
      String p2 = player_list.get(1).getName();


      int pieces = board.getBlackScore() + board.getWhiteScore();
      announcement.announceWin("Valid: " + board.getValid());

      if(pieces == max || board.getBlackScore() == 0 || board.getWhiteScore() == 0)
      {
         if(board.getWhiteScore() < board.getBlackScore())
         {
            announcement.announceWin("Result: " + p1 + " wins");
            if(current_player.get(0).getGamePiece().equals("w"))
            {
               current_player.get(0).set_white_won(current_player.get(0).getWhiteWon() + 1);
            }
            else
            {
               current_player.get(0).set_black_won(current_player.get(0).getBlackWon() + 1);
            }

         }
         if(board.getWhiteScore() == board.getBlackScore())
         {
            announcement.announceWin("Result: It's a tie");
         }
         if(board.getWhiteScore() > board.getBlackScore())
         {
            announcement.announceWin("Result: " + p2 + " wins");
            if(current_player.get(1).getGamePiece().equals("w"))
            {
               current_player.get(1).set_white_won(current_player.get(1).getWhiteWon() + 1);
            }
            else
            {
               current_player.get(1).set_black_won(current_player.get(1).getBlackWon() + 1);
            }

         }
         announcement.announcePlayer("Game Over");
      }
      else
      {
         if(currentPlayerIndex == 0)
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
      String name1 = players[0].getName() +"";
      String name2 = players[1].getName() +"";

      if(players[0].getGamePiece().equals("b"))
      {
         name1 += "(Blue)";
         name2 += "(Red)";
      }
      else
      {
         name1 += "(Red)";
         name2 += "(Blue)";
      }
      current_player.add(players[0]);
		current_player.add(players[1]);

      announcement.announcePlayerName(name1 + " vs " + name2);
   }

   // reset the board for every new game
   public void reset(int size)
   {
      //after the confirm pressed, it should clear the board and reset the game
      currentPlayerIndex = 0;

      boardGUI.reset(size);
      boardGUI.addGameControl(this);
      board = boardGUI.getBoard();

      String p1 = player_list.get(0).getName();
      String p2 = player_list.get(1).getName();
      announcement.announceScore(p1 + ": " + board.getBlackScore() + " vs " + p2 + ": " + board.getWhiteScore());
      announcement.announceWin("Valid: " + "N/A");
      announcement.announcePlayer("Current Player is Blue");
      int x = boardGUI.getBoardSize();
      if(x == 8)
      {
         max = 64;
      }
      else
      {
         max = 36;
      }
   }

//pass turn over to the other player when pressed
   public void passTurn()
   {
      currentPlayerIndex++;
      currentPlayerIndex = currentPlayerIndex % 2;
      String p1 = player_list.get(0).getName();
      String p2 = player_list.get(1).getName();
      if(currentPlayerIndex == 0)
      {
         announcement.announcePlayer("Current Player is " + p1);
      }
      else
      {
         announcement.announcePlayer("Current Player is " + p2);
      }

   }

}
