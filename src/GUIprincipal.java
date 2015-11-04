import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
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
    private JTable clients;
    private JPanel clientsPanel;
    private JPanel volsPanel;
    private JPopupMenu ajouterPopup;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JLabel nothingInVector;

    private static String[] columnNames = {"Nom", "Pr\u00e9nom", "Adresse", "Ville", "CP", "Poid", "Taille", "T\u00e9l\u00e9phone", "Licence", "Niveau"};

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
        clientsPanel.add(nothingInVector);
        this.setMinimumSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.createUIComponents();

    }

    public void createUIComponents() {
        tabbedPane1.setBorder(null);


        ajouterButton.addActionListener(new JButtonListener());
        fermerButton.addActionListener(new JButtonListener());
        clientsPanel.add(clients);
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
                new CreatePersonne();
            } else if (e.getSource() == ajouterButton) {
                ajouterPopup.show(ajouterButton, ajouterButton.getWidth() / 2, ajouterButton.getHeight() / 2);
            } else if (e.getSource() == modifierButton || e.getSource() == supprimerButton) {
                int i = Integer.parseInt((String) clients.getValueAt(clients.getSelectedRow(), 0));
                Pilote p = GestionVector.getvPersonne().get(i);
                if (e.getSource() == modifierButton) {
                    //GestionVector.ouvrirFenetreModifierClient(p);
                }
            }

        }


    }

}


