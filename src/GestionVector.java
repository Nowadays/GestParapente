import java.util.Vector;

/**
 * Created by Morgan on 15/10/2015.
 * Project name : GestParapente.
 */
public class GestionVector {

    private Vector<Parapente> vParapente;
    private Vector<Personne> vPersonne;
    private Vector<Vol> vVol;

    public GestionVector(){
        vParapente = new Vector<>();
        vPersonne = new Vector<>();
        vVol = new Vector<>();
    }

    public Vector<Parapente> getvParapente(){
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
    }
}
