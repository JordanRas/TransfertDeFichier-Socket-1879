package ecout;

import consti.Client;
import consti.Commun;
import graph.Transfert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class EcouteurEnvoyer implements ActionListener{
    Client client;
    JTextField field;
    Transfert transfert;
    
    public EcouteurEnvoyer(Client client , JTextField field , Transfert transfert){
        this.client = client;
        this.field = field;
        this.transfert = transfert;
    }

    public void actionPerformed(ActionEvent e){
        try {
            client.envoyer(field.getText() , new Commun(transfert) , client.getNom());
        } catch (Exception f) {
            f.printStackTrace();
        }
        
    }

}
