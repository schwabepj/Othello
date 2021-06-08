import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.GridLayout;
import java.util.ArrayList;

public class RankGUI extends JPanel
{
   private JList<String> list = new JList<String>();
   private ArrayList<Player> players = new ArrayList<Player>();
   private JLabel rank;
   private ArrayList<Player> player_rank = new ArrayList<Player>();

// creates the Jlist and the panels when names are clicked
   public RankGUI(ArrayList<Player> player_data)
   {
      rank = new JLabel("Players' Ranks and Information");
      player_rank = player_data;
      setLayout(new BorderLayout());

      String[] player_list = new String[player_rank.size()];

      for (int i = 0; i < player_rank.size(); i++)
      {
         player_list[i] = player_rank.get(i).getName();
      }

      list.setListData(player_list);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      add(rank, BorderLayout.NORTH);
      add(new JScrollPane(list), BorderLayout.CENTER);

      // check the simple functionality
      list.addListSelectionListener(
         new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event)
            {
               /* 1st event: press the left mouse
                      button without releasing it
                  2nd event: releasing the left moutse
                      button.
                */
                if (!event.getValueIsAdjusting())
                {
                   String p_name = list.getSelectedValue();
                   Player p = new Player("N/A", "color", 0, 0);
                   JFrame info = new JFrame("Player Information");
                   info.setPreferredSize(new Dimension(300, 200));
                   info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                   for (int i = 0; i < player_list.length; i++)
                   {
                      // additional change on fetching source
                      if (player_rank.get(i).getName().equals(p_name))
                      {
                         p = player_rank.get(i);
                         break;
                      }
                   }

                   JLabel name = new JLabel("Name: " + p.getName());
                   JLabel b_won = new JLabel("Blue Wins: " + p.getBlackWon());
                   JLabel w_won = new JLabel("Red Wins: " + p.getWhiteWon());

                   JPanel panel = new JPanel();
                   panel.setPreferredSize(new Dimension(200, 200));
                   panel.setLayout(new GridLayout(4, 0));

                   panel.add(name);
                   panel.add(b_won);
                   panel.add(w_won);
                   info.add(panel);
                   info.pack();
                   info.setVisible(true);
                }
             }
          }
       );
    }
}
