import com.thehowtotutorial.splashscreen.JSplash;

import javax.swing.*;
import java.awt.*;
import java.io.File;
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
        Runnable r = new Runnable() {
            @Override
            public void run() {
                GUIprincipal g = new GUIprincipal();
                g.setVisible(true);

            }
        };

        GestionVector.initInputFile();
        GestionVector.readAllVector();

        splash.setProgress(60,"Loading files");
        splash.setProgress(100,"Done");
        Thread.sleep(3000);

        splash.splashOff();
        SwingUtilities.invokeLater(r);

    }

    public static void ouvrirFenetreModifierClient(Pilote p){

    }

    public static void ouvrirFenetreAjouterClient(){
        /*CreatePersonne c = new CreatePersonne();
        c.setVisible(true);*/
    }
}
