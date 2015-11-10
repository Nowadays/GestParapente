import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Created by Morgan on 09/11/2015.
 */
public class CreateVol extends JDialog {
	private JPanel rootPanel;
	private JComboBox clientsCombo;
	private JTextField licenceTextField;
	private JTextField jourTextField;
	private JTextField moisTextField;
	private JTextField anneeTextField;
	private JTextField departTextField;
	private JTextField arriveTextField;
	private JCheckBox passagerCheckBox;
	private JLabel passager;
	private JLabel site_arrive;
	private JLabel site_depart;
	private JLabel date;
	private JLabel licence;
	private JLabel nom;
	private JPanel panelPrincipal;
	private JButton OKButton;
	private JButton annulerButton;

	private String nomS;
	private String licenceS;
	private JComboBox parapenteCombo;
	private JLabel parapente;
	private String jourS;
	private String moisS;
	private String anneeS;
	private String departS;
	private String arriveS;

	private GUIprincipal g;
	private int index;
	private int isEdited;
	private GestionVol gestTion;



	public CreateVol(GUIprincipal g){
		this.g = g;
		this.setTitle("Ajouter un Vol");
		this.setMinimumSize(new Dimension(400,250));
		this.setContentPane(rootPanel);
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		annulerButton.addActionListener(new CloseButtonListener());
		this.addComponent();
		//this.addComponentFilledWithValues();
		this.pack();
		this.setVisible(true);
	}

	public CreateVol(GUIprincipal g, GestionVol gest,int isEdited, int index){
		this.g = g;
		this.isEdited = isEdited;
		this.index = index;
		this.gestTion = gest;
		annulerButton.addActionListener(new CloseButtonListener());

		this.setTitle("Ajouter un Vol");
		this.setMinimumSize(new Dimension(400,250));
		this.setContentPane(rootPanel);
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addComponentFilledWithValues();
		this.pack();
		this.setVisible(true);
	}

	public void addComponent(){

				for(int i = 0; i < GestionVector.vPersonne.size(); i++){
					clientsCombo.addItem(GestionVector.vPersonne.get(i).getNom()+" / "+GestionVector.vPersonne.get(i).getPoid()+" Kg");
				}
				for(int j = 0; j < GestionVector.vParapente.size(); j++) {
					parapenteCombo.addItem(GestionVector.vParapente.get(j).getMarque()+" / "+GestionVector.vParapente.get(j).getPoid_maxi()+" Kg");
				}
		try{
			clientsCombo.setSelectedIndex(0);
			CreateVol.this.licenceTextField.setText(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNo_licence());
		}catch (IllegalArgumentException a){
			JOptionPane.showConfirmDialog(null,"Ajoutez des clients d'abords","Erreur aucun clients",JOptionPane.YES_OPTION);
		}

		this.clientsCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					CreateVol.this.licenceTextField.setText(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNo_licence());
				}
			}
		});

		parapenteCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					if(e.getStateChange() == ItemEvent.SELECTED){
						if(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getPoid() >= Integer.parseInt(GestionVector.vParapente.get(parapenteCombo.getSelectedIndex()).getPoid_maxi())){
							JOptionPane.showMessageDialog(null,"Poid non suporté","Trop lourd",JOptionPane.ERROR_MESSAGE);
							parapenteCombo.setSelectedIndex(-1);

						}
					}
				}
			}
		});

		OKButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomS = GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNom();
				licenceS = GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNo_licence();
				jourS = jourTextField.getText();
				moisS = moisTextField.getText();
				anneeS = anneeTextField.getText();
				departS = departTextField.getText();
				arriveS = arriveTextField.getText();
				Parapente para = GestionVector.vParapente.get(parapenteCombo.getSelectedIndex());
				if(!passagerCheckBox.isSelected()){
					GestionVector.vGestionVol.add(new GestionVol(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()),para,new Vol(departS,arriveS,new GregorianCalendar(Integer.parseInt(anneeS),Integer.parseInt(moisS)-1,Integer.parseInt(jourS)))));
				}
				else{
					GestionVector.vGestionVol.add(new GestionVol(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()),true,para,new Vol(departS,arriveS,new GregorianCalendar(Integer.parseInt(anneeS),Integer.parseInt(moisS)-1,Integer.parseInt(jourS)))));
				}
				g.createVolTable(0);
				dispose();
			}
		});
	}

	public void addComponentFilledWithValues(){

				for(int i = 0; i < GestionVector.vPersonne.size(); i++){
					clientsCombo.addItem(GestionVector.vPersonne.get(i).getNom()+" / "+GestionVector.vPersonne.get(i).getPoid()+" Kg");
				}
				for(int j = 0; j < GestionVector.vParapente.size(); j++){
					parapenteCombo.addItem(GestionVector.vParapente.get(j).getMarque()+" / "+GestionVector.vParapente.get(j).getPoid_maxi()+" Kg");
				}
		CreateVol.this.clientsCombo.setSelectedIndex(GestionVector.vPersonne.indexOf(gestTion.get_pilote()));
		CreateVol.this.licenceTextField.setText(gestTion.get_pilote().getNo_licence());
		this.clientsCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					CreateVol.this.licenceTextField.setText(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNo_licence());
				}
			}
		});

		CreateVol.this.parapenteCombo.setSelectedIndex(GestionVector.vParapente.indexOf(gestTion.get_parapente()));
		parapenteCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					if(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getPoid() >= Integer.parseInt(GestionVector.vParapente.get(parapenteCombo.getSelectedIndex()).getPoid_maxi())){
						JOptionPane.showMessageDialog(null,"Poid non suporté","Trop lourd",JOptionPane.ERROR_MESSAGE);
						parapenteCombo.setSelectedIndex(-1);

					}
				}
			}
		});
		this.jourTextField.setText(Integer.toString(gestTion.get_vol().getJourVol()));
		this.moisTextField.setText(Integer.toString(gestTion.get_vol().getMoisVol()));
		this.anneeTextField.setText(Integer.toString(gestTion.get_vol().getAnneeVol()));
		this.departTextField.setText(gestTion.get_vol().getSite_depart());
		this.arriveTextField.setText(gestTion.get_vol().getSite_arrive());
		if(gestTion.getPassager().equals("Oui")){
			this.passagerCheckBox.setSelected(true);
		}
		else {
			this.passagerCheckBox.setSelected(false);
		}

		OKButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomS = GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNom();
				licenceS = GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()).getNo_licence();
				jourS = jourTextField.getText();
				moisS = moisTextField.getText();
				anneeS = anneeTextField.getText();
				departS= departTextField.getText();
				arriveS= arriveTextField.getText();
				Parapente para = GestionVector.vParapente.get(clientsCombo.getSelectedIndex());
				if(!passagerCheckBox.isSelected()){
					GestionVol gest = new GestionVol(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()),para,new Vol(departS,arriveS,new GregorianCalendar(Integer.parseInt(anneeS),Integer.parseInt(moisS)-1,Integer.parseInt(jourS))));
					if(isEdited == 1){
						GestionVector.vGestionVol.removeElement(gestTion);
						GestionVector.vGestionVol.add(index,gest);
					}
					else{
						GestionVector.vGestionVol.addElement(gest);
					}
				}
				else{
					GestionVol gest = new GestionVol(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()),true,para,new Vol(departS,arriveS,new GregorianCalendar(Integer.parseInt(anneeS),Integer.parseInt(moisS)-1,Integer.parseInt(jourS))));
					if(isEdited == 1){
						GestionVector.vGestionVol.removeElement(gestTion);
						GestionVector.vGestionVol.add(index,gest);
					}
					else{
						GestionVector.vGestionVol.addElement(new GestionVol(GestionVector.vPersonne.get(clientsCombo.getSelectedIndex()),true,para,new Vol(departS,arriveS,new GregorianCalendar(Integer.parseInt(anneeS),Integer.parseInt(moisS)-1,Integer.parseInt(jourS)))));
					}
				}


				g.createVolTable(0);
				dispose();
			}
		});
	}

	public class CloseButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}


}
