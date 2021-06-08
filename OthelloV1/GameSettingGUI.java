import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBoxMenuItem;

public class GameSettingGUI
{
   JFrame frame;
   JPanel basePanel;
   JPanel upperPanel;
   JPanel lowerPanel;
   JLabel player_name1;
   JLabel player_name2;
   JTextField name1;
   JTextField name2;
   JCheckBox black_p1;
   JCheckBox white_p1;
   JCheckBox black_p2;
   JCheckBox white_p2;
   JCheckBox opt1, opt2;
   JButton confirm;
   GameControl control;
   private GridBagConstraints gbc = new GridBagConstraints();
   
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

      black_p1 = new JCheckBox("Black");
      white_p1 = new JCheckBox("White");
      black_p2 = new JCheckBox("Black");
      white_p2 = new JCheckBox("White");

      opt1 = new JCheckBox("8x8");
      opt2 = new JCheckBox("6x6");
   
      confirm = new JButton("Comfirm");
      confirm.addActionListener(info);

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
      upperPanel.add(black_p1, gbc);

      gbc.gridx = 3;
      gbc.gridy = 0;
      upperPanel.add(white_p1, gbc);

      
      gbc.gridx = 2;
      gbc.gridy = 1;
      upperPanel.add(black_p2, gbc);
      
      gbc.gridx = 3;
      gbc.gridy = 1;
      upperPanel.add(white_p2, gbc);
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
      
//-----------------------------------------------------
      basePanel.add(upperPanel);
      basePanel.add(lowerPanel);
      frame.add(basePanel);
      frame.pack();
      frame.setVisible(true);
  }


   public String[] getPlayerName()
   {
      String[] names = new String[2];
      names[0] = name1.getText();
      names[1] = name2.getText();
      System.out.println(names[0]);
      System.out.println(names[1]);
      return names;
   }
   
   public String[] getPlayerColor()
   {
      // the first element is player 1's color, the second is player2's
      String[] color = new String[2];
      if(black_p1.isSelected())
         color[0] = "b";
      else
         color[0] = "w";
      if(color[0].equals("b"))  
         color[1] = "w";
      else
         color[1] = "b";
      
      return color;
   }

   public int getBoardSize()
   {
      if(opt1.isSelected())
            return 8;
      else
            return 6;
   }

   public void closeWindow()
   {
      frame.dispose();
   }


}
