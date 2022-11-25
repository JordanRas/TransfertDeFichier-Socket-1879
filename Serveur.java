package consti;

import java.io.IOException;

import graph.Fenetre_serveur;

public class Serveur extends Utilisateur{
    public static void main(String[] args) throws Exception , IOException{
        new Fenetre_serveur();
        recevoir();
    }
}
