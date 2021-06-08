import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class BoardButton extends JButton implements ActionListener
{
   private int row;
   private int col;
   private GameControl control;

// constructor that sets the coordinates of the boardbutton and adds an action listener
   public BoardButton(int r, int c)
   {
      row = r;
      col = c;
      addActionListener(this);
   }

// sets the control of the boardbutton
   public void setGameControl(GameControl c)
   {
      control = c;
   }

// calls the function update of control if control is not null
   public void actionPerformed(ActionEvent e)
   {
      if (control != null)
      {
         control.update(col, row);
      }
   }

// updates the color board button to be the same as the passed value
   public void update(String val)
   {
      if (!val.equals("-"))
      {
         if (val.equals("b"))
         {
            setBackground(Color.BLUE);
         }
         else
         {
            setBackground(Color.RED);
         }
         setOpaque(true);
         setEnabled(false);
      }
   }

// resets the board to the start of game state called in BoardGUI
   public void reset()
   {
      setOpaque(false);
      setSelected(false);
      setBackground(null);
      setEnabled(true);
   }

// disables buttons at the start of game until information is entered
   public void disableButton()
   {
      setEnabled(false);
      setBackground(Color.WHITE);
      setOpaque(true);
   }
}
