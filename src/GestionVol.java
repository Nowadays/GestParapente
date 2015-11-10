import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Morgan on 15/10/2015.
 * Project name : GestParapente.
 */
public class GestionVol implements Serializable {

    private static int id_vol = 0;
    private Pilote pilote;
    private boolean passager;
    private Parapente parapente;
    private Vol vol;

    public GestionVol(Pilote pilote, boolean passager, Parapente parapente, Vol vol){
        this.pilote = pilote;
        this.passager = passager;
        this.parapente = parapente;
        this.vol = vol;
        id_vol++;
    }

    public GestionVol(Pilote pilote, Parapente parapente, Vol vol){
        this.pilote = pilote;
        this.passager = false;
        this.parapente = parapente;
        this.vol = vol;
        id_vol++;
    }

    public static int getId_vol(){
        return id_vol;
    }

    public Pilote get_pilote(){
	    return this.pilote;
    }

	public Parapente get_parapente(){
		return this.parapente;
	}

	public Vol get_vol(){
		return this.vol;
	}

	public String getPassager(){
		if(passager==false){
			return "Non";
		}
		else{
			return "Oui";
		}
	}



}
