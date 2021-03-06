import java.io.Serializable;
import java.util.Date;

/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Personne implements Serializable {

    private String nom;
    private String prenom;
    private String adresse;
    private int age;
	private Date date_naissance;
	private int poid;
	private int taille;
	private String no_telephone;
    private String ville;
    private String code_postal;

    public Personne(String nom, String prenom, String adresse,String ville,String code_postal, int poid, int taille, String no_telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
		this.poid = poid;
		this.taille = taille;
		this.no_telephone = no_telephone;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public int getAge(){
        return this.age;
    }

	public int getPoid(){
		return this.poid;
	}

	public int getTaille(){
		return this.taille;
	}

	public String getNo_telephone(){
		return this.no_telephone;
	}

    public String getVille(){
        return this.ville;
    }

    public String getCode_postal(){
        return this.code_postal;
    }

}
