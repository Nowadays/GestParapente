import com.thehowtotutorial.splashscreen.JSplash;

import java.awt.*;

/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        JSplash splash = new JSplash(Principal.class.getResource("image2.jpg"),true,true,false,"V1.1",null, Color.blue,Color.black);
        splash.splashOn();
        Thread.sleep(1000);
        splash.setProgress(20,"Init");
        Thread.sleep(5000);
        splash.setProgress(60,"Loading files");
        Thread.sleep(5000);
        splash.setProgress(100,"Done");
        Thread.sleep(5000);
        splash.splashOff();
    }
}
