package consti;

import java.io.File;
import java.net.Socket;
import javax.swing.JPanel;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import consti.Commun;

public class Utilisateur{
    public Utilisateur(){}

    public static void envoyer(String path , Commun commun , String nomClient) throws Exception{
        //Commun commun = new Commun();
        File file = new File(path);
        FileInputStream in = new FileInputStream(file);
        int base = 1024;

        //En-tete a envoyer
        String[] tab = {String.valueOf(in.available()) , String.valueOf(base) , file.getName() , nomClient};


        //Ouverture de la communication
        Socket sock = new Socket(InetAddress.getLocalHost(), 9001); 
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());


        //Envoi de l'en-tete
        out.writeInt(tab.length);
        for (int i = 0; i < tab.length; i++) {
            out.writeUTF(tab[i]);
        }

        //Envoi du fichier
        commun.setType("envoyer");
        commun.transfert(in , out , base ,  true);

            
            
        //Fermeture de la communication
        sock.close();
    }

    public static void recevoir(JPanel panel , Commun commun) throws Exception{
        //Commun commun = new Commun();

        System.out.println("miandry recevoir");

        //Ouverture d'une connexion
        Socket sock = new ServerSocket(9001).accept();
        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
        panel.setVisible(true);
        System.out.println("vita le mamoha connexion");

        //Reception de l'en-tete
        int n = in.readInt();

        String[] tab = new String[n];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.readUTF();
        }
        System.out.println("vita le reception entete");


        //Reception du fichier
        commun.setType("recevoir");
        int base = Integer.parseInt(tab[1]);
        commun.setMaximum(Integer.parseInt(tab[0]) / base);
        commun.getTransfert().getProvenance().setText("Provenance de "+tab[3]);
        commun.transfert(in , new FileOutputStream(new File("Recu/"+tab[2])) , base ,  true);
        commun.getTransfert().getProvenance().setText("Provenance de ");
        System.out.println("vita le reception fichier");

        //Fermeture de la communication
        sock.close();
        System.out.println("vita le manidy comm");

            
        //Affichage de l'en-tete
        for (String s : tab) {
            System.out.println(s);
        }

        System.out.println("vita le affiche en-tete");
        System.out.println("vita le recevoir");
    }

}