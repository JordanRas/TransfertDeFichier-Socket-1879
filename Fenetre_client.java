package graph;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import consti.Client;
import ecout.EcouteurParcourir;
import ecout.EcouteurEnvoyer;

import java.awt.Color;
import graph.Transfert;


public class Fenetre_client extends JFrame{
    public Fenetre_client(String nom , Client client) throws Exception{
        setTitle(nom);
        setSize(1000, 600);

        JPanel panel = new JPanel();
        panel.setBounds(40 , 40 , 1000 , 500);
        panel.setLayout(null);
        //panel.setBackground(Color.RED);

        JLabel nomFichier = new JLabel("Tapez l'emplacement du fichier");
        nomFichier.setBounds(0 , 2 , 200 , 20);
        panel.add(nomFichier);

        JTextField fichier = new JTextField();
        fichier.setBounds(200 , 0 , 500 , 30);
        panel.add(fichier);

        JButton parcourir = new JButton("Parcourir");
        parcourir.setBounds(720 , 0 , 100 , 30);
        parcourir.addActionListener(new EcouteurParcourir(fichier));
        panel.add(parcourir);

        Transfert transfert = new Transfert(panel , 200 , 300);

        JButton envoyer = new JButton("Envoyer");
        envoyer.setBounds(720 , 80 , 100 , 30);
        envoyer.addActionListener(new EcouteurEnvoyer(client , fichier , transfert));
        panel.add(envoyer);


        add(panel);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}