package graph;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JPanel;



public class Transfert extends JPanel{   
    JLabel label = new JLabel("0%");
    int maximum = 100;
    int isa = 0;
    JLabel provenance;

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void setIsa(int isa) {
        this.isa = isa;
    }    

    public int getMaximum() {
        return maximum;
    }

    public int getIsa() {
        return isa;
    }

    public JLabel getLabel() {
        return label;
    }

    public JLabel getProvenance() {
        return provenance;
    }

    public void setProvenance(JLabel provenance) {
        this.provenance = provenance;
    }

    public Transfert(JPanel panel , int x , int y){
        label.setBounds(515 , 7 , 25 , 15);
        add(label);
        setLayout(null);
        setBounds(x , y , 600 , 30);
        setVisible(false);
        panel.add(this);
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(1, 1, (isa*(getWidth()-100)/maximum)-1 , getHeight()-2);
        int pourcent = (int) (((double) isa / (double) maximum)*100);
        label.setText(pourcent+"%");
        super.paint(g);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(1, 1, (isa*(getWidth()-100)/maximum)-1 , getHeight()-2);
        int pourcent = (int) (((double) isa / (double) maximum)*100);
        g.setColor(Color.BLACK);
        g.drawRect(0 , 0, 500 , 29);
        g.setColor(new Color(238 , 238 , 238));
        g.fillRect(515, 5, 25, 15);
        label.setText(pourcent+"%");
        // System.out.println("pourcentqge = "+pourcent+"%   isa = "+isa+"   maximum = "+maximum);
    }
}
