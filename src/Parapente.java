import java.io.Serializable;

/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Parapente implements Serializable{

	private String marque;
	private String no_immatriculation;
	private String taille_voile;
	private String poid_maxi;
	private String modele;
    public static int nb_parapente = 0;

	public Parapente(String marque, String taille_voile, String poid_maxi, String modele){
	    this.marque = marque;
		this.no_immatriculation = Integer.toString(nb_parapente);
		this.taille_voile = taille_voile;
		this.poid_maxi = poid_maxi;
		this.modele = modele;
        nb_parapente++;
	}

	public String getMarque(){
		return this.marque;

	}

	public String getNo_immatriculation(){
		return this.no_immatriculation;
	}

	public String getTaille_voile(){
		return this.taille_voile;
	}

	public String getPoid_maxi(){
		return this.poid_maxi;
	}

	public String getModele(){
		return this.modele;
	}

    public static int getNb_parapente(){
        return nb_parapente;
    }
}
