// revised version of Player class

public class Player
{
   private String name;
   private String gamePiece;

   private int black_won;
   private int white_won;


   public Player(String n, String color, int bw, int ww)
   {
      name = n;
      black_won = bw;
      white_won = ww;
      gamePiece = color;

   }
   public void setName(String n)
   {
      this.name = n;
   }

   public String getGamePiece()
   {
      return gamePiece;
   }

   public void setGamePiece(String color)
   {
      this.gamePiece = color;
   }

   public void set_black_won()
   {
      black_won++;
   }

   public void set_white_won()
   {
      white_won++;
   }

   public String getName()
   {
      return name;
   }

   public int getBlackWon()
   {
      return black_won;
   }

   public int getWhiteWon()
   {
      return white_won;
   }

   public String get_info()
   {
      return "Player: " + name + "  " + "\n"  + "Black won: " + black_won + "\n" + "White won: " + white_won + "\n";
   }
}
