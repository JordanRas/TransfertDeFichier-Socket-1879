package consti;

import java.io.InputStream;
import java.io.OutputStream;

import graph.Transfert;

import java.io.IOException;

public class Commun {
    Transfert transfert;
    String type;
    int maximum = 1;

    public void setType(String type) {
        this.type = type;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public Transfert getTransfert() {
        return transfert;
    }

    public Commun(Transfert transfert){
        this.transfert = transfert;
    }

    public Commun(){}

    public void transfert(InputStream in , OutputStream out , int base , boolean closeOnExit){
        try {
            // int base = 1024;
            int total = in.available() / base;
            if (in.available() % base != 0) {
                total++;
            }

            if (transfert != null) {
                transfert.setVisible(true);
                if (type.equals("envoyer")) {
                    transfert.setMaximum(total);    
                }else{
                    transfert.setMaximum(maximum);
                }
                
            }

            byte[] buf = new byte[base];

            int n = in.read(buf);
            int isa = 0;
            while(n != -1){          //ty kay -1 fa tsy 1 de mety tsara
                out.write(buf , 0 , n);
                n = in.read(buf);
                isa++;
                if (transfert != null) {
                    transfert.setIsa(isa);
                    transfert.paint(transfert.getGraphics());
                    // transfert.getLabel().repaint();
                }
            }
            if (transfert != null) {
                transfert.setIsa(0);
                transfert.setVisible(false);
            }

            System.out.println("total = "+total+"   isa = "+isa);

            if (closeOnExit) {
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
