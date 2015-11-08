import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;

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
    private JPopupMenu ajouterPopup;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JLabel nothingInVector;
    private ClientsTable tableClient;


    private String[] columnNames ={"Nom", "Pr\u00e9nom", "Adresse", "Ville", "CP", "Poid", "Taille", "T\u00e9l\u00e9phone", "Licence", "Niveau"};
	private String[] columnNamesVols = {"Licence","Nom","Date","Depart","Arrive","Passager"};
    private Vector<String> data;
    private Vector<Pilote> p;
    private Vector<Vector<Pilote>> vPilote;
    private JTable clients;
    private JTable vols;
    private DefaultTableModel model;
    private DefaultTableModel modelVol;
    private JScrollPane spVols;
	private JScrollPane spClients;

    //private static String[] columnNames = {"Nom", "Pr\u00e9nom", "Adresse", "Ville", "CP", "Poid", "Taille", "T\u00e9l\u00e9phone", "Licence", "Niveau"};

    public GUIprincipal() {
        super("heelo world");
        nothingInVector = new JLabel("Aucun client");
        ajouterPopup = new JPopupMenu();
        menuItem1 = new JMenuItem("Ajouter un Pilote");
        menuItem1.addActionListener(new JButtonListener());
        menuItem2 = new JMenuItem("Ajouter un Parapente");
        menuItem2.addActionListener(new JButtonListener());
        ajouterPopup.add(menuItem1);
        ajouterPopup.add(menuItem2);


        this.setContentPane(rootPane);
        nothingInVector.setVisible(false);
        this.setMinimumSize(new Dimension(1366, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        tabbedPane1.add("Vols", spVols);
        tabbedPane1.add("Clients", spClients);
        this.createUIComponents();
        this.createVolTable(0);
        this.createTableClient(0);
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
        tabbedPane1.add("Clients", spClients);
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
            dataVol[i][0] = p.get_pilote().getNo_licence();
	        dataVol[i][2] = p.get_pilote().getNom();
           /* dataVol[i][3] =
            dataVol[i][4] =
            dataVol[i][5] =
            dataVol[i][6] =
            dataVol[i][7] =
            dataVol[i][8] =
            dataVol[i][9] =*/
        }
        model = new DefaultTableModel(dataVol,columnNames);

        vols = new JTable(model);

        vols.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListSelectionModel listSelectionModel = clients.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (vols.getSelectedRow() != -1) {
                    supprimerButton.setEnabled(true);
                    modifierButton.setEnabled(true);
                } else {
                    supprimerButton.setEnabled(false);
                    modifierButton.setEnabled(false);
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
        tabbedPane1.add("Vols", spVols);
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
            } else if (e.getSource() == menuItem1) {
                new CreatePersonne(GUIprincipal.this);
            } else if (e.getSource() == ajouterButton) {
                ajouterPopup.show(ajouterButton, ajouterButton.getWidth() / 2, ajouterButton.getHeight() / 2);
            } else if (e.getSource() == modifierButton || e.getSource() == supprimerButton) {
                int i = clients.getSelectedRow();
                Pilote p = GestionVector.getvPersonne().get(i);
                if (e.getSource() == modifierButton) {
                    new CreatePersonne(GUIprincipal.this,p,1,GestionVector.vPersonne.indexOf(p));
                    GUIprincipal.this.modifierButton.setEnabled(false);
                    GUIprincipal.this.supprimerButton.setEnabled(false);
                }
                else if(e.getSource()==supprimerButton){
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
            }

        }


    }

}


