import sun.util.resources.cldr.af.CalendarData_af_NA;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by deodexed on 15/10/2015.
 * Project name GestParapente
 */
public class Vol implements Serializable{

	private String site_depart;
	private String site_arrive;
	private Date jour;
	GregorianCalendar calendrier;
	private String id_vol;
	public static int id_vol_static = 0;

	public Vol(String site_depart, String site_arrive){
		this.site_depart = site_depart;
		this.site_arrive = site_arrive;
		this.id_vol = Integer.toString(id_vol_static);
		jour = new Date();
		calendrier = new GregorianCalendar();
		calendrier.setTime(jour);
		id_vol_static++;
	}

	public Vol(String site_depart, String site_arrive, GregorianCalendar calendrier){
		this.site_depart = site_depart;
		this.site_arrive = site_arrive;
		this.id_vol = Integer.toString(id_vol_static);
		this.calendrier = calendrier;
		id_vol_static++;
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

	public int getAnneeVol(){
		return this.calendrier.get(Calendar.YEAR);
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






