public class Board
{
   private String[][] matrix;
   private int whitescore;
   private int blackscore;
   private boolean valid;
   private int size;


// constructor for 8 by 8 board
   public Board()
   {
      size = 8;
      matrix = new String[size][size];
      for(int i = 0; i < size;i++)
      {
         for(int j = 0;  j < size;j++)
         {
            matrix[i][j] = "-";
         }
      }
      matrix[size/2 - 1][size/2 - 1] = "w";
      matrix[(size/2)][(size/2)] = "w";
      matrix[size/2][(size/2)-1] = "b";
      matrix[(size/2) - 1][(size/2)] = "b";
      whitescore = 2;
      blackscore = 2;
   }

// constructor for different sizes
   public Board(int size)
   {
      this.size = size;
      matrix = new String[size][size];
      for(int i = 0; i < size;i++)
      {
         for(int j = 0;  j < size;j++)
         {
            matrix[i][j] = "-";
         }
      }
      matrix[size/2 - 1][size/2 - 1] = "w";
      matrix[(size/2)][(size/2)] = "w";
      matrix[size/2][(size/2)-1] = "b";
      matrix[(size/2) - 1][(size/2)] = "b";
      whitescore = 2;
      blackscore = 2;
   }

//adds a piece to the board at the location (c,r) with a color
   public void addpiece(int c, int r,String color)
   {
      valid = false;
      matrix[c][r] = color;
      flipPiece(c,r,color);
      if(color == "w")
      {
         whitescore++;
      }
      else
      {
         blackscore++;
      }
      print();
   }

// function that calls checkdirections for each direction to flip pieces
   public void flipPiece(int c, int r,String color)
   {
      checkdirections(c,r,color,1,1);
      checkdirections(c,r,color,1,0);
      checkdirections(c,r,color,1,-1);
      checkdirections(c,r,color,0,1);
      checkdirections(c,r,color,0,-1);
      checkdirections(c,r,color,-1,1);
      checkdirections(c,r,color,-1,0);
      checkdirections(c,r,color,-1,-1);
      if(valid == false)
      {
         if(color == "w")
         {
            whitescore--;
         }
         else
         {
            blackscore--;
         }
         matrix[c][r] = "-";
      }
   }

// logic to check the directions that pieces should flip
   public void checkdirections(int c,int r, String color, int x, int y)
   {
      int col = c + x;
      int row = r + y;
      boolean flag = false;

      if(row > (size - 1) || row < 0 || col > (size - 1) || col < 0)
      {
         flag = true;
      }
      else if("-" == matrix[col][row])
      {
         flag = true;
      }
      else if(color == matrix[col][row])
      {
         flag = true;
      }

      while(row <= (size - 1) && row >= 0 && col <= (size - 1) && col >= 0 && flag == false)
      {
         if("-" == matrix[col][row])
         {
            flag = true;
         }
         else if(color == matrix[col][row])
         {
            col = col - x;
            row = row - y;
            while(color != matrix[col][row])
            {
               if(color == "w")
               {
                  valid = true;
                  whitescore++;
                  blackscore--;
               }
               else
               {
                  valid = true;
                  blackscore++;
                  whitescore--;
               }

               matrix[col][row] = color;
               col = col - x;
               row = row - y;
            }
            flag = true;
         }
         col = col + x;
         row = row + y;
      }

   }

   // Function to print out the state of board

   public void print()
   {
      System.out.println("After adding piece:");
      // System.out.println("White Score: " + getWhiteScore());
      // System.out.println("Black Score: " + getBlackScore());
      // System.out.println("Valid: " + getValid());
      for(int i = 0; i < size;i++)
      {
         for(int j = 0;  j < size;j++)
         {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
   }

   public int getBlackScore()
   {
      return blackscore;
   }

   public int getWhiteScore()
   {
      return whitescore;
   }

   public boolean getValid()
   {
      return valid;
   }

   public String getSpot(int c, int r)
   {
      return matrix[c][r];
   }
}
