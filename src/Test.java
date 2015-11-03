import javax.swing.*;
import java.awt.*;
import com.bulenkov.darcula.DarculaLaf;
import com.bulenkov.darcula.DarculaLookAndFeelInfo;
import com.bulenkov.iconloader.util.DoubleColor;
/**
 * Created by Morgan on 03/11/2015.
 */
public class Test extends JFrame {

    private JButton button1 = new JButton("Test");
    private JPanel panel = new JPanel();


    public Test(){

        this.setContentPane(panel);
        panel.add(button1);
        this.setMinimumSize(new Dimension(800,800));
        this.setVisible(true);
    }

    public static void main(String[] args){

        new Test();
    }
}
