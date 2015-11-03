import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * Created by Morgan on 28/10/2015.
 * Project name : GestParapente.
 */
public class CreatePersonne extends JDialog {


    private final int ESPACE=20;

    private boolean buttonPressed = false;

    private JPanel panelPrincipal;
    private JPanel panelCivilite;
    private JPanel panelNumero;
    private JPanel panelCivNum;
    private JPanel panelSaisieNom;
    private JPanel panelSaisiePrenom;
    private JPanel panelAdresse;
    private JPanel panelCP;
    private JPanel panelVille;
    private JPanel panelCPVille;
    private JPanel panelBoutons;
    private JPanel panelNoLicence;
    private JPanel panelTaillePoid;



    private JLabel nom;
    private JLabel prenom;
    private JLabel civilite;
    private JLabel numero;
    private JLabel adresse;
    private JLabel codePostal;
    private JLabel ville;
    private JLabel noLicence;
    private JLabel taille;
    private JLabel poid;
    private JLabel niveau;

    private JTextField saisieNom;
    private JTextField saisiePrenom;
    private JTextField saisieNumero;
    private JTextField saisieAdresse;
    private JTextField saisieCodePostal;
    private JTextField saisieVille;
    private JTextField saisieNoLicence;
    private JTextField saisieTaille;
    private JTextField saisiePoid;
    private JTextField saisieNiveau;

    private String name;
    private String fname;
    private String civility;
    private String phone;
    private String adress;
    private String city;
    private String level;
    private int height;
    private int weight;
    private String code;
    private String noLicenceS;

    private String choix1;
    private String choix2;
    private String choix3;

    private JComboBox choixCivilite;

    private HashMap<Integer,String> mapCivilite;

    private JLabel legende;

    private JButton bnOK;
    private JButton bnAnnuler;

    private final String numeroDefault = "Num\u00e9ro de tel. (*) : ";
    private final String codePostalDefault = "Code postal (*) : ";
    private final String noLicenceDefault = "Num de licence (*): ";

    private final static Color GREY_TEXT = new Color(0x9E9E9E);
    private final static Color GREY_BACKGROUND = new Color(0x616161);
    private final static Color GREY_TEXTFIELD = new Color(0xBDBDBD);




    public CreatePersonne(){
        this.setTitle("Ajouter un client");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.createGUI();
        this.setVisible(true);
    }

    public void createGUI(){
        //saisie

        numero = new JLabel("Num\u00e9ro de tel. (*) : ");
        saisieNumero = new JTextField();
        saisieNumero.setPreferredSize(new Dimension(120,20));
        saisieNumero.setBorder(null);
        saisieNumero.addKeyListener(new MyListener());

        panelNumero = new JPanel();
        panelNumero.setLayout(new BoxLayout(panelNumero, BoxLayout.X_AXIS));
        panelNumero.add(numero);
        panelNumero.add(saisieNumero);

        panelCivNum = new JPanel();
        panelCivNum.setLayout(new BoxLayout(panelCivNum, BoxLayout.X_AXIS));
        panelCivNum.add(panelNumero);

        nom = new JLabel("Nom (*) : ");
        saisieNom = new JTextField();
        saisieNom.setPreferredSize(new Dimension(120,20));
        saisieNom.addKeyListener(new MyListener());
        saisieNom.setBorder(null);
        saisieNom.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panelSaisieNom = new JPanel();
        panelSaisieNom.setLayout(new BoxLayout(panelSaisieNom, BoxLayout.X_AXIS));
        panelSaisieNom.add(nom);
        panelSaisieNom.add(saisieNom);

        prenom = new JLabel("Pr\u00e9nom (*) : ");
        saisiePrenom = new JTextField();
        saisiePrenom.setPreferredSize(new Dimension(120,20));
        saisiePrenom.addKeyListener(new MyListener());
        saisiePrenom.setBorder(null);
        saisiePrenom.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panelSaisiePrenom = new JPanel();
        panelSaisiePrenom.setLayout(new BoxLayout(panelSaisiePrenom, BoxLayout.X_AXIS));
        panelSaisiePrenom.add(prenom);
        panelSaisiePrenom.add(saisiePrenom);
        panelSaisiePrenom.setBackground(new Color(0x424242));

        adresse = new JLabel("Adresse (*) : ");
        saisieAdresse = new JTextField();
        saisieAdresse.setPreferredSize(new Dimension(120,20));
        saisieAdresse.addKeyListener(new MyListener());
        saisieAdresse.setBorder(null);

        panelAdresse = new JPanel();
        panelAdresse.setLayout(new BoxLayout(panelAdresse, BoxLayout.X_AXIS));
        panelAdresse.add(adresse);
        panelAdresse.add(saisieAdresse);
        panelAdresse.setBackground(new Color(0x424242));

        codePostal = new JLabel("Code postal (*) : ");
        saisieCodePostal = new JTextField();
        saisieCodePostal.setPreferredSize(new Dimension(50,20));
        saisieCodePostal.setBorder(null);
        saisieCodePostal.addKeyListener(new MyListener());

        panelCP = new JPanel();
        panelCP.setLayout(new BoxLayout(panelCP, BoxLayout.X_AXIS));
        panelCP.add(codePostal);
        panelCP.add(saisieCodePostal);

        ville = new JLabel("Ville (*) : ");
        saisieVille = new JTextField();
        saisieVille.setPreferredSize(new Dimension(50,20));
        saisieVille.setBorder(null);
        saisieVille.addKeyListener(new MyListener());

        panelVille = new JPanel();
        panelVille.setLayout(new BoxLayout(	panelVille, BoxLayout.X_AXIS));
        panelVille.add(ville);
        panelVille.add(saisieVille);

        panelCPVille = new JPanel();
        panelCPVille.setLayout(new BoxLayout(panelCPVille, BoxLayout.X_AXIS));
        panelCPVille.add(panelCP);
        panelCPVille.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelCPVille.add(panelVille);

        legende = new JLabel("(*) saisie obligatoire");
        legende.setAlignmentX(Component.RIGHT_ALIGNMENT);


        //boutons
        bnOK = new JButton("OK");
        bnOK.setPreferredSize(new Dimension(80, 30));
        bnOK.addActionListener(new MyListener());
        bnOK.setEnabled(false);
        bnAnnuler = new JButton("Annuler");
        bnAnnuler.setPreferredSize(new Dimension(80, 30));
        bnAnnuler.addActionListener(new MyListener());
        panelBoutons = new JPanel();
        panelBoutons.add(legende);
        panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));
        panelBoutons.add(Box.createHorizontalGlue());
        panelBoutons.add(bnOK);
        panelBoutons.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelBoutons.add(bnAnnuler);

        //panel no licence

        noLicence = new JLabel("Num de licence (*): ");
        niveau = new JLabel("Niveau (*): ");

        saisieNoLicence = new JTextField();
        saisieNoLicence.setPreferredSize(new Dimension(120, 20));
        saisieNoLicence.addKeyListener(new MyListener());
        saisieNoLicence.setBorder(null);
        saisieNiveau = new JTextField();
        saisieNiveau.setPreferredSize(new Dimension(50,20));
        saisieNiveau.addKeyListener(new MyListener());
        saisieNiveau.setBorder(null);


        panelNoLicence = new JPanel();
        panelNoLicence.setLayout(new BoxLayout(panelNoLicence,BoxLayout.X_AXIS));
        panelNoLicence.add(noLicence);
        panelNoLicence.add(saisieNoLicence);
        panelNoLicence.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelNoLicence.add(niveau);
        panelNoLicence.add(saisieNiveau);

        //panel poid taille
        taille = new JLabel("Taille (*): ");
        poid = new JLabel("Poid (*): ");
        saisieTaille = new JTextField();
        saisieTaille.setPreferredSize(new Dimension(30,20));
        saisieTaille.setBorder(null);
        saisiePoid = new JTextField();
        saisiePoid.setPreferredSize(new Dimension(30,20));
        saisiePoid.setBorder(null);
        panelTaillePoid = new JPanel();
        panelTaillePoid.setLayout(new BoxLayout(panelTaillePoid,BoxLayout.X_AXIS));
        panelTaillePoid.add(taille);
        panelTaillePoid.add(saisieTaille);
        panelTaillePoid.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelTaillePoid.add(poid);
        panelTaillePoid.add(saisiePoid);


        //panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelPrincipal.add(panelSaisieNom);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelSaisiePrenom);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelCivNum);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelAdresse);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelCPVille);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelTaillePoid);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelNoLicence);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelBoutons);



        this.setContentPane(panelPrincipal);
        this.pack();
    }
    public class MyListener implements ActionListener, KeyListener{


        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==bnAnnuler){
                dispose();
            }
            else if(e.getSource()==bnOK && bnOK.isEnabled()){
                name = saisieNom.getText();
                fname = saisiePrenom.getText();
                phone = saisieNumero.getText();
                adress = saisieAdresse.getText();
                city = saisieVille.getText();
                code = saisieCodePostal.getText();
                weight = Integer.parseInt(saisiePoid.getText());
                height = Integer.parseInt(saisieTaille.getText());
                level = saisieNiveau.getText();
                noLicenceS = saisieNoLicence.getText();
                GestionVector.addInvPersonne(new Pilote(name,fname,adress,city,code, weight,height,phone,noLicenceS,level));


                dispose();
            }


        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            Runnable switchToAdress = saisieAdresse::requestFocus;
            Runnable switchToVille = saisieVille::requestFocus;
            Runnable switchToPoid = saisiePoid::requestFocus;
            Runnable switchToNoLicence = saisieNoLicence::requestFocus;
            Runnable switchToNiveau = saisieNiveau::requestFocus;
            numero.setText(numeroDefault);
            codePostal.setText(codePostalDefault);
            noLicence.setText(noLicenceDefault);

            if((e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) && (e.getSource()==saisieNumero)) {
                numero.setText("Entrez un num\u00e9ro de t\u00e9l\u00e9phone");
            }
            else{
                if (!(saisieNumero.getText().equals(""))){
                    numero.setText(numeroDefault);
                    if(saisieNumero.getText().length()==9 && saisieNumero.hasFocus()){
                        SwingUtilities.invokeLater(switchToAdress);
                    }

                }
            }


            //codePostal.setText("Entrez un entier");


            if((e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) && (e.getSource()==saisieCodePostal)) {
                codePostal.setText("Entrez un code postal");
            }
            else{
                if(!(saisieCodePostal.getText().equals(""))){
                    codePostal.setText(codePostalDefault);
                    if(saisieCodePostal.getText().length()==4 && saisieCodePostal.hasFocus()){
                        SwingUtilities.invokeLater(switchToVille);
                    }
                }
            }

            if(saisieTaille.getText().length()==2 && saisieTaille.hasFocus()){
                SwingUtilities.invokeLater(switchToPoid);
            }

            if(saisiePoid.getText().length()==2 && saisiePoid.hasFocus()){
                SwingUtilities.invokeLater(switchToNoLicence);
            }

            if((e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) && (e.getSource()==saisieNoLicence)) {
                noLicence.setText("Entrez un num de licence");
            }
            else{
                if(!(saisieNoLicence.getText().equals(""))){
                    noLicence.setText(noLicenceDefault);
                    if(saisieNoLicence.getText().length()==9 && saisieNoLicence.hasFocus()){
                        SwingUtilities.invokeLater(switchToNiveau);
                    }
                }
            }







            if(!(saisiePoid.getText().equals("") || saisieTaille.getText().equals("") || saisieNumero.getText().equals("")||
                    saisieNom.getText().equals("")||saisiePrenom.getText().equals("") ||(saisieCodePostal.getText().equals("")||
                    saisieAdresse.getText().equals(""))||saisieVille.getText().equals("")||saisieNoLicence.getText().equals("") ||
                    saisieNiveau.getText().equals("") || saisiePoid.getText().equals("") || saisieTaille.getText().equals(""))){
                bnOK.setBackground(GREY_BACKGROUND);
                bnOK.setForeground(GREY_TEXT);
                bnOK.setEnabled(true);
            } else{
                bnOK.setBackground(GREY_TEXT);
                bnOK.setForeground(GREY_BACKGROUND);
                bnOK.setEnabled(false);
            }
        }

        public void keyReleased(KeyEvent e) {

        }

    }


    public String getClientName(){
        return this.name;
    }
    public String getClientFname(){
        return this.fname;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getAdress(){
        return this.adress;
    }
    public String getCity(){
        return this.city;
    }
    public String getCode(){
        return this.code;
    }
    public boolean getButtonPressed(){
        return this.buttonPressed;
    }

    public void setElements(String n){
        saisieNom.setText(n);
        saisiePrenom.setText(n);
        saisieNumero.setText(n);
        saisieAdresse.setText(n);
        saisieCodePostal.setText(n);
        saisieVille.setText(n);
    }

    public void activeBoutonOK(boolean b){
        bnOK.setEnabled(b);
    }




   // public static void main(String[] args){
        //new CreatePersonne().setVisible(true);
   // }

}
