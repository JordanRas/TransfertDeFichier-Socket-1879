package consti;

import java.io.File;
import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import consti.Commun;

public class Utilisateur{
    public Utilisateur(){}

    public static void envoyer() throws Exception{
        Commun commun = new Commun();

        //En-tete a envoyer
        String[] tab = {"Serveur 1" , "Serveur 2" , "Serveur 3" , "Client"};


        //Ouverture de la communication
        Socket sock = new Socket(InetAddress.getLocalHost(), 9001); 
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());


        //Envoi de l'en-tete
        out.writeInt(tab.length);
        for (int i = 0; i < tab.length; i++) {
            out.writeUTF(tab[i]);
        }

        //Envoi du fichier
        commun.transfert(new FileInputStream(new File("Sary/Envoye/coupe.png")) , out , true);

            
            
        //Fermeture de la communication
        sock.close();
    }

    public static void recevoir() throws Exception{
        Commun commun = new Commun();

        
        //Ouverture d'une connexion
        Socket sock = new ServerSocket(9001).accept();
        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
        System.out.println("vita le mamoha connexion");

        //Reception de l'en-tete
        int n = in.readInt();

        String[] tab = new String[n];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.readUTF();
        }
        System.out.println("vita le reception entete");


        //Reception du fichier
        commun.transfert(in , new FileOutputStream(new File("Sary/Recu/recu.png")) , true);
        System.out.println("vita le reception fichier");

        //Fermeture de la communication
        sock.close();
        System.out.println("vita le manidy comm");

            
        //Affichage de l'en-tete
        for (String s : tab) {
            System.out.println(s);
        }

        System.out.println("vita le affiche en-tete");
    }

}