import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GameGUI
{
   protected JFrame baseFrame;
   protected JPanel basePanel;
   protected BoardGUI board;
   protected OptionGUI option;

   public GameGUI()
   {
      baseFrame = new JFrame();
      basePanel = new JPanel();

      baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      baseFrame.setPreferredSize(new Dimension(650, 500));
      baseFrame.setResizable(false);

      basePanel.setLayout(new GridLayout(0, 2));
      basePanel.setPreferredSize(new Dimension(40*8, 40*8));
      baseFrame.add(basePanel);

      baseFrame.pack();
      baseFrame.setVisible(true);
   }

   public void add_Board(BoardGUI b)
   {
      board = b;
      basePanel.add(board);
      baseFrame.pack();
   }

   public void add_Option(OptionGUI o)
   {
      option = o;
      basePanel.add(option);
      baseFrame.pack();
   }

   public BoardGUI getBoardGUI()
   {
      return board;
   }

   public void setControl(GameControl c)
   {
      option.setControl(c);
   }
   
}
