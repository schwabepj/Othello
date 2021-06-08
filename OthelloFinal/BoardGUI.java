import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BoardGUI extends JPanel
{
   private int size;
   private GridBagConstraints gbc = new GridBagConstraints();
   private Board board;
   private BoardButton[][] boardButtons;

// initializes the board with disabled buttons
   public BoardGUI()
   {
      size = 8;
      board = new Board(size);
      boardButtons = new BoardButton[8][8];
      setLayout(new GridBagLayout());
      for (int r = 0; r < 8; r++)
      {
         for (int c = 0; c < 8; c++)
         {
            gbc.gridx = r;
            gbc.gridy = c;
            gbc.insets = new Insets(0, 0, 0, 0);
            BoardButton btn = new BoardButton(r,c);
            boardButtons[r][c] = btn;
            btn.setPreferredSize(new Dimension(40, 40));
            add(btn, gbc);
         }
      }
      update();
      disableBoard();
   }

// return the board for the GameControl
   public Board getBoard()
   {
      return board;
   }

// adds the gameControl to each button
   public void addGameControl(GameControl c)
   {
      //size is the size of the board
      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size; j++)
         {
            boardButtons[i][j].setGameControl(c);
         }
      }
   }

// returns the size of the board for the gameControl
   public int getBoardSize()
   {
      return size;
   }

// updates each boardButton to reflect the matrix in board
   public void update()
   {
      //size is the size of the board
      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size; j++)
         {
            String x = board.getSpot(i,j);
            boardButtons[j][i].update(x);
         }
      }
   }

// resets the boardButtons
   public void reset(int size)
   {
      Board temp = new Board(size);
      super.removeAll();
      this.size = size;
      this.board = temp;
      boardButtons = new BoardButton[size][size];
      setLayout(new GridBagLayout());
      for (int r = 0; r < size; r++)
      {
         for (int c = 0; c < size; c++)
         {
            gbc.gridx = r;
            gbc.gridy = c;
            gbc.insets = new Insets(0, 0, 0, 0);
            BoardButton btn = new BoardButton(r,c);
            boardButtons[r][c] = btn;
            btn.setPreferredSize(new Dimension(40, 40));
            add(btn, gbc);
         }
      }
      super.revalidate();
      super.repaint();

      update();
   }

// disables each button
   public void disableBoard()
   {
      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size; j++)
         {
            boardButtons[j][i].disableButton();
         }
      }
   }
}
  
