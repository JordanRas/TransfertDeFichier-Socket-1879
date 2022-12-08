package ecout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import consti.Serveur;

public class EcouteurChoix implements ActionListener{
    JPanel panel;
    Serveur serveur;

    public EcouteurChoix(JPanel panel , Serveur serveur){
        this.panel = panel;
        this.serveur = serveur;
    }

    public void actionPerformed(ActionEvent e){
        
    }
}
