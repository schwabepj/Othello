

public class Player
{
   private String name;
   private String gamePiece;

   private int black_won;
   private int white_won;

// constructor that initializes variables
   public Player(String n, String color, int bw, int ww)
   {
      name = n;
      black_won = bw;
      white_won = ww;
      gamePiece = color;
   }

// sets the name of the player
   public void setName(String n)
   {
      this.name = n;
   }

// returns game piece color
   public String getGamePiece()
   {
      return gamePiece;
   }

// sets game piece color
   public void setGamePiece(String color)
   {
      this.gamePiece = color;
   }

// sets amount of black(blue) wins
   public void set_black_won(int wins)
   {
      black_won = wins;
   }

// sets amount of white(red) wins
   public void set_white_won(int wins)
   {
      white_won = wins;
   }

// returns name of player
   public String getName()
   {
      return name;
   }

// returns number of black(blue) wins
   public int getBlackWon()
   {
      return black_won;
   }

// returns number of white(red) wins
   public int getWhiteWon()
   {
      return white_won;
   }

// prints off the information of the player
   public String get_info()
   {
      return name + "," + gamePiece + "," + black_won + "," + white_won + "\n";
   }
}
