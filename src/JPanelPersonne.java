import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * Created by Morgan on 28/10/2015.
 * Project name : GestParapente.
 */
public class JPanelPersonne extends JDialog {


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



    private JLabel nom;
    private JLabel prenom;
    private JLabel civilite;
    private JLabel numero;
    private JLabel adresse;
    private JLabel codePostal;
    private JLabel ville;
    private JLabel noLicence;

    private JTextField saisieNom;
    private JTextField saisiePrenom;
    private JTextField saisieNumero;
    private JTextField saisieAdresse;
    private JTextField saisieCodePostal;
    private JTextField saisieVille;
    private JTextField saisieNoLicence;

    private String name;
    private String fname;
    private String civility;
    private String phone;
    private String adress;
    private String city;
    private int code;

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


    public JPanelPersonne(){
        this.setTitle("Ajouter un client");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.createGUI();
    }

    public void createGUI(){
        //saisie
        civilite = new JLabel("Civilit\u00e9 : ");
        civilite.setForeground(new Color(0x9E9E9E));
        mapCivilite = new HashMap<Integer,String>();
        mapCivilite.put(0,"M.");
        mapCivilite.put(1,"Mlle");
        mapCivilite.put(2,"Mme");
        choix1=mapCivilite.get(0);
        choix2=mapCivilite.get(1);
        choix3=mapCivilite.get(2);
        choixCivilite=new JComboBox();
        choixCivilite.setPreferredSize(new Dimension(60,20));
        choixCivilite.setMaximumSize(new Dimension(60,20));
        choixCivilite.addItem(choix1);
        choixCivilite.addItem(choix2);
        choixCivilite.addItem(choix3);
        choixCivilite.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    switch (choixCivilite.getSelectedIndex()){
                        case 0: civility = mapCivilite.get((Integer) 0);
                            break;
                        case 1: civility = mapCivilite.get((Integer) 1);
                            break;
                        case 2: civility = mapCivilite.get((Integer) 2);
                            break;
                    }
                }
            }
        });



        panelCivilite = new JPanel();
        panelCivilite.setLayout(new BoxLayout(panelCivilite, BoxLayout.X_AXIS));
        panelCivilite.add(civilite);
        panelCivilite.add(choixCivilite);
        panelCivilite.setBackground(new Color(0x424242));

        numero = new JLabel("Num\u00e9ro de tel. (*) : ");
        numero.setForeground(new Color(0x9E9E9E));
        saisieNumero = new JTextField();
        saisieNumero.setPreferredSize(new Dimension(120,20));
        saisieNumero.setBorder(null);
        saisieNumero.setBackground(new Color(0xBDBDBD));
        saisieNumero.addKeyListener(new MyListener());

        panelNumero = new JPanel();
        panelNumero.setLayout(new BoxLayout(panelNumero, BoxLayout.X_AXIS));
        panelNumero.add(numero);
        panelNumero.add(saisieNumero);
        panelNumero.setBackground(new Color(0x424242));

        panelCivNum = new JPanel();
        panelCivNum.setLayout(new BoxLayout(panelCivNum, BoxLayout.X_AXIS));
        panelCivNum.add(panelCivilite);
        panelCivNum.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelCivNum.add(panelNumero);
        panelCivNum.setBackground(new Color(0x424242));

        nom = new JLabel("Nom (*) : ");
        nom.setForeground(new Color(0x9E9E9E));
        saisieNom = new JTextField();
        saisieNom.setPreferredSize(new Dimension(120,20));
        saisieNom.addKeyListener(new MyListener());
        saisieNom.setBorder(null);
        saisieNom.setBackground(new Color(0xBDBDBD));

        panelSaisieNom = new JPanel();
        panelSaisieNom.setLayout(new BoxLayout(panelSaisieNom, BoxLayout.X_AXIS));
        panelSaisieNom.add(nom);
        panelSaisieNom.add(saisieNom);
        panelSaisieNom.setBackground(new Color(0x424242));

        prenom = new JLabel("Pr\u00e9nom (*) : ");
        prenom.setForeground(new Color(0x9E9E9E));
        saisiePrenom = new JTextField();
        saisiePrenom.setPreferredSize(new Dimension(120,20));
        saisiePrenom.addKeyListener(new MyListener());
        saisiePrenom.setBorder(null);
        saisiePrenom.setBackground(new Color(0xBDBDBD));

        panelSaisiePrenom = new JPanel();
        panelSaisiePrenom.setLayout(new BoxLayout(panelSaisiePrenom, BoxLayout.X_AXIS));
        panelSaisiePrenom.add(prenom);
        panelSaisiePrenom.add(saisiePrenom);
        panelSaisiePrenom.setBackground(new Color(0x424242));

        adresse = new JLabel("Adresse (*) : ");
        adresse.setForeground(new Color(0x9E9E9E));
        saisieAdresse = new JTextField();
        saisieAdresse.setPreferredSize(new Dimension(120,20));
        saisieAdresse.addKeyListener(new MyListener());
        saisieAdresse.setBorder(null);
        saisieAdresse.setBackground(new Color(0xBDBDBD));

        panelAdresse = new JPanel();
        panelAdresse.setLayout(new BoxLayout(panelAdresse, BoxLayout.X_AXIS));
        panelAdresse.add(adresse);
        panelAdresse.add(saisieAdresse);
        panelAdresse.setBackground(new Color(0x424242));

        codePostal = new JLabel("Code postal (*) : ");
        codePostal.setForeground(new Color(0x9E9E9E));
        saisieCodePostal = new JTextField();
        saisieCodePostal.setPreferredSize(new Dimension(50,20));
        saisieCodePostal.setBorder(null);
        saisieCodePostal.setBackground(new Color(0xBDBDBD));
        saisieCodePostal.addKeyListener(new MyListener());

        panelCP = new JPanel();
        panelCP.setLayout(new BoxLayout(panelCP, BoxLayout.X_AXIS));
        panelCP.add(codePostal);
        panelCP.add(saisieCodePostal);
        panelCP.setBackground(new Color(0x424242));

        ville = new JLabel("Ville (*) : ");
        ville.setForeground(new Color(0x9E9E9E));
        saisieVille = new JTextField();
        saisieVille.setPreferredSize(new Dimension(120,20));
        saisieVille.setBorder(null);
        saisieVille.setBackground(new Color(0xBDBDBD));
        saisieVille.addKeyListener(new MyListener());

        panelVille = new JPanel();
        panelVille.setLayout(new BoxLayout(	panelVille, BoxLayout.X_AXIS));
        panelVille.add(ville);
        panelVille.add(saisieVille);
        panelVille.setBackground(new Color(0x424242));

        panelCPVille = new JPanel();
        panelCPVille.setLayout(new BoxLayout(panelCPVille, BoxLayout.X_AXIS));
        panelCPVille.add(panelCP);
        panelCPVille.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelCPVille.add(panelVille);
        panelCPVille.setBackground(new Color(0x424242));

        legende = new JLabel("(*) saisie obligatoire");
        legende.setForeground(new Color(0x9E9E9E));
        legende.setAlignmentX(Component.RIGHT_ALIGNMENT);


        //boutons
        bnOK = new JButton("OK");
        bnOK.setPreferredSize(new Dimension(80, 30));
        bnOK.addActionListener(new MyListener());
        bnOK.setEnabled(false);
        bnOK.setBackground(new Color(0x9E9E9E));
        bnOK.setForeground(new Color(0x616161));
        bnAnnuler = new JButton("Annuler");
        bnAnnuler.setPreferredSize(new Dimension(80, 30));
        bnAnnuler.addActionListener(new MyListener());
        bnAnnuler.setBackground(new Color(0x616161));
        bnAnnuler.setForeground(new Color(0x9E9E9E));
        panelBoutons = new JPanel();
        panelBoutons.add(legende);
        panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));
        panelBoutons.add(Box.createHorizontalGlue());
        panelBoutons.add(bnOK);
        panelBoutons.add(Box.createRigidArea(new Dimension(ESPACE,1)));
        panelBoutons.add(bnAnnuler);
        panelBoutons.setBackground(new Color(0x424242));

        //panel no licence

        noLicence = new JLabel("N° de licence (*): ");
        noLicence.setForeground(new Color(0x9E9E9E));

        saisieNoLicence = new JTextField();
        saisieNoLicence.setPreferredSize(new Dimension(120, 20));
        saisieNoLicence.addKeyListener(new MyListener());
        saisieNoLicence.setBorder(null);
        saisieNoLicence.setBackground(new Color(0xBDBDBD));

        panelNoLicence = new JPanel();
        panelNoLicence.setLayout(new BoxLayout(panelNoLicence,BoxLayout.X_AXIS));
        panelNoLicence.setBackground(new Color(0x424242));
        panelNoLicence.add(noLicence);
        panelNoLicence.add(saisieNoLicence);


        //panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelPrincipal.setBackground(new Color(0x424242));
        panelPrincipal.add(panelCivNum);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelSaisieNom);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelSaisiePrenom);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelAdresse);
        panelPrincipal.add(Box.createRigidArea(new Dimension(1,ESPACE)));
        panelPrincipal.add(panelCPVille);
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
                civility = mapCivilite.get(choixCivilite.getSelectedIndex());
                phone = saisieNumero.getText();
                adress = saisieAdresse.getText();
                city = saisieVille.getText();
                code = Integer.parseInt(saisieCodePostal.getText());
               /* Client c = new Client(name, fname, civility, adress, city, phone, code);
                Base base = Launcher.getBaseCamp();
                base.addClient(c);
                Launcher.setBaseCamp(base);*/
                dispose();
            }


        }

        public void keyTyped(KeyEvent e) {
            numero.setText(numeroDefault);
            codePostal.setText(codePostalDefault);
            try{
                if (!(saisieNumero.getText().equals(""))){
                    numero.setText(numeroDefault);
                    Integer.parseInt(saisieNumero.getText());
                    if(saisieNumero.getText().length()==9 && saisieNumero.hasFocus()){
                        saisieCodePostal.requestFocus();
                    }
                }


            }
            catch (NumberFormatException n){
                numero.setText("Entrez un num\u00e9ro de t\u00e9l\u00e9phone");
                //codePostal.setText("Entrez un entier");
            }

            try{
                if(!(saisieCodePostal.getText().equals(""))){
                    codePostal.setText(codePostalDefault);
                    Integer.parseInt(saisieCodePostal.getText());
                }
            }
            catch(NumberFormatException n){
                codePostal.setText("Entrez un code postal");
            }

            if(!((saisieNumero.getText().equals(""))||(saisieNom.getText().equals(""))||(saisiePrenom.getText().equals(""))||(saisieCodePostal.getText().equals(""))||(saisieAdresse.getText().equals(""))||(saisieVille.getText().equals("")))){
                bnOK.setBackground(new Color(0x616161));
                bnOK.setForeground(new Color(0x9E9E9E));
                bnOK.setEnabled(true);
            }
            else{
                bnOK.setBackground(new Color(0x9E9E9E));
                bnOK.setForeground(new Color(0x616161));
                bnOK.setEnabled(false);
            }
        }

        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {
            //changed();


        }


       /*public void changed() {
            int i = 0;
            if((saisieNumero.getText().equals(""))|(saisieNom.getText().equals(""))|(saisiePrenom.getText().equals(""))|(saisieCodePostal.getText().equals(""))|(saisieAdresse.getText().equals(""))|(saisieVille.getText().equals(""))){
                bnOK.setEnabled(false);
                numero.setText(numeroDefault);
            }else{
                try{
                    if (!(saisieNumero.getText().equals(""))|saisieCodePostal.getText().equals("")){
                        numero.setText(numeroDefault);

                        Integer.parseInt(saisieNumero.getText());
                        Integer.parseInt(saisieCodePostal.getText());
                        if(!((saisieNumero.getText().equals(""))|(saisieNom.getText().equals(""))|(saisiePrenom.getText().equals(""))|(saisieCodePostal.getText().equals(""))|(saisieAdresse.getText().equals(""))|(saisieVille.getText().equals("")))){
                            bnOK.setEnabled(true);
                        }

                    }

                }
                catch (NumberFormatException n){
                    if(i==0){
                        numero.setText("Entrez un num\u00e9ro de t\u00e9l\u00e9phone");
                    }
                    if(i==1){
                        codePostal.setText("Entrez un entier");
                        i--;
                    }
                }

            }
        }*/

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
    public String getCivility(){
        return this.civility;
    }
    public String getAdress(){
        return this.adress;
    }
    public String getCity(){
        return this.city;
    }
    public int getCode(){
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




    public static void main(String[] args){
        new JPanelPersonne().setVisible(true);
    }

}
