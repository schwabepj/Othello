import javax.swing.*;
import java.awt.event.*;

public class BoardButton extends JButton implements ActionListener
{
   private int row;
   private int col;
   private boolean used;
   private GameControl control;

   public BoardButton(int r, int c)
   {
      used = false;
      row = r;
      col = c;
      addActionListener(this);
   }

   public void setGameControl(GameControl c)
   {
      control = c;
   }

   public void actionPerformed(ActionEvent e)
   {
      if (control != null)
      {
         System.out.println(col + " " + row);
         control.update(col, row);
      }
   }
   public void update(String val)
   {
      if(val != "-")
      {
         GamePiece piece = new GamePiece(val,20);
         setIcon(piece);
         used = true;
         setEnabled(false);
      }
   }
   
   // additonal part
   public void reset()
   {
      super.setText("");
      super.setSelected(false);
      super.setEnabled(true);
      System.out.println("reset");
      setIcon(null);
   }
}
