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

	public Vol(){
		jour = new Calendar() {
			@Override
			protected void computeTime() {

			}

			@Override
			protected void computeFields() {

			}

			@Override
			public void add(int field, int amount) {

			}

			@Override
			public void roll(int field, boolean up) {

			}

			@Override
			public int getMinimum(int field) {
				return 0;
			}

			@Override
			public int getMaximum(int field) {
				return 0;
			}

			@Override
			public int getGreatestMinimum(int field) {
				return 0;
			}

			@Override
			public int getLeastMaximum(int field) {
				return 0;
			}
		};

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

	public void setJour(int heure, int minute , int jour, int mois) {
		this.jour.set(Calendar.DAY_OF_MONTH,jour);
		this.jour.set(Calendar.HOUR,heure);
		this.jour.set(Calendar.MONTH,mois);
		this.jour.set(Calendar.MINUTE, minute);
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

	public int getMoisVol(){
		return this.jour.get(Calendar.MONTH);
	}

	public int getMinuteVol(){
		return this.jour.get(Calendar.MINUTE);
	}

	/*public static void main(String[] args) {
		Vol vol = new Vol();
		Vol vol2 = new Vol();
		vol.setJour(10,30, 14, 12);
		System.out.println(vol.getJourVol() + "h"+ vol.getMinuteVol()+" le: " + vol.getHeureVol() + "/" + vol.getMoisVol());

	}*/
}






