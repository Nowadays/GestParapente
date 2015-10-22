import java.util.Vector;

/**
 * Created by Morgan on 22/10/2015.
 * Project name : GestParapente.
 */
public class GestionVolVector {

    private Vector<GestionVol> vGestionVol;


    public GestionVolVector(){
        this.vGestionVol = new Vector<>();
    }

    public void addInVgestionVol(GestionVol vol){
        this.vGestionVol.add(vol);
    }

    public Vector<GestionVol> getvGestionVol(){
        return this.vGestionVol;
    }
}
