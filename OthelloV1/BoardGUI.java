import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;


public class BoardGUI extends JPanel
{
   private int size;
   private GridBagConstraints gbc = new GridBagConstraints();
   private Board board;
   private BoardButton[][] boardbuttons;

   public BoardGUI()
   {
      size = 8;
      board = new Board();
      boardbuttons = new BoardButton[8][8];
      setLayout(new GridBagLayout());
      for(int r = 0; r < 8; r++)
      {
         for(int c = 0; c < 8; c++)
         {
            gbc.gridx = r;
            gbc.gridy = c;
            gbc.insets = new Insets(0, 0, 0, 0);
            BoardButton btn = new BoardButton(r,c);
            boardbuttons[r][c] = btn;
            btn.setPreferredSize(new Dimension(40, 40));
            add(btn, gbc);
         }
      }
      update();
   }

   public BoardGUI(int size)
   {
      this.size = size;
      board = new Board(size);
      boardbuttons = new BoardButton[size][size];
      setLayout(new GridBagLayout());
      for(int r = 0; r < size; r++)
      {
         for(int c = 0; c < size; c++)
         {
            gbc.gridx = r;
            gbc.gridy = c;
            gbc.insets = new Insets(0, 0, 0, 0);
            BoardButton btn = new BoardButton(r,c);
            boardbuttons[r][c] = btn;
            btn.setPreferredSize(new Dimension(40, 40));
            add(btn, gbc);
         }
      }
      update();
   }

   // return the board for the GameControl
   public Board getBoard()
   {
      return board;
   }

   public void addGameControl(GameControl c)
   {
      //size is the size of the board
      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size; j++)
         {
            boardbuttons[i][j].setGameControl(c);
            
         }
      }
   }

   public void update()
   {
      //size is the size of the board
      for(int i = 0; i < size; i++)
      {
         for(int j = 0; j < size; j++)
         {
            String x = board.getSpot(i,j);
            boardbuttons[j][i].update(x);
         }
      }
   }

   public void reset(int size)
   {
      Board temp = new Board(size);
      super.removeAll();
      this.size = size;
      this.board = temp;
      boardbuttons = new BoardButton[size][size];
      setLayout(new GridBagLayout());
      for(int r = 0; r < size; r++)
      {
         for(int c = 0; c < size; c++)
         {
            gbc.gridx = r;
            gbc.gridy = c;
            gbc.insets = new Insets(0, 0, 0, 0);
            BoardButton btn = new BoardButton(r,c);
            boardbuttons[r][c] = btn;
            btn.setPreferredSize(new Dimension(40, 40));
            add(btn, gbc);
         }
      }
      super.revalidate();
      super.repaint();

      update();
   }


}

