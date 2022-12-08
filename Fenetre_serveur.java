package graph;

import javax.swing.JFrame;
import javax.swing.JPanel;

import consti.Serveur;
import ecout.EcouteurChoix;

public class Fenetre_serveur extends JFrame{
    public Fenetre_serveur(String nom , JPanel panel) throws Exception{
        setTitle(nom);
        setSize(1000, 600);
        setLayout(null);

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

}
