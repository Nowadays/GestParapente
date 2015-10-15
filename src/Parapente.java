/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Parapente {

	private String marque;
	private String no_immatriculation;
	private int taille_voile;
	private int poid_maxi;
	private String modele;
    private static int nb_parapente = 0;

	public Parapente(String marque, String no_immatriculation, int taille_voile, int poid_maxi, String modele){
	    this.marque = marque;
		this.no_immatriculation = no_immatriculation;
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

	public int getTaille_voile(){
		return this.taille_voile;
	}

	public int getPoid_maxi(){
		return this.poid_maxi;
	}

	public String getModele(){
		return this.modele;
	}

    public static int getNb_parapente(){
        return nb_parapente;
    }
}
