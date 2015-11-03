import java.util.Date;

/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Pilote extends Personne {

    private String no_licence;
    private int nb_vol_effectue = 0;
    private String niveau;
    private static int nb_pilote = 0;

    public Pilote(String nom, String prenom, String adresse,String ville,String code_postal, int poid, int taille, String no_telephone, String no_licence, String niveau){
        super(nom,prenom,adresse,ville,code_postal,poid,taille,no_telephone);
        this.no_licence = no_licence;
	    this.niveau = niveau;
        nb_pilote++;
    }

    public String getNo_licence(){
        return this.no_licence;
    }

    public static int getNb_pilote(){
        return nb_pilote;
    }

    public String getNiveau(){
        return this.niveau;
    }

    public void setNb_vol_effectue(){
        this.nb_vol_effectue++;
    }
}
