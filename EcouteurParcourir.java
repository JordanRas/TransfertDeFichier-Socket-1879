package ecout;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurParcourir implements ActionListener{
    JTextField field;
    public EcouteurParcourir(JTextField field){
        this.field = field;
    }

    public void actionPerformed(ActionEvent e){
        JFileChooser test = new JFileChooser(new File(field.getText()));
        File choix = new File(field.getText());
        
        if (test.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            choix = test.getSelectedFile();
        }
        System.out.println(choix.getAbsolutePath());
        field.setText(choix.getAbsolutePath());
    }

}
