import com.thehowtotutorial.splashscreen.JSplash;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, IllegalAccessException, UnsupportedLookAndFeelException, InstantiationException {
        UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
        JSplash splash = new JSplash(Principal.class.getResource("image2.jpg"),true,true,false,"V1.1",null, Color.blue,Color.black);
        splash.splashOn();
        Thread.sleep(1000);
        splash.setProgress(20,"Init");
        new GestionVector();
        GestionVector.initInputFile();
        splash.setProgress(60,"Loading files");
        GestionVector.readAllVector();
        splash.setProgress(100,"Done");
        Thread.sleep(5000);

        splash.splashOff();
        new GUIprincipal();
    }

    public static void ouvrirFenetreModifierClient(Pilote p){

    }
}
