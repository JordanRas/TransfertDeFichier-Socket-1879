package consti;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Commun {

    public Commun(){}

    public void transfert(InputStream in , OutputStream out , boolean closeOnExit){
        try {
            byte buf[] = new byte[1024];

            int n;
            while((n=in.read(buf)) !=1){
                out.write(buf , 0 , n);
            }

            if (closeOnExit) {
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
