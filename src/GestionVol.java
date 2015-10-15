import java.util.Vector;

/**
 * Created by Morgan on 15/10/2015.
 * Project name : GestParapente.
 */
public class GestionVol {

    private static int id_vol = 0;
    private Personne pilote;
    private Personne passager;
    private Parapente parapente;
    private Vol vol;

    public GestionVol(Pilote pilote, Pilote passager, Parapente parapente, Vol vol){
        this.pilote = pilote;
        this.passager = passager;
        this.parapente = parapente;
        this.vol = vol;
        id_vol++;
    }

    public GestionVol(Pilote pilote, Parapente parapente, Vol vol){
        this.pilote = pilote;
        this.parapente = parapente;
        this.vol = vol;
        id_vol++;
    }

    public static int getId_vol(){
        return id_vol;
    }

}
