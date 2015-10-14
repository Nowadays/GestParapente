/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Pilot extends Person {

    private String licenceNumber;

    public Pilot(String name, String lastName,String adress, int age,String licenceNumber){
        super(name,lastName,adress,age);
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceNumber(){
        return this.licenceNumber;
    }
}
