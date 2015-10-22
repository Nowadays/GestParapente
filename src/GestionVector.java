import java.io.*;
import java.util.Vector;

/**
 * Created by Morgan on 15/10/2015.
 * Project name : GestParapente.
 */
public abstract class GestionVector{

    public static final String nom_fichier_parapente="parapente.para";
    public static final String nom_fichier_personne="personne.para";
    public static final String nom_fichier_vol="vol.para";
    public static final String nom_fichier_gestion_vol="gestion_vol.para";

    public static ObjectOutputStream parapenteOut;
    public static ObjectOutputStream personneOut;
    public static ObjectOutputStream volOut;
    public static ObjectOutputStream gestionVolOut;

    public static ObjectInputStream parapenteIn;
    public static ObjectInputStream personneIn;
    public static ObjectInputStream volIn;
    public static ObjectInputStream gestionVolIn;

    public static Vector<Parapente> vParapente;
    public static Vector<Personne> vPersonne;
    public static Vector<Vol> vVol;
    public static Vector<GestionVol> vGestionVol;

    /*public GestionVector() throws IOException {
        vParapente = new Vector<>();
        vPersonne = new Vector<>();
        vVol = new Vector<>();


    }*/

    /*public Vector<Parapente> getvParapente(){
        return this.vParapente;
    }

    public Vector<Personne> getvPersonne(){
        return this.vPersonne;
    }

    public Vector<Vol> getvVol(){
        return this.vVol;
    }

    public void addInvPersonne(Personne p){
        this.vPersonne.add(p);
    }

    public void addInvParapente(Parapente p){
        this.vParapente.add(p);
    }

    public void addInvVol(Vol v){
        this.vVol.add(v);
    }

    public void removeInvPersonne(Personne p){
        this.vPersonne.remove(p);
    }

    public void removeInvParapente(Parapente p){
        this.vParapente.remove(p);
    }

    public void removeInvVol(Vol v){
        this.vVol.remove(v);
    }*/

    public static void setVectorParapente(Vector<Parapente> parapentes){
        vParapente = parapentes;
    }

    public static void setVectorPersonne(Vector<Personne> personnes){
        vPersonne = personnes;
    }

    public static void setVectorVol(Vector<Vol> vol){
        vVol = vol;
    }

    public static void setVectorGestionVol(Vector<GestionVol> gestionVol){
        vGestionVol = gestionVol;
    }

    public static void initOutPutFile() throws IOException {
        parapenteOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nom_fichier_parapente,false)));
        personneOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nom_fichier_personne,false)));
        volOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nom_fichier_vol,false)));
        gestionVolOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nom_fichier_gestion_vol,false)));
    }

    public static void initInputFile() throws IOException{
        parapenteIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nom_fichier_parapente)));
        personneIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nom_fichier_personne)));
        volIn = new ObjectInputStream((new BufferedInputStream(new FileInputStream(nom_fichier_vol))));
        gestionVolIn = new ObjectInputStream((new BufferedInputStream(new FileInputStream(nom_fichier_gestion_vol))));
    }

    public static void writeAllVector() throws IOException {
        try {
            parapenteOut.writeObject(vParapente);
            personneOut.writeObject(vPersonne);
            volOut.writeObject(vVol);
            gestionVolOut.writeObject(vGestionVol);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            parapenteOut.close();
            personneOut.close();
            volOut.close();
            gestionVolOut.close();
        }
    }

    public static void readAllVector() throws IOException, ClassNotFoundException {
        vParapente = (Vector<Parapente>)parapenteIn.readObject();
        vPersonne = (Vector<Personne>)personneIn.readObject();
        vVol = (Vector<Vol>)volIn.readObject();
        vGestionVol = (Vector<GestionVol>)gestionVolIn.readObject();
    }
}
