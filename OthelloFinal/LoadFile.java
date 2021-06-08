import java.io.*;
import java.util.*;

public class LoadFile
{
   private ArrayList<Player> data = new ArrayList<Player>();

   // loading saved game data or saved players' rank
   public ArrayList<Player> loadPlayer(String filename)
   {
      try
      {
         Scanner scanner = new Scanner(new File(filename));
         while (scanner.hasNextLine())
         {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            tokens[1] = tokens[2].replaceAll("\\s", "");
            tokens[2] = tokens[2].replaceAll("\\s", "");
            tokens[3] = tokens[3].replaceAll("\\s", "");
            int black = Integer.valueOf(tokens[2]);
            int white = Integer.valueOf(tokens[3]);
            if (tokens[2].equals(" 10"))
            {
               System.out.println("True");
            }
            data.add(new Player(tokens[0], tokens[1], black, white));
         }

         scanner.close();

      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (NumberFormatException e)
      {
         System.out.println("Fail to convert to int");
      }
      catch (NoSuchElementException e)
      {
         System.out.println("NoSuchElementException");
         sorting(data);
         return data;
      }
      sorting(data);
      return data;
   }

// sorts the JList using bubble sort
   private void sorting(ArrayList<Player> source)
   {
      int size = source.size();

      for (int i = 0; i < size - 1; i++)
      {
         for (int j = 0; j < size - i - 1; j++)
         {
            int value1 = source.get(j).getBlackWon() + source.get(j).getWhiteWon();
            int value2 = source.get(j+1).getBlackWon() + source.get(j+1).getWhiteWon();
            if (value1 < value2)
            {
               Collections.swap(source, j, j + 1);
            }
         }
      }
   }
}
