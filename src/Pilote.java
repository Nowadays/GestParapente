import java.util.Date;

/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Pilote extends Personne {

    private String no_licence;
	private int niveau;

    public Pilote(String nom, String prenom, String adresse, int age, Date date_naissance, int poid, int taille, String no_telephone, String no_licence, int niveau){
        super(nom,prenom,adresse,age,date_naissance,poid,taille,no_telephone);
        this.no_licence = no_licence;
	    this.niveau = niveau;
    }

    public String getNo_licence(){
        return this.no_licence;
    }
}
