import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JTable Vols;
    private JTable clients;
    private JPopupMenu ajouterPopup;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;

    private static String[] columnNames = {"Nom", "Pr\u00e9nom", "Adresse", "Ville", "CP", "Poid", "Taille", "T\u00e9l\u00e9phone", "Licence", "Niveau"};

    public GUIprincipal() {
        super("heelo world");
        ajouterPopup = new JPopupMenu();
        menuItem1 = new JMenuItem("Ajouter un Pilote");
        menuItem1.addActionListener(new JButtonListener());
        menuItem2 = new JMenuItem("Ajouter un Parapente");
        menuItem2.addActionListener(new JButtonListener());
        ajouterPopup.add(menuItem1);
        ajouterPopup.add(menuItem2);


        this.setContentPane(rootPane);

        this.setMinimumSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        createUIComponents();
        this.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        tabbedPane1.setBorder(null);
        Vector<Pilote> p;
        p = GestionVector.getvPersonne();
        int tailleTab = GestionVector.getvPersonne().size();
        int tailleCol = columnNames.length;
        Object dataClient[][] = new Object[tailleTab][tailleCol];

        for (int i = 0; i < tailleTab; i++) {
            Pilote pers = p.get(i);
            dataClient[i][0] = pers.getNom();
            dataClient[i][1] = pers.getPrenom();
            dataClient[i][2] = pers.getAdresse();
            dataClient[i][3] = pers.getVille();
            dataClient[i][4] = pers.getCode_postal();
            dataClient[i][5] = pers.getPoid();
            dataClient[i][6] = pers.getTaille();
            dataClient[i][7] = pers.getNo_telephone();
            dataClient[i][8] = pers.getNo_licence();
            dataClient[i][9] = pers.getNiveau();
        }

        clients = new JTable(dataClient, columnNames);
        clients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel listSelectionModel = clients.getSelectionModel();
        listSelectionModel.addListSelectionListener(new JButtonListener());
        clients.setSelectionModel(listSelectionModel);
        clients.getTableHeader().setReorderingAllowed(false);
        clients.getTableHeader().setResizingAllowed(false);
        clients.setAutoCreateRowSorter(true);
        ajouterButton.addActionListener(new JButtonListener());
        fermerButton.addActionListener(new JButtonListener());
    }

    public class JButtonListener implements ActionListener, ListSelectionListener {
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
                new CreatePersonne();
            } else if (e.getSource() == ajouterButton) {
                ajouterPopup.show(ajouterButton, ajouterButton.getWidth() / 2, ajouterButton.getHeight() / 2);
            } else if (e.getSource() == modifierButton || e.getSource() == supprimerButton) {
                int i = Integer.parseInt((String) clients.getValueAt(clients.getSelectedRow(), 0));
                Pilote p = GestionVector.getvPersonne().get(i - 1);
                if (e.getSource() == modifierButton) {
                    //GestionVector.ouvrirFenetreModifierClient(p);
                }
            }

        }


    }

}


