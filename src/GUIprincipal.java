import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by deodexed on 02/11/2015.
 * Project name GestParapente
 */
public class GUIprincipal extends JFrame {
    private JTable nomTable;
    private JButton ajouterButton;
    private JPanel rootPane;
    private JPanel leftPanel;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton fermerButton;
    private JTabbedPane tabbedPane1;
    private JLabel nbClient;
    private JLabel nbVols;
    private JLabel nbParapente;
	private JButton commencerButton;
	private JButton arreterButton;
	private JPopupMenu ajouterPopup;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JLabel nothingInVector;
    private ClientsTable tableClient;


    private String[] columnNames ={"Nom", "Pr\u00e9nom", "Adresse", "Ville", "CP", "Poid", "Taille", "T\u00e9l\u00e9phone", "Licence", "Niveau"};
	private String[] columnNamesVols = {"Nom","Licence","Date","Depart","Arrive","Passager"};
	private String[] columnNamesParapentes = {"Marque","Modele","Matricule","Poid max","Taille voile"};
    private Vector<String> data;
    private Vector<Pilote> p;
    private Vector<Vector<Pilote>> vPilote;
    private JTable clients;
    private JTable vols;
	private JTable parapente;
    private DefaultTableModel model;
    private DefaultTableModel modelVol;
	private DefaultTableModel modelParapente;
    private JScrollPane spVols;
	private JScrollPane spClients;
	private JScrollPane spParapentes;

	private JTextField searchTextField;

	private Vector<TempsEcouleVector> tempsEcouleVectors;

	Vector<GestionVol> enCours;


    public GUIprincipal() {
        super("heelo world");
	    tempsEcouleVectors = new Vector<>();
		searchTextField = new JTextField();
	    nothingInVector = new JLabel("Aucun client");
        ajouterPopup = new JPopupMenu();
        menuItem1 = new JMenuItem("Ajouter un Pilote");
        menuItem1.addActionListener(new JButtonListener());
        menuItem2 = new JMenuItem("Ajouter un Vol");
        menuItem2.addActionListener(new JButtonListener());
	    menuItem3 = new JMenuItem("Ajouter un Parapente");
	    menuItem3.addActionListener(new JButtonListener());
        ajouterPopup.add(menuItem1);
        ajouterPopup.add(menuItem2);
	    ajouterPopup.add(menuItem3);


        this.setContentPane(rootPane);

        nothingInVector.setVisible(false);
        this.setMinimumSize(new Dimension(1366, 768));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        tabbedPane1.add("Vols", spVols);
        tabbedPane1.add("Clients", spClients);
	    tabbedPane1.add("Parapentes", spParapentes);
        this.createUIComponents();
        this.createVolTable(0);
        this.createTableClient(0);
	    this.createParapenteTable(0);
        supprimerButton.setEnabled(false);
        modifierButton.setEnabled(false);

        pack();

    }

    public void createUIComponents() {
        tabbedPane1.setBorder(null);
        ajouterButton.addActionListener(new JButtonListener());
        modifierButton.addActionListener(new JButtonListener());
        supprimerButton.addActionListener(new JButtonListener());
        fermerButton.addActionListener(new JButtonListener());
	    commencerButton.addActionListener(new JButtonListener());
	    arreterButton.addActionListener(new JButtonListener());
	    commencerButton.setEnabled(false);
	    arreterButton.setEnabled(false);
    }


    public void createTableClient(int whoCalled){
        int tailleTab = GestionVector.vPersonne.size();
        int tailleCol = columnNames.length;
        Object dataClient[][] = new Object[tailleTab][tailleCol];

        for (int i=0; i<tailleTab; i++){
           Pilote p= GestionVector.vPersonne.get(i);
            dataClient[i][0] = p.getNom();
            dataClient[i][1] = p.getPrenom();
            dataClient[i][2] = p.getAdresse();
            dataClient[i][3] = p.getVille();
            dataClient[i][4] = p.getCode_postal();
            dataClient[i][5] = p.getPoid();
            dataClient[i][6] = p.getTaille();
            dataClient[i][7] = p.getNo_telephone();
            dataClient[i][8] = p.getNo_licence();
            dataClient[i][9] = p.getNiveau();
        }
        model = new DefaultTableModel(dataClient,columnNames);

        clients = new JTable(model);

        clients.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListSelectionModel listSelectionModel = clients.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (clients.getSelectedRow() != -1) {
                    supprimerButton.setEnabled(true);
                    modifierButton.setEnabled(true);
                } else {
                    supprimerButton.setEnabled(false);
                    modifierButton.setEnabled(false);
                }
            }
        });
        clients.setSelectionModel(listSelectionModel);
        clients.getTableHeader().setReorderingAllowed(false);
        clients.getTableHeader().setResizingAllowed(false);
        clients.setAutoCreateRowSorter(true);
        clients.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);



        spClients =  new JScrollPane(clients);
        tabbedPane1.removeTabAt(tabbedPane1.indexOfTab("Clients"));
        tabbedPane1.add(spClients,"Clients",1);
        switch (whoCalled){
            case 0: tabbedPane1.setSelectedIndex(0);
                break;
            case 1: tabbedPane1.setSelectedIndex(1);
                break;
            case 2: tabbedPane1.setSelectedIndex(2);
        }

        this.nbClient.setText("Nombre de Clients: "+GestionVector.vPersonne.size());
        this.nbVols.setText("Nombre de Vols: "+GestionVector.vGestionVol.size());
        this.nbParapente.setText("Nombre de Parapentes: "+GestionVector.vParapente.size());



    }

    public void createVolTable(int whoCalled){
        int tailleTab = GestionVector.vGestionVol.size();
        int tailleCol = columnNamesVols.length;
        Object dataVol[][] = new Object[tailleTab][tailleCol];

        for (int i=0; i<tailleTab; i++){
            GestionVol p = GestionVector.vGestionVol.get(i);
            dataVol[i][0] = p.get_pilote().getNom();
	        dataVol[i][1] = p.get_pilote().getNo_licence();
            dataVol[i][2] = p.get_vol().getJourVol()+"/"+(p.get_vol().getMoisVol())+"/"+p.get_vol().getAnneeVol();
            dataVol[i][3] = p.get_vol().getSite_depart();
            dataVol[i][4] = p.get_vol().getSite_arrive();
            dataVol[i][5] = p.getPassager();
        }
        modelVol = new DefaultTableModel(dataVol,columnNamesVols);


        vols = new JTable(modelVol);


        vols.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListSelectionModel listSelectionModel = vols.getSelectionModel();


        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (vols.getSelectedRow() != -1) {
                    supprimerButton.setEnabled(true);
                    modifierButton.setEnabled(true);
	                commencerButton.setEnabled(true);
	                arreterButton.setEnabled(true);
                } else {
                    supprimerButton.setEnabled(false);
                    modifierButton.setEnabled(false);
	                commencerButton.setEnabled(false);
	                arreterButton.setEnabled(false);
                }
            }
        });
        vols.setSelectionModel(listSelectionModel);
        vols.getTableHeader().setReorderingAllowed(false);
        vols.getTableHeader().setResizingAllowed(false);
        vols.setAutoCreateRowSorter(true);
        vols.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);




        spVols =  new JScrollPane(vols);
        tabbedPane1.removeTabAt(tabbedPane1.indexOfTab("Vols"));
        tabbedPane1.add(spVols,"Vols", 0);
        switch (whoCalled){
            case 0: tabbedPane1.setSelectedIndex(0);
                break;
            case 1: tabbedPane1.setSelectedIndex(1);
                break;
            case 2: tabbedPane1.setSelectedIndex(2);
        }



        this.nbClient.setText("Nombre de Clients: "+GestionVector.vPersonne.size());
        this.nbVols.setText("Nombre de Vols: "+GestionVector.vGestionVol.size());
        this.nbParapente.setText("Nombre de Parapentes: "+GestionVector.vParapente.size());
    }

	public void createParapenteTable(int whoCalled){
		int tailleTab = GestionVector.vParapente.size();
		int tailleCol = columnNamesParapentes.length;
		Object dataParapente[][] = new Object[tailleTab][tailleCol];

		for (int i=0; i<tailleTab; i++){
			Parapente p = GestionVector.vParapente.get(i);
			dataParapente[i][0] = p.getMarque();
			dataParapente[i][1] = p.getModele();
            dataParapente[i][2] = "000"+p.getNo_immatriculation();
            dataParapente[i][3] = p.getPoid_maxi();
            dataParapente[i][4] = p.getTaille_voile();
		}
		modelParapente = new DefaultTableModel(dataParapente,columnNamesParapentes);

		parapente = new JTable(modelParapente);

		parapente.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		ListSelectionModel listSelectionModel = parapente.getSelectionModel();


		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (parapente.getSelectedRow() != -1) {
					supprimerButton.setEnabled(true);
					modifierButton.setEnabled(true);
				} else {
					supprimerButton.setEnabled(false);
					modifierButton.setEnabled(false);
				}
			}
		});
		parapente.setSelectionModel(listSelectionModel);
		parapente.getTableHeader().setReorderingAllowed(false);
		parapente.getTableHeader().setResizingAllowed(false);
		parapente.setAutoCreateRowSorter(true);
		parapente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);




		spParapentes =  new JScrollPane(parapente);
		tabbedPane1.removeTabAt(tabbedPane1.indexOfTab("Parapentes"));
		tabbedPane1.add("Parapentes", spParapentes);
		switch (whoCalled){
			case 0: tabbedPane1.setSelectedIndex(0);
				break;
			case 1: tabbedPane1.setSelectedIndex(1);
				break;
			case 2: tabbedPane1.setSelectedIndex(2);
		}


		this.nbClient.setText("Nombre de Clients: "+GestionVector.vPersonne.size());
		this.nbVols.setText("Nombre de Vols: "+GestionVector.vGestionVol.size());
		this.nbParapente.setText("Nombre de Parapentes: "+GestionVector.vParapente.size());
	}

    public class JButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fermerButton) {
                try {
                    GestionVector.initOutPutFile();
                    GestionVector.writeAllVector();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(EXIT_ON_CLOSE);
            } else if(e.getSource() == commencerButton && commencerButton.isEnabled()){
	            SimpleDateFormat spt = new SimpleDateFormat("hh:mm");
	            Date date = new Date();
	            boolean trouve = false;
	            TempsEcouleVector t = new TempsEcouleVector(GestionVector.vGestionVol.get(vols.getSelectedRow()),date);
	            int i = JOptionPane.showConfirmDialog(null,"Commencer cette session ?","Session"+", "+new Date(),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	            if(i==JOptionPane.YES_OPTION){
		            for (int j = 0; i<tempsEcouleVectors.size(); i++){
			            if(tempsEcouleVectors.get(j).getGestionVols().get_pilote().getNo_licence().equals(GestionVector.vGestionVol.get(vols.getSelectedRow()).get_pilote().getNo_licence())){
			                trouve = true;
			            }
		            }
		            if(trouve==false){
			            tempsEcouleVectors.addElement(t);
		            }
		            else JOptionPane.showMessageDialog(null,"Session déjà active depuis"+ tempsEcouleVectors.get(tempsEcouleVectors.indexOf(t)).getDate().getTime());
	            }

            } else if(e.getSource() == arreterButton && arreterButton.isEnabled()){


            }

            else if (e.getSource() == menuItem1) {
                new CreatePersonne(GUIprincipal.this);
            } else if(e.getSource() == menuItem2){
	           new CreateVol(GUIprincipal.this);
            } else if(e.getSource() == menuItem3){
	          new CreateParapente(GUIprincipal.this);
            } else if (e.getSource() == ajouterButton) {
                ajouterPopup.show(ajouterButton, ajouterButton.getWidth() / 2, ajouterButton.getHeight() / 2);
            } else if (e.getSource() == modifierButton || e.getSource() == supprimerButton) {

	            if(e.getSource() == modifierButton && tabbedPane1.getSelectedIndex() == 0){
		            int i = vols.getSelectedRow();
		            new CreateVol(GUIprincipal.this,GestionVector.vGestionVol.get(i),1,GestionVector.vGestionVol.indexOf(GestionVector.vGestionVol.get(i)));
		            GUIprincipal.this.modifierButton.setEnabled(false);
		            GUIprincipal.this.supprimerButton.setEnabled(false);
	            }
	            else if (e.getSource() == modifierButton && tabbedPane1.getSelectedIndex() == 1) {
	                int i = clients.getSelectedRow();
	                new CreatePersonne(GUIprincipal.this,GestionVector.vPersonne.get(i),1,GestionVector.vPersonne.indexOf(GestionVector.vPersonne.get(i)));
                    GUIprincipal.this.modifierButton.setEnabled(false);
                    GUIprincipal.this.supprimerButton.setEnabled(false);
                }

                else if(e.getSource() == modifierButton && tabbedPane1.getSelectedIndex() == 2){
	                Parapente para = GestionVector.vParapente.get(parapente.getSelectedRow());
	                new CreateParapente(GUIprincipal.this,para,1,GestionVector.vParapente.indexOf(para));
	                GUIprincipal.this.modifierButton.setEnabled(false);
	                GUIprincipal.this.supprimerButton.setEnabled(false);
                }


	            else if(e.getSource()==supprimerButton && tabbedPane1.getSelectedIndex() == 0){
		            int[] j = vols.getSelectedRows();
		            Vector<GestionVol> indexToDelete = new Vector<>();
		            for(int k = 0; k  < j.length; k++){
			            indexToDelete.add(GestionVector.vGestionVol.get(j[k]));
		            }
		            GestionVector.vGestionVol.removeAll(indexToDelete);
		            GUIprincipal.this.createVolTable(0);
		            GUIprincipal.this.modifierButton.setEnabled(false);
		            GUIprincipal.this.supprimerButton.setEnabled(false);
	            }

	            else if(e.getSource()==supprimerButton && tabbedPane1.getSelectedIndex() == 1){
                    int[] j = clients.getSelectedRows();
                    Vector<Pilote> indexToDelete = new Vector<>();
                    for(int k = 0; k  < j.length; k++){
                        indexToDelete.add(GestionVector.vPersonne.get(j[k]));
                    }
                    GestionVector.vPersonne.removeAll(indexToDelete);
                    GUIprincipal.this.createTableClient(1);
                    GUIprincipal.this.modifierButton.setEnabled(false);
                    GUIprincipal.this.supprimerButton.setEnabled(false);
                }

                else if(e.getSource()==supprimerButton && tabbedPane1.getSelectedIndex() == 2){
	                int[] j = parapente.getSelectedRows();
	                Vector<Parapente> indexToDelete = new Vector<>();
	                for(int k = 0; k  < j.length; k++){
		                indexToDelete.add(GestionVector.vParapente.get(j[k]));
	                }
	                GestionVector.vParapente.removeAll(indexToDelete);
	                GUIprincipal.this.createParapenteTable(2);
	                GUIprincipal.this.modifierButton.setEnabled(false);
	                GUIprincipal.this.supprimerButton.setEnabled(false);
                }

            }

        }


    }

}


