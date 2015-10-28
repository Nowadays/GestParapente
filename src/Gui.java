import javax.swing.*;
import java.awt.*;

/**
 * Created by deodexed on 15/10/2015.
 * Project name GestParapente
 */
public class Gui extends JFrame {

	private JPanel panelPrincipal;

	public Gui(){
		panelPrincipal = new JPanel();
        this.setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.setSize(new Dimension(800,800));
        this.setLocationRelativeTo(null);
        this.setGUI();
        this.setVisible(true);
	}

    public void setGUI(){

    }
}
