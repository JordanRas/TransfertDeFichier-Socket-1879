package consti;

import java.io.IOException;

import graph.Fenetre_client;

public class Client extends Utilisateur{
    String nom = "Jordan";

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client(){}
    public static void main(String[] args) throws Exception , IOException{
        Client client = new Client();
        new Fenetre_client(client.getNom() , client);
        //envoyer();
    }   
}