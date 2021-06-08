import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGUI
{
   protected JFrame baseFrame;
   protected JPanel basePanel;
   protected BoardGUI board;
   protected OptionGUI option;

// constructor that initializes the JFrame and JPanel
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

// adds the boardGUI to the main panel
   public void add_Board(BoardGUI b)
   {
      board = b;
      basePanel.add(board);
      baseFrame.pack();
   }

// adds the optionGUI to the main panel
   public void add_Option(OptionGUI o)
   {
      option = o;
      basePanel.add(option);
      baseFrame.pack();
   }

// returns the boardGUI for GameControl
   public BoardGUI getBoardGUI()
   {
      return board;
   }

// sets the GameControl for the optionGUI
   public void setControl(GameControl c)
   {
      option.setControl(c);
   }

// passing arraylist
   public ArrayList<Player> getData()
   {
      return option.getData();
   }
}
  
