import java.util.Calendar;

/**
 * Created by deodexed on 15/10/2015.
 * Project name GestParapente
 */
public class Vol {

	private String site_depart;
	private String site_arrive;
	private Calendar jour;
	private String id_vol;
	private int duree;

	public Vol(String site_depart, String site_arrive, String id_vol, int duree){
		this.site_depart = site_depart;
		this.site_arrive = site_arrive;
		this.id_vol = id_vol;
		this.duree =duree;
	}

	public String getSite_depart(){
		return this.site_depart;
	}

	public String getSite_arrive(){
		return this.site_arrive;
	}

	public Calendar getDateVol(){
		return this.jour;
	}

	public String getId_vol(){
		return this.id_vol;
	}

	public int getDuree(){
		return this.duree;
	}

	public void setJour(){
		this.jour.set(Calendar.HOUR_OF_DAY,Calendar.DAY_OF_MONTH,Calendar.MONTH);
	}

	public String getStringJour(){
		return this.jour.toString();
	}

	public int getJourVol(){
		return this.jour.get(Calendar.DAY_OF_MONTH);
	}

	public int getHeureVol(){
		return this.jour.get(Calendar.HOUR);
	}
}
