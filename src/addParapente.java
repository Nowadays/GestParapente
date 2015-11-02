import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Morgan on 02/11/2015.
 */
public class addParapente extends JFrame {
    private JPanel rootPanel;
    private JTextField labelTextField;
    private JTextField labelTextField1;
    private JTextField labelTextField2;
    private JTextField labelTextField3;
    private JButton button1;
    private JButton button2;

    public addParapente() throws HeadlessException {
        this.setContentPane(rootPanel);
        this.pack();
        this.setVisible(true);
    }

    public class TextFieldListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
