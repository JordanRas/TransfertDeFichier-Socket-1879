package consti;

import java.io.IOException;

import graph.Fenetre_client;

public class Client extends Utilisateur{
    public static void main(String[] args) throws Exception , IOException{
        new Fenetre_client();
        envoyer();
    }
}