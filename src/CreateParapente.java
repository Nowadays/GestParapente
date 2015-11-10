import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Morgan on 02/11/2015.
 */
public class CreateParapente extends JDialog {

    private JPanel rootPanel;
    private JTextField marqueTextField;
    private JTextField voileTextField;
    private JTextField poidMaxTextField;
    private JButton OKButton;
    private JButton annulerButton;
	private JLabel marque;
	private JLabel modele;
	private JLabel voile;
	private JLabel poid;
	private JComboBox modeleCombo;
	//private JLabel matricule;
	private GUIprincipal g;

	private String marqueS;
	private String modeleS;
	private String voileS;
	private String poidS;
	private String matriculeS;

	private int isEdited;
	private int index;
	private Parapente p;


    public CreateParapente(GUIprincipal g, Parapente p, int isEdited, int index) throws HeadlessException {
        this.g = g;
	    this.isEdited = isEdited;
	    this.index = index;
	    this.p = p;
	    this.setTitle("Ajouter un Parapente");
        this.setMinimumSize(new Dimension(400,250));
        this.setContentPane(rootPanel);
        this.setModal(true);
        this.setResizable(false);
	    this.addComponent();
	    this.addComponentFilledWithValues();
	    this.pack();
        this.setVisible(true);
    }
	public CreateParapente(GUIprincipal g) throws HeadlessException {
		this.g = g;
		this.setTitle("Ajouter un Parapente");
		this.setMinimumSize(new Dimension(400,250));
		this.setContentPane(rootPanel);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.addComponent();
		this.pack();
		this.setVisible(true);
	}

	public void addComponent(){
		//modeleTextField.addKeyListener(new TextFieldListener());
		poidMaxTextField.addKeyListener(new TextFieldListener());
		marqueTextField.addKeyListener(new TextFieldListener());
		voileTextField.addKeyListener(new TextFieldListener());
		String item1 ="1 place";
		String item2 = "2 places";
		modeleCombo.addItem(item1);
		modeleCombo.addItem(item2);

		//matriculeTextField.addKeyListener(new TextFieldListener());

		OKButton.addActionListener(new ButtonListener());
		annulerButton.addActionListener(new ButtonListener());
	}

	public void addComponentFilledWithValues(){
		marqueTextField.setText(p.getMarque());
		//matriculeTextField.setText(p.getNo_immatriculation());
		poidMaxTextField.setText(p.getPoid_maxi());
		voileTextField.setText(p.getTaille_voile());
		int i = 1;
		if(p.getModele().equals("1 place")){
			i = 0;
		}
		modeleCombo.setSelectedIndex(i);
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
			if(e.getSource() == OKButton){
				modeleS=modeleCombo.getSelectedItem().toString();
				marqueS=marqueTextField.getText();
				poidS=poidMaxTextField.getText();
				matriculeS = "000"+Integer.toString(Parapente.nb_parapente);
				voileS=voileTextField.getText();

				if(isEdited == 1){
					GestionVector.vParapente.removeElement(p);
					GestionVector.vParapente.add(index,new Parapente(marqueS,voileS,poidS,modeleS));
				}
				else{
					GestionVector.vParapente.add(new Parapente(marqueS,voileS,poidS,modeleS));
				}
				g.createParapenteTable(2);
				dispose();
			}
	        else if(e.getSource() == annulerButton){
				CreateParapente.this.dispose();
			}


        }
    }

   /* public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new CreateParapente();
    }*/
}
