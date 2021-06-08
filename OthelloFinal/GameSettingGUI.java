import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBoxMenuItem;

public class GameSettingGUI implements ActionListener
{
   JFrame frame;
   JPanel basePanel;
   JPanel upperPanel;
   JPanel lowerPanel;
   JLabel player_name1;
   JLabel player_name2;
   JTextField name1;
   JTextField name2;
   JCheckBox red_p1;
   JCheckBox blue_p1;
   JCheckBox red_p2;
   JCheckBox blue_p2;
   JCheckBox opt1, opt2;
   JButton confirm;
   JButton reset;
   GameControl control;
   private GridBagConstraints gbc = new GridBagConstraints();

// contructor that initializes all the different labels and fields in the settings
   public GameSettingGUI(ConfirmPressed info)
   {
      frame = new JFrame("Game Setting");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      basePanel = new JPanel();
      upperPanel = new JPanel();
      lowerPanel = new JPanel();

      player_name1 = new JLabel("Player Name: ");
      player_name2 = new JLabel("Player Name: ");

      name1 = new JTextField(30);
      name2 = new JTextField(30);

      red_p1 = new JCheckBox("Red");
      blue_p1 = new JCheckBox("Blue");
      red_p2 = new JCheckBox("Red");
      blue_p2 = new JCheckBox("Blue");
      red_p1.addActionListener(this);
      red_p2.addActionListener(this);
      blue_p1.addActionListener(this);
      blue_p2.addActionListener(this);


      opt1 = new JCheckBox("8x8");
      opt2 = new JCheckBox("6x6");
      opt1.addActionListener(this);
      opt2.addActionListener(this);

      confirm = new JButton("Confirm");
      confirm.addActionListener(info);

      reset = new JButton("Reset");
      reset.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  red_p1.setEnabled(true);
                  red_p1.setSelected(false);
                  red_p2.setEnabled(true);
                  red_p2.setSelected(false);
                  blue_p1.setEnabled(true);
                  blue_p1.setSelected(false);
                  blue_p2.setEnabled(true);
                  blue_p2.setSelected(false);
                  opt1.setEnabled(true);
                  opt1.setSelected(false);
                  opt2.setEnabled(true);
                  opt2.setSelected(false);
         }});

      basePanel.setLayout(new GridLayout(2, 0));
      upperPanel.setLayout(new GridBagLayout());
      lowerPanel.setLayout(new GridBagLayout());

//---------------------------------------------------
      // Player Label
      gbc.gridx = 0;
      gbc.gridy = 0;
      upperPanel.add(player_name1, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      upperPanel.add(player_name2, gbc);
//----------------------------------------------------
      // Player name text field
      gbc.gridx = 1;
      gbc.gridy = 0;
      upperPanel.add(name1, gbc);

      gbc.gridx = 1;
      gbc.gridy = 1;
      upperPanel.add(name2, gbc);
//----------------------------------------------------
      // Player turn pick
      gbc.gridx = 2;
      gbc.gridy = 0;
      upperPanel.add(red_p1, gbc);

      gbc.gridx = 3;
      gbc.gridy = 0;
      upperPanel.add(blue_p1, gbc);


      gbc.gridx = 2;
      gbc.gridy = 1;
      upperPanel.add(red_p2, gbc);

      gbc.gridx = 3;
      gbc.gridy = 1;
      upperPanel.add(blue_p2, gbc);
//-----------------------------------------------------
      // Board Options
      gbc.gridx = 0;
      gbc.gridy = 2;
      upperPanel.add(new JLabel("Board Choice"), gbc);

      gbc.gridx = 1;
      gbc.gridy = 2;
      upperPanel.add(opt1, gbc);

      gbc.gridx = 2;
      gbc.gridy = 2;
      upperPanel.add(opt2, gbc);
//-----------------------------------------------------
      // confirm button
      gbc.gridx = 0;
      gbc.gridy = 3;
      lowerPanel.add(confirm, gbc);
//------------------------------------------------------
      // reset button
      gbc.gridx = 0;
      gbc.gridx = 4;
      lowerPanel.add(reset, gbc);

//-----------------------------------------------------
      basePanel.add(upperPanel);
      basePanel.add(lowerPanel);
      frame.add(basePanel);
      frame.pack();
      frame.setVisible(true);
  }

// returns the names of the players from fields
   public String[] getPlayerName()
   {
      String[] names = new String[2];
      names[0] = name1.getText();
      names[1] = name2.getText();
      return names;
   }

// returns the color options of the players from the check boxes
   public String[] getPlayerColor()
   {
      // the first element is player 1's color, the second is player2's
      String[] color = new String[2];
      if(red_p1.isSelected())
         color[0] = "b";
      else
         color[0] = "w";
      if(color[0].equals("b"))
         color[1] = "w";
      else
         color[1] = "b";

      return color;
   }

// returns the board size from the options selected
   public int getBoardSize()
   {
      if(opt2.isSelected())
            return 6;
      else
            return 8;
   }

// closes the window on clicking confirm
   public void closeWindow()
   {
      frame.dispose();
   }

// calls the functions that make sure that one of each check boxes is selected
   public void actionPerformed(ActionEvent event)
   {
      boardSizeSelection();
      colorSelection();
   }

// disables impossible options for choosing colors
   public void colorSelection()
   {
      if(red_p1.isSelected())
      {
         blue_p1.setEnabled(false);
         red_p2.setEnabled(false);
      }
      if(red_p2.isSelected())
      {
         blue_p2.setEnabled(false);
         red_p1.setEnabled(false);
      }
      if(blue_p1.isSelected())
      {
         blue_p2.setEnabled(false);
         red_p1.setEnabled(false);
      }
      if(blue_p2.isSelected())
      {
         blue_p1.setEnabled(false);
         red_p2.setEnabled(false);
      }
   }

// disables options for choosing sizes
   public void boardSizeSelection()
   {
      if(opt1.isSelected())
         opt2.setEnabled(false);
      if(opt2.isSelected())
         opt1.setEnabled(false);
   }

// making sure that all options have been selected before allowing confirm button to start game
   public boolean confirmFlag()
   {
      if(red_p1.isSelected() || red_p2.isSelected())
         if(blue_p1.isSelected() || blue_p2.isSelected())
            if(opt1.isSelected() || opt2.isSelected())
               return true;
      else
         return false;
      return false;
   }


}
