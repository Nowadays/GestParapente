/**
 * Created by deodexed on 14/10/2015.
 * Project name GestParapente
 */
public class Passenger extends Person{
	private int level;

	public Passenger(String name, String lastName, String adress, int age, int level){
		super(name,lastName,adress,age);
		this.level = level;
	}
}
