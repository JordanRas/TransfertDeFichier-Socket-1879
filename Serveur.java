package consti;

import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

import graph.Fenetre_serveur;
import graph.Transfert;

public class Serveur extends Utilisateur{
    public Serveur(){}
    public static void main(String[] args) throws Exception , IOException{
        Serveur serveur = new Serveur();

        JPanel panel = new JPanel();
        panel.setBounds(80 , 40 , 800 , 500);
        panel.setLayout(null);
        panel.setVisible(false);

        JLabel provenance = new JLabel("Provenance de ");
        provenance.setBounds(350 , 100 , 300 , 20);
        panel.add(provenance);  

        Transfert transfert = new Transfert(panel , 150 , 150);
        transfert.setProvenance(provenance);
        transfert.setVisible(true);

        new Fenetre_serveur("Serveur 1" , panel);

        serveur.recevoir(panel , new Commun(transfert));
    }
}
