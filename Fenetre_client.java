package graph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


public class Fenetre_client extends JFrame{
    public Fenetre_client() throws Exception{
        setTitle("Client");
        setSize(1000, 600);

        JPanel panel = new JPanel();
        panel.setBounds(40 , 40 , 800 , 500);
        panel.setBackground(Color.RED);

        add(panel);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}