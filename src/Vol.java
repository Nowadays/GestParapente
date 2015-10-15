import sun.util.resources.cldr.af.CalendarData_af_NA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by deodexed on 15/10/2015.
 * Project name GestParapente
 */
public class Vol {

	private String site_depart;
	private String site_arrive;
	private Date jour;
	Calendar calendrier;
	private String id_vol;
	private int duree;

	public Vol(String site_depart, String site_arrive, String id_vol, int duree){
		this.site_depart = site_depart;
		this.site_arrive = site_arrive;
		this.id_vol = id_vol;
		this.duree =duree;
		jour = new Date();
		calendrier = GregorianCalendar.getInstance();
		calendrier.setTime(jour);
	}

	public Vol(String site_depart, String site_arrive, String id_vol, int duree, Calendar calendrier){
		this.site_depart = site_depart;
		this.site_arrive = site_arrive;
		this.id_vol = id_vol;
		this.duree =duree;
		this.calendrier = calendrier;
	}

	public String getSite_depart(){
		return this.site_depart;
	}

	public String getSite_arrive(){
		return this.site_arrive;
	}

	public Calendar getDateVol(){
		return this.calendrier;
	}

	public String getId_vol(){
		return this.id_vol;
	}

	public int getDuree(){
		return this.duree;
	}

	public String getStringJour(){
		return this.jour.toString();
	}

	public int getJourVol(){
		return this.calendrier.get(Calendar.DAY_OF_MONTH);
	}

	public int getHeureVol(){
		return this.calendrier.get(Calendar.HOUR_OF_DAY);
	}

	public int getMoisVol(){
		return this.calendrier.get(Calendar.MONTH)+1;
	}

	public int getMinuteVol(){
		return this.calendrier.get(Calendar.MINUTE);
	}

	/*public static void main(String[] args) {
		Calendar c = GregorianCalendar.getInstance();
		c.set(1995,Calendar.DECEMBER,30);
		Vol vol = new Vol("a","b","50215",5,c);

		//vol.setJour(10,30, 14, 12);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		System.out.println(vol.getHeureVol() + "h"+ vol.getMinuteVol()+" le: " + vol.getJourVol() + "/" + vol.getMoisVol());
	}*/
}






