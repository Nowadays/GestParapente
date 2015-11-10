import javax.swing.*;
import java.awt.*;

/**
 * Created by Morgan on 10/11/2015.
 */
public class Facture extends JDialog {
	private JPanel rootPanel;
	private JLabel facture;
	private JLabel nom;
	private JLabel nomVar;
	private JLabel prenomVar;
	private JLabel dureVar;
	private JLabel prixVar;
	private JButton imprimer;
	private JButton annulerButton;


	public Facture(){
		this.setTitle("Facture");
		this.setMinimumSize(new Dimension(400,250));
		this.setContentPane(rootPanel);
		this.setModal(true);
		this.setResizable(false);
		this.addComponent();
		//this.addComponentFilledWithValues();
		this.pack();
		this.setVisible(true);
	}

	public void addComponent(){

	}
}
