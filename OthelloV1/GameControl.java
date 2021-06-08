import java.util.ArrayList; 
public class GameControl
{
   BoardGUI boardGUI;
   AnnouncementGUI announcement;
   Board board;
   int currentPlayerIndex;
   ArrayList<Player> player_list = new ArrayList<Player>();

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
   }

//constructor with players
   public GameControl(BoardGUI b, Player p1, Player p2)
   {
      boardGUI = b;
      board = b.getBoard();
      currentPlayerIndex = 0;
      player_list.add(p1);
      player_list.add(p2);
   }

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

      if(pieces == 64 || board.getBlackScore() == 0 || board.getWhiteScore() == 0)
      {
         if(board.getWhiteScore() < board.getBlackScore())
         {
            announcement.announceWin("Result: " + p1 + " wins");
         }
         if(board.getWhiteScore() == board.getBlackScore())
         {
            announcement.announceWin("Result: It's a tie");
         }
         if(board.getWhiteScore() > board.getBlackScore())
         {
            announcement.announceWin("Result: " + p2 + " wins");
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
   // additional part
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

      announcement.announcePlayerName(name1 + " vs " + name2);
   }

   // addtional part
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
   }

}














































