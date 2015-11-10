import java.util.Date;
import java.util.Vector;

/**
 * Created by Morgan on 10/11/2015.
 */
public class TempsEcouleVector {
	private GestionVol gestionVols;
	private Date date;

	public TempsEcouleVector(GestionVol gestionVols,Date date){
		this.gestionVols = gestionVols;
		this.date = date;
	}

	public GestionVol getGestionVols(){
		return this.gestionVols;
	}

	public Date getDate(){
		return date;
	}
}
