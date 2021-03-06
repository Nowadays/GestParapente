import java.io.*;
import java.util.Vector;

/**
 * Created by Morgan on 15/10/2015.
 * Project name : GestParapente.
 */
public class GestionVector{

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
    public static Vector<Pilote> vPersonne;
    public static Vector<Vol> vVol;
    public static Vector<GestionVol> vGestionVol;

    public static boolean initiated = false;

    public GestionVector() throws IOException {
        vParapente = new Vector<>();
        vPersonne = new Vector<Pilote>();
        vVol = new Vector<>();
        vGestionVol = new Vector<>();
    }

    public static Vector<Parapente> getvParapente(){
        return vParapente;
    }

    public static Vector<Pilote> getvPersonne(){
        return vPersonne;
    }

    public static Vector<Vol> getvVol(){
        return vVol;
    }

    public static Vector<GestionVol> getvGestionVol(){
        return vGestionVol;
    }

    public static void addInvPersonne(Pilote p){
        vPersonne.add(p);
    }

    public static void addInvParapente(Parapente p){
        vParapente.add(p);
    }

    public static void addInvVol(Vol v){
        vVol.add(v);
    }

    public static void addInvGestionVol(GestionVol g){
        vGestionVol.add(g);
    }

    public static void removeInvPersonne(Personne p){
        vPersonne.remove(p);
    }

    public static void removeInvParapente(Parapente p){
        vParapente.remove(p);
    }

    public static void removeInvVol(Vol v){
        vVol.remove(v);
    }

    public static void setVectorParapente(Vector<Parapente> parapentes){
        vParapente = parapentes;
    }

    public static void setVectorPersonne(Vector<Pilote> personnes){
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
        vPersonne = (Vector<Pilote>)personneIn.readObject();
        vVol = (Vector<Vol>)volIn.readObject();
        vGestionVol = (Vector<GestionVol>)gestionVolIn.readObject();
    }
}
