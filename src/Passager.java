import java.util.Date;

/**
 * Created by deodexed on 14/10/2015.
 * Project name GestParapente
 */
public class Passager extends Personne {

	private String id_passager;
	private int niveau;

	public Passager(String name, String lastName, String adress,String ville,int code_postal, int age, Date date_naissance, int poid, int taille, String no_telephone, String id_passager, int niveau){
		super(name,lastName,adress,ville,code_postal,age,date_naissance,poid,taille,no_telephone);
		this.id_passager = id_passager;
		this.niveau = niveau;
	}
}
