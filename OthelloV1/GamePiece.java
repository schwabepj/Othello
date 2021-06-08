import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Rectangle;

import java.awt.Color;

public class GamePiece implements Icon
{
   private int height;
   private String color;

   public GamePiece(String color, int height)
   {
      this.color = color;
      this.height = height;
   }

   public int getIconWidth()
   {
      return height;
   }

   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D)g;
      double oneSixth = height;

      Ellipse2D.Double head = new Ellipse2D.Double(x, y, oneSixth, oneSixth);
      if(color == "b")
      {
         g2.setColor(Color.BLUE);
      }
      else
      {
         g2.setColor(Color.RED);
      }
      g2.fill(head);
      g2.draw(head);
   }
}
