import java.util.Date;

/**
 * Created by deodexed on 14/10/2015.
 * Project name GestParapente
 */
public class Passager extends Personne {

	private String id_passager;
	private String niveau;

	public Passager(String name, String lastName, String adress,String ville,String code_postal,int poid, int taille, String no_telephone, String id_passager, String niveau){
		super(name,lastName,adress,ville,code_postal,poid,taille,no_telephone);
		this.id_passager = id_passager;
		this.niveau = niveau;
	}
}
